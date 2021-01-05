package com.search.searchDocument.repository;

import com.search.searchDocument.model.Cars;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Elastic Search Repository for performing crud operations on the indexed file
 */
@Repository
public interface CarsInterface extends ElasticsearchRepository<Cars, String> {
}
