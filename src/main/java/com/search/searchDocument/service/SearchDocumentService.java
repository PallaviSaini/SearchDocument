package com.search.searchDocument.service;

import org.springframework.ui.ModelMap;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface SearchDocumentService {
    /**
     * Method used for searching the indexed document
     * @param files files to be scanned
     * @param searchWord search word to find in files
     * @return List<String> search Result
     */
    List<String>  getSearchResultOnIndexedDocument(File[] files,String searchWord);

    /**
     * Method used for searching the non-indexed document
     * @param files files to be scanned
     * @param modelMap
     * @param searchWord search word to find in files
     * @param choice The choice selected by the user (Fixed Word,Regular Expression)
     * @return search Result
     * @throws IOException
     */
    List<String> getSearchResultOnNonIndexedDocument(File[] files, ModelMap modelMap, String searchWord, String choice) throws IOException;
}
