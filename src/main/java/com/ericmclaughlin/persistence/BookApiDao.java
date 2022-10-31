package com.ericmclaughlin.persistence;

import com.ericmclaughlin.api.ApiIsdnCookbook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Dao for processing Google book API responses.
 * @author eemclaughlin
 * @version 1.0 10-10-22
 */
public class BookApiDao {

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

        // TODO Read in the URI from a properties file.
        String urlSearchInfo = "https://www.googleapis.com/books/v1/volumes?fields=items/volumeInfo%28title%2Cauthors%2Cpublisher%2CpublishedDate%2Cdescription%2CindustryIdentifiers%2CpageCount%2Ccategories%2CmaturityRating%2CimageLinks%2Clanguage%29&q=isbn:";

        // TODO REmove these test bits.
        String urlTestIsbn = "9780672337956";
        String urlCompleteTest = urlSearchInfo + urlTestIsbn;
        // TODO Delete Sys out print
        System.out.println(urlCompleteTest);

        // Put together the url string and the isbn for the final search.
        String urlComplete = urlSearchInfo + submittedIsbn;

        // Pass in the established url.
        // TODO Remove these manual target lines.
        //String url = "https://www.googleapis.com/books/v1/volumes?fields=items/volumeInfo%28title%2Cauthors%2Cpublisher%2CpublishedDate%2Cdescription%2CindustryIdentifiers%2CpageCount%2Ccategories%2CmaturityRating%2CimageLinks%2Clanguage%29&q=isbn:9780672337956";
        //WebTarget target = client.target(url);
        WebTarget target = client.target(urlComplete);

        // Get the response data.  Make call, grab returned json data and put into string.
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Create object mapper.
        ObjectMapper mapper = new ObjectMapper();

        // Create a place to hold the response. (Upper level of package.)
        ApiIsdnCookbook responseInfo = null;
        try {
            // Do the mapper work.  Readh in the response and map to class.
            responseInfo = mapper.readValue(response, ApiIsdnCookbook.class);
        } catch (JsonProcessingException e) {
            // TODO Set up Logging and Write This into said log.
            e.printStackTrace();
        }
        // Return the response.
        return responseInfo;
    }
}
