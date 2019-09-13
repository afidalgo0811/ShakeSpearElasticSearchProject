package repository;


import model.Metrics;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLoadRepo {

    String Insert(String indexName, String indexType, Metrics metric);
    
}
