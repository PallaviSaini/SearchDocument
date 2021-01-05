package com.search.searchDocument.service;

import com.search.searchDocument.model.Cars;
import com.search.searchDocument.util.SearchDocumentConstants;
import org.apache.lucene.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class SearchDocumentServiceImpl implements  SearchDocumentService{

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public List<String> getSearchResultOnIndexedDocument(File[] files,String searchWord) {
        List<String> searchResult = new ArrayList<>();
        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(matchQuery("maker", searchWord))
                .withPageable(PageRequest.of(0, 20))
                .build();
        for (File file : files) {
            String indexName = file.getName().split("\\.")[0];
            long scrollTimeout = 10000;
            SearchScrollHits<Cars> carsSearchHits =
                    elasticsearchRestTemplate.searchScrollStart
                            (scrollTimeout, searchQuery, Cars.class, IndexCoordinates.of(indexName));
            searchResult.add(SearchDocumentConstants.RESULT_OUTPUT_1 + carsSearchHits.getTotalHits() +
                    SearchDocumentConstants.RESULT_OUTPUT_2+ file.getName());
        }
        return  searchResult;
    }

    public List<String> getSearchResultOnNonIndexedDocument(File[] files, ModelMap modelMap, String searchWord, String choice) throws IOException {
        List<String> searchResult = new ArrayList<>();
        for (File file : files) {
            String[] words;
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
            int count = 0;
            while ((s = br.readLine()) != null) {
                words = s.split(",");
                count = findMatches(words, choice, count, searchWord);

            }
            if (count != 0) {
                searchResult.add(SearchDocumentConstants.RESULT_OUTPUT_1+ count +
                        SearchDocumentConstants.RESULT_OUTPUT_2+ file.getName());
            }
            IOUtils.close(fr);
        }
        return searchResult;
    }

    private int findMatches(String[] words, String choice, int count, String searchWord) {
        if (SearchDocumentConstants.SIMPLE_MATCH.equalsIgnoreCase(choice)) {
            for (String word : words) {
                if (word.equals(searchWord)) {
                    count++;
                }
            }
        } else if (SearchDocumentConstants.REG_EXP_MATCH.equalsIgnoreCase(choice)) {
            for (String word : words) {
                if (word.matches(searchWord)) {
                    count++;
                }
            }
        }
        return count;
    }
}
