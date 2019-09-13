package config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "repository")
public class ElasticConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ElasticConfig.class);
    private JestClient esClient;


    public JestClient createInstance(){

        return buildClient();
    }

    private JestClient buildClient() {

        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        esClient = factory.getObject();

        return esClient;
    }

}
