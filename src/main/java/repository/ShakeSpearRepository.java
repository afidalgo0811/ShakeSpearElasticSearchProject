package repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShakeSpearRepository {

    List<Map<String, Object>> getInfoByFilterFieldsMinMax(String filter, String fieldRange,  int min, int max);
    List<Map<String, Object>> getInfoByTwoFields(String field1,String field2,String value1, String Value2);
    List<Map<String, Object>> getInfoByField(String field1, String value);
}
