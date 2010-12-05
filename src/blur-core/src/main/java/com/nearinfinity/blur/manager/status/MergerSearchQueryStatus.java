package com.nearinfinity.blur.manager.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import com.nearinfinity.blur.thrift.generated.SearchQueryStatus;
import com.nearinfinity.blur.utils.BlurExecutorCompletionService;
import com.nearinfinity.blur.utils.ForkJoin.Merger;

public class MergerSearchQueryStatus implements Merger<List<SearchQueryStatus>> {

    @Override
    public List<SearchQueryStatus> merge(BlurExecutorCompletionService<List<SearchQueryStatus>> service) throws Exception {
        Map<Long,SearchQueryStatus> statusMap = new HashMap<Long,SearchQueryStatus>();
        while (service.getRemainingCount() > 0) {
            Future<List<SearchQueryStatus>> future = service.poll();
            addToMap(statusMap,future.get());
        }
        return new ArrayList<SearchQueryStatus>(statusMap.values());
    }

    private void addToMap(Map<Long, SearchQueryStatus> statusMap, List<SearchQueryStatus> list) {
        for (SearchQueryStatus status : list) {
            SearchQueryStatus searchQueryStatus = statusMap.get(status.uuid);
            if (searchQueryStatus == null) {
                statusMap.put(status.uuid, searchQueryStatus);
            } else {
                statusMap.put(status.uuid, merge(searchQueryStatus,status));
            }
        }
    }

    private SearchQueryStatus merge(SearchQueryStatus s1, SearchQueryStatus s2) {
        s1.complete = avg(s1.complete,s2.complete);
        s1.cpuTime = s1.cpuTime + s2.cpuTime;
        s1.interrupted = s1.interrupted || s2.interrupted;
        s1.realTime = s1.realTime + s2.realTime;
        s1.running = s1.running || s2.running;
        return s1;
    }

    private double avg(double... ds) {
        double result = 0.0;
        for (int i = 0; i < ds.length; i++) {
            result += ds[i];
        }
        return result / (double) ds.length;
    }

}