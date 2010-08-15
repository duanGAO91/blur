namespace java com.nearinfinity.blur.thrift.generated

struct Hit {
  1:string id,
  2:double score,
  3:string reason = "UNKNOWN"
}

struct Hits {
  1:i64 totalHits = 0,
  2:map<string,i64> shardInfo,
  3:list<Hit> hits
}

struct TableDescriptor {
  1:string analyzerDef,
  2:string partitionerClass,
  3:map<string,string> shardDirectoryLocation
}

enum ScoreType {
  SUPER,
  AGGREGATE,
  BEST_SCORE
}

exception BlurException {
  1:string message
}

service Blur {

list<string> tableList() throws (1:BlurException ex)

void enable(1:string table) throws (1:BlurException ex)

void disable(1:string table) throws (1:BlurException ex)

void create(1:string table, 2:TableDescriptor desc) throws (1:BlurException ex)

void drop(1:string table) throws (1:BlurException ex)

TableDescriptor describe(1:string table) throws (1:BlurException ex)

Hits search(1:string table, 2:string query, 3:bool superQueryOn, 4:ScoreType type, 5:i64 start, 6:i32 fetch) throws (1:BlurException ex)

i64 countSearch(1:string table, 2:string query, 3:bool superQueryOn, 4:i64 minimum) throws (1:BlurException ex)

list<string> getDynamicTerms(1:string table) throws (1:BlurException ex)

string getDynamicTermQuery(1:string table, 2:string term) throws (1:BlurException ex)

void createDynamicTermQuery(1:string table, 2:string term, 3:string query, 4:bool superQueryOn) throws (1:BlurException ex)

void deleteDynamicTermQuery(1:string table, 2:string term) throws (1:BlurException ex)

}