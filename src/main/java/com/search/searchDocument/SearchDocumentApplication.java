package com.search.searchDocument;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Main class for startup of spring boot application
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.search.searchDocument.repository")
public class SearchDocumentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchDocumentApplication.class, args);
	}

	/**
	 * Method for creating bean of RestHighLevelClient type,
	 * this is used to set configuration related to elastic search server
	 * @return RestHighLevelClient
	 */
	@Bean
	public RestHighLevelClient client() {
		ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200").build();
		return RestClients.create(clientConfiguration).rest();
	}

	/**
	 * Method for creating bean of ElasticsearchRestTemplate type
	 * @return ElasticsearchRestTemplate
	 */
	@Bean
	public ElasticsearchRestTemplate elasticsearchTemplate() {
		return new ElasticsearchRestTemplate(client());
	}

}
