package com.ericmclaughlin.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet to log the user out of the application.
 * @author eemclaughlin
 * @version 3.0 12-10-22
 */
@WebServlet(urlPatterns = {"/logout"})
/**
 * Log User Out by invalidating the username and direct to logged out page.
 */
public class LogOut extends HttpServlet {

    /**
     * Log User Out by invalidating the username and direct to logged out page.
     * @param req  the req
     * @param resp the resp
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession userSession = req.getSession();
        String url = "Error";
        if (userSession.getAttribute("userName") != null) {
            userSession.invalidate();
            url = "logout.jsp";
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}