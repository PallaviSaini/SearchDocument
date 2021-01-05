package com.search.searchDocument.controller;

import ch.qos.logback.classic.LoggerContext;
import com.search.searchDocument.service.SearchDocumentService;
import com.search.searchDocument.util.SearchDocumentConstants;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Search Document controller called from browser
 */
@Controller
@RequestMapping("/searchDocument")
public class SearchDocumentController {

    @Autowired
    SearchDocumentService searchDocumentService;

    Logger logger = LoggerFactory.getLogger(SearchDocumentController.class);

    /**
     * Method used for opening search page for the user
     * @param map Model Map
     * @return the name of the view page to be rendered
     */
    @GetMapping(value = "/openSearchPage")
    public String openSearchPage(ModelMap map) {
        logger.info("request for openSearchPage initiated");
        return "searchPage";
    }

    /**
     * Method used for searching Words on the basis of choice selected
     * @param searchWord The Word on the basis of which search needs to be performed
     * @param choice The choice selected by the user (Fixed Word,Regular Expression,Indexed Match)
     * @param modelMap
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/searchOnBasisOfChoice")
    public String searchOnBasisOfChoice(@RequestParam("searchWord") String searchWord, @RequestParam("choice") String choice, ModelMap modelMap) throws IOException {
        StopWatch watch = new StopWatch();
        watch.start();
        if (!SearchDocumentConstants.INDEXED_MATCH.equalsIgnoreCase(choice)) {
            searchOnStringMatch(searchWord, modelMap, choice);
        } else {
            searchOnIndexedDocument(searchWord, modelMap);
        }
        watch.stop();
        modelMap.put(SearchDocumentConstants.ELAPSED_TIME, watch.getTotalTimeSeconds());
        return "resultPage";
    }

    /**
     * Method used for searching document document on the basis of "Indexed Match" choice
     * @param searchWord
     * @param modelMap
     */
    private void searchOnIndexedDocument(String searchWord, ModelMap modelMap) {
        File[] files = traverseFileDirectory();
        List<String> searchResult = searchDocumentService.getSearchResultOnIndexedDocument(files,searchWord);
        modelMap.put(SearchDocumentConstants.RESPONSE_MSG, searchResult);
    }

    /**
     * Method used for traverse file directory
     * @return
     */
    private File[] traverseFileDirectory() {
        return new File(SearchDocumentConstants.FILE_PATH).listFiles();
    }

    /**
     * Method used for searching document document on the basis of "Fixed Word/Regular Expression" choice
     * @param searchWord
     * @param modelMap
     * @param choice
     * @throws IOException
     */
    private void searchOnStringMatch(String searchWord, ModelMap modelMap, String choice) throws IOException {
        File[] files = traverseFileDirectory();
        List<String> responseString = searchDocumentService.getSearchResultOnNonIndexedDocument(files, modelMap, searchWord, choice);
        modelMap.put(SearchDocumentConstants.RESPONSE_MSG, responseString);
    }


}
