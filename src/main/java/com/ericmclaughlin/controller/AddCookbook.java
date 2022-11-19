package com.ericmclaughlin.controller;

import com.ericmclaughlin.api.ItemsItem;
import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.entity.UserCookbooks;
import com.ericmclaughlin.persistence.BookApiDao;
import com.ericmclaughlin.persistence.GenericDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addCookbook")
public class AddCookbook extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Daos for Recipes and for Cookbooks.
        GenericDao cookbookDao = new GenericDao(Cookbook.class);
        GenericDao userDao = new GenericDao(User.class);
        GenericDao userCookbookDao = new GenericDao(UserCookbooks.class);

        // Get information entered from the form
        String isbn = req.getParameter("isbn");

        // TODO Remove Sys. out prints
        System.out.println("Add Cookbook Java isbn " + isbn);

        // TODO Get cookbook from API with ISBN
        // Method for checking api with ISBN
        //try {
        //    getBookDataFromApi(isbn);
        //} catch (Exception e) {
        //    throw new RuntimeException(e);
        //}

        // Instantiate a new dao to get a book data response.
        BookApiDao dao = new BookApiDao();

        String title = null;
        String author = null;
        String publisher = null;
        String publishedDate = null;
        String description = null;
        String isdnTen = null;
        String isdnThirteen = null;
        int pageCount = 0;
        String language = null;
        String smallImageLink = null;
        String mediumImageLink = null;



        // Get data from API and populate into variables.
        for (ItemsItem item : dao.getResponseInfo(isbn).getItems()) {

            title = item.getVolumeInfo().getTitle();
            publisher = item.getVolumeInfo().getPublisher();
            publishedDate = item.getVolumeInfo().getPublishedDate() + "-01";
            description = item.getVolumeInfo().getDescription();
            //isdnTen = null;
            //isdnThirteen = null;
            pageCount = item.getVolumeInfo().getPageCount();
            language = item.getVolumeInfo().getLanguage();
            smallImageLink = item.getVolumeInfo().getImageLinks().getSmallThumbnail();
            mediumImageLink = item.getVolumeInfo().getImageLinks().getThumbnail();

            // For each author in array at second half of "for"...
            for(String arrayAuthor : item.getVolumeInfo().getAuthors()) {
                //author = item.getVolumeInfo().getAuthors().toString();
                author = arrayAuthor;
            }

            // Get ISBN 10 and 13.
            for (int i = 0; i < item.getVolumeInfo().getIndustryIdentifiers().size(); i++) {
                if (item.getVolumeInfo().getIndustryIdentifiers().get(i).getType().equals("ISBN_10")) {
                    isdnTen = item.getVolumeInfo().getIndustryIdentifiers().get(i).getIdentifier();
                } else if (item.getVolumeInfo().getIndustryIdentifiers().get(i).getType().equals("ISBN_13")) {
                    isdnThirteen = item.getVolumeInfo().getIndustryIdentifiers().get(i).getIdentifier();
                }
            }
        }


        HashMap<String, String> newCookbookParts = new HashMap();
        newCookbookParts.put("cbTitle", title);
        newCookbookParts.put("cbAuthor", author);
        newCookbookParts.put("cbPublisher", publisher);
        newCookbookParts.put("cbPublishedDate", publishedDate);
        newCookbookParts.put("cbDescription", description);
        newCookbookParts.put("cbIsdnTen", isdnTen);
        newCookbookParts.put("cbIsdnThirteen", isdnThirteen);
        newCookbookParts.put("cbPageCount", String.valueOf(pageCount));

        req.setAttribute("newCookbookParts", newCookbookParts);



        //TODO Delete Sys out print
        System.out.println("Title " + title);
        System.out.println("author " + author);
        System.out.println("Publisher " + publisher);
        System.out.println("PubDate " + publishedDate);
        System.out.println("Desc " + description);
        System.out.println("Ten " + isdnTen);
        System.out.println("Thirteen " + isdnThirteen);
        System.out.println("page count " + pageCount);
        System.out.println("Lang " + language);
        System.out.println("Small " + smallImageLink);
        System.out.println("Med " + mediumImageLink);

        // TODO Take API data and add to database.
        // Establish session to get user id.
        HttpSession session = req.getSession();
        int finalUserId = (int)session.getAttribute("userId");

        // Get user object by id
        User user = (User) userDao.getById(finalUserId);

        Cookbook cookbook = new Cookbook(title, author, publisher, publishedDate, description, isdnTen, isdnThirteen, pageCount, language, smallImageLink, mediumImageLink);
        cookbookDao.insert(cookbook);



        UserCookbooks userCookbook = new UserCookbooks(user, cookbook);
        userCookbookDao.insert(userCookbook);

        // user.addCookbook(cookbook);

        // TODO Redirect to Results page where user can see cookbook data that was added.
        // Redirect back to user homepage.
        //String url = "userHomepage";
        //resp.sendRedirect(url);
        // Return list of results as attributes to the results page.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addCookbookResults.jsp");
        dispatcher.forward(req, resp);
    }
}


