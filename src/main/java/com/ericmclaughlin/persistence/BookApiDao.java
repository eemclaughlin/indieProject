package com.ericmclaughlin.persistence;

import com.ericmclaughlin.api.ApiIsdnCookbook;
import com.ericmclaughlin.util.PropertiesLoader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * Dao for processing Google book API responses.
 * @author eemclaughlin
 * @version 1.0 10-10-22
 */
public class BookApiDao implements PropertiesLoader {

    // Logging
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Generic no arg constructor
     * Instantiates a new Book api dao.
     */
    public BookApiDao() {
    }

    /**
     * Gets get response info from Google Books API.
     * @return the info
     */
    public ApiIsdnCookbook getResponseInfo(String submittedIsbn) {
        // Generic client builder being build.
        Client client = ClientBuilder.newClient();

        // Instantiate the properties object
        Properties properties;

        // Variable for url path
        String urlSearchInfo = null;

        try {
            // Load the generic properties file and get the path
            properties = loadProperties("/general.properties");
            urlSearchInfo = properties.getProperty("urlSearchInfo");
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }

        // Put together the url string and the isbn for the final search.
        String urlComplete = urlSearchInfo + submittedIsbn;

        // Pass in the established url.
        WebTarget target = client.target(urlComplete);

        // Get the response data.  Make call, grab returned json data and put into string.
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Create object mapper.
        ObjectMapper mapper = new ObjectMapper();

        // Create a place to hold the response. (Upper level of package.)
        ApiIsdnCookbook responseInfo = null;
        try {
            // Do the mapper work.  Read in the response and map to class.
            responseInfo = mapper.readValue(response, ApiIsdnCookbook.class);
        } catch (JsonProcessingException e) {
           logger.debug("JSON Processing Error with Google Books API: " + e);
        }
        // Return the response.
        return responseInfo;
    }
}
