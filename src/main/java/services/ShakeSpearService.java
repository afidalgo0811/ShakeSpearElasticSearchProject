package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShakeSpearService {

    private static final String INDEX = "shakespeare";
    private static final String TYPE = "line";
    private RestHighLevelClient restHighLevelClient;
    private ObjectMapper objectMapper;

//    /**
//     *
//     * @param restHighLevelClient
//     * @param objectMapper
//     */
//    public ShakeSpearService(RestHighLevelClient restHighLevelClient,ObjectMapper objectMapper){
//
//        this.objectMapper = objectMapper;
//        this.restHighLevelClient = restHighLevelClient;
//    }

    public List<Map<String, Object>> getInfoByFilterFieldsMinMax(String filter, String fieldRange, int min, int max) {
        return null;
    }


    public List<Map<String, Object>> getInfoByTwoFields(String field1, String field2, String value1, String Value2) {
        return null;
    }


    public List<Map<String, Object>> getInfoByField(String value) {

        SearchSourceBuilder requestBuilder;
        SearchRequest searchRequest;
        SearchResponse getResponse;
        List<Map<String, Object>> sourceAsMap = null;

        try {
            requestBuilder = new SearchSourceBuilder();
            requestBuilder.query(QueryBuilders.matchQuery("line_id", value));
            requestBuilder.size(500);
            searchRequest = new SearchRequest();
            searchRequest.indices(INDEX); //only search the index that we want
            searchRequest.source(requestBuilder);
            getResponse = restHighLevelClient.search(searchRequest);
            sourceAsMap = new ArrayList<>();
            if(getResponse != null){
                for(SearchHit hit: getResponse.getHits().getHits()){
                    sourceAsMap.add(hit.getSourceAsMap());
                }
            }
        }catch (java.io.IOException ex) {

            System.err.println(ex.getLocalizedMessage());

        }
        return sourceAsMap;
    }
}
