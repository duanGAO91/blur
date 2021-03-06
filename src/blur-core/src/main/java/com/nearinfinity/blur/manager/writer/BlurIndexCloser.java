package com.nearinfinity.blur.manager.writer;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.lucene.index.IndexReader;

import com.nearinfinity.blur.concurrent.Executors;
import com.nearinfinity.blur.log.Log;
import com.nearinfinity.blur.log.LogFactory;

public class BlurIndexCloser implements Runnable {

  private static final Log LOG = LogFactory.getLog(BlurIndexCloser.class);
  private static final long PAUSE_TIME = TimeUnit.SECONDS.toMillis(1);
  private Thread daemon;
  private Collection<IndexReader> readers = new LinkedBlockingQueue<IndexReader>();
  private AtomicBoolean running = new AtomicBoolean();
  private ExecutorService executorService;

  public void init() {
    running.set(true);
    daemon = new Thread(this);
    daemon.setDaemon(true);
    daemon.setName(getClass().getName() + "-Daemon");
    daemon.start();
    LOG.info("Init Complete");
    executorService = Executors.newThreadPool("Blur Index Closer Pool", 10);
  }

  public void close() {
    running.set(false);
    daemon.interrupt();
    executorService.shutdownNow();
  }

  public void close(IndexReader reader) {
    readers.add(reader);
  }

  @Override
  public void run() {
    while (running.get()) {
      try {
        tryToCloseReaders();
      } catch (Throwable t) {
        LOG.error("Unknown error", t);
      }
      try {
        Thread.sleep(PAUSE_TIME);
      } catch (InterruptedException e) {
        return;
      }
    }
  }

  private void tryToCloseReaders() {
    LOG.debug("Trying to close [{0}] readers", readers.size());
    Iterator<IndexReader> it = readers.iterator();
    while (it.hasNext()) {
      IndexReader reader = it.next();
      if (reader.getRefCount() == 1) {
        it.remove();
        closeInternal(reader);
      } else {
        LOG.debug("Could not close indexreader [" + reader + "] because of ref count [" + reader.getRefCount() + "].");
      }
      closeInternal(reader);
    }
  }

  private void closeInternal(final IndexReader reader) {
    executorService.submit(new Runnable() {
      @Override
      public void run() {
        try {
          long s = System.currentTimeMillis();
          reader.close();
          long e = System.currentTimeMillis();
          LOG.debug("Size [{0}] time to close [{1}] Closing indexreader [{2}].", readers.size(), (e-s), reader);
        } catch (Exception e) {
          readers.add(reader);
          LOG.error("Error while trying to close indexreader [" + reader + "].", e);
        }
      }
    });
  }
}