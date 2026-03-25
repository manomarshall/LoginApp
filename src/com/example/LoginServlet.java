package com.example;

import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("login.html");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if ("admin".equals(req.getParameter("username")) && "1234".equals(req.getParameter("password"))) {
            req.getSession(true).setAttribute("username", req.getParameter("username"));
            res.sendRedirect("dashboard");
        } else {
            res.sendRedirect("login.html?error=Invalid+credentials");
        }
    }
}
