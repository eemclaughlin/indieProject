package com.ericmclaughlin.controller;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Outputs all the details on a specific cookbook.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet(urlPatterns = {"/detailCookbook"})
public class DetailCookbook extends HttpServlet {

    // Create a logger for this class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method for detailing out a cookbook to the user.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        try {
            // Get the cookbook id from the request
            int cookbookId = Integer.parseInt(req.getParameter("cookbookId"));
            logger.debug("The cookbook's id is: " + cookbookId);

            // Get the cookbook from the database.
            Cookbook detailCookbook = (Cookbook) cookbookDao.getById(cookbookId);
            logger.debug("The recipe is: " + detailCookbook);

            // Set the cookbook as an attribute
            req.setAttribute("detailCookbook", detailCookbook);

            // Forward to the jsp.
            RequestDispatcher dispatcher = req.getRequestDispatcher("detailCookbook.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            logger.error("There was an error getting the cookbook: " + e);
            //Redirect to the error page.
            resp.sendRedirect("error.jsp");
            throw new ServletException(e);
        }
    }
}
