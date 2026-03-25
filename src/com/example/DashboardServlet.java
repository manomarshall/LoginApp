package com.example;

import javax.servlet.http.*;
import java.io.*;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession s = req.getSession(false);
        if (s == null || s.getAttribute("username") == null) {
            res.sendRedirect("login.html?error=Please+login+first");
            return;
        }

        String user = (String) s.getAttribute("username");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>Welcome, " + user + "</h1>");
        out.println("<p>Logged in as: " + user + "</p>");
        out.println("<p>Session timeout: 30 minutes</p>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</body></html>");
    }
}
