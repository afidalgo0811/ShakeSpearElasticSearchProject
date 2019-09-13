package services;

import config.ElasticConfig;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Index;
import model.Metrics;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.stereotype.Service;
import repository.InvoiceLoadRepo;

import java.sql.Timestamp;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Author   : Alberto Fidalgo
 * Date     : March 13, 2019
 */

@Service
public class InvoiceLoadService implements InvoiceLoadRepo {

    private ElasticConfig elasticConfig;

    public InvoiceLoadService() {

        elasticConfig = new ElasticConfig();
    }

    @Override
    public String Insert(String indexName, String indexType, Metrics metric) {

        Index index;
        JestResult result = null;
        JestClient esClient = elasticConfig.createInstance();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {

            String time = timestamp.toLocalDateTime().toString();
            XContentBuilder builder = jsonBuilder().startObject().field("FileName", metric.getFileName())
                    .field("BillingDate", metric.getBillingDate())
                    .field("RowCount", metric.getRowCount())
                    .field("StartingRowCount", metric.getStartingRowCount())
                    .field("timestamp", time)
                    .field("ExpectedRowCount", metric.getExpectedRowCount()).endObject();

            System.err.println(time);
            System.err.println(builder.toString());

            index = new Index.Builder(Strings.toString(builder)).index(indexName).type(indexType).build();
            result = esClient.execute(index);


        } catch (Exception ex) {

            System.err.println(ex.getMessage());
        }

        return result.getJsonString();
    }
}
