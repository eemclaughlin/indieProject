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
 * Servlet that works with the deleteCookbook jsp to delete a cookbook from the database.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet(urlPatterns = {"/deleteCookbook"})
public class DeleteCookbook extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet method for deleting a cookbook.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Call on the Dao for all the aspects
        GenericDao cookbookDao = new GenericDao(Cookbook.class);

        try {
            // Get the cookbook id from the request
            int cookbookId = Integer.parseInt(req.getParameter("cookbookId"));
            logger.debug("The cookbook's id is: " + cookbookId);

            // Get the cookbook from the database.
            Cookbook deleteCookbook = (Cookbook) cookbookDao.getById(cookbookId);
            logger.debug("The cookbook is: " + deleteCookbook);

            // Delete the cookbook
            cookbookDao.delete(deleteCookbook);

            // Forward to the deleteConfirmation jsp.
            RequestDispatcher dispatcher = req.getRequestDispatcher("deleteConfirmation.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("There was an error deleting the cookbook: " + e);
            //Redirect to the error page.
            resp.sendRedirect("error.jsp");
            throw new ServletException(e);
        }
    }
}
