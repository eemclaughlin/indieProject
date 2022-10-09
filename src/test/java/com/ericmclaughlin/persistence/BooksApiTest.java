package com.ericmclaughlin.persistence;

import com.ericmclaughlin.api.ApiIsdnCookbook;
import com.ericmclaughlin.api.ItemsItem;
import com.ericmclaughlin.api.VolumeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooksApiTest {
    @Test
    public void getBooksSuccess() throws Exception {
        Client client = ClientBuilder.newClient();
        // WebTarget target = client.target("https://www.googleapis.com/books/v1/volumes?fields=items/volumeInfo&q=isbn:9780672337956");
        // WebTarget target = client.target("https://openlibrary.org/isbn/9781260440218.json");
        String url = "https://www.googleapis.com/books/v1/volumes?fields=items/volumeInfo%28title%2Cauthors,publisher,publishedDate,description,industryIdentifiers,pageCount,categories,maturityRating,imageLinks,language%29&q=isbn:9780672337956";

        WebTarget target = client.target(url);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        ApiIsdnCookbook info = mapper.readValue(response, ApiIsdnCookbook.class);
        // ItemsItem info = mapper.readValue(response, ItemsItem.class);

        String expectedValue = "Sam's Publishing";
        //assertEquals(expectedValue, info.getItems());
        // assertEquals(expectedValue, response);
        }
}
