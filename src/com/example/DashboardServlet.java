package com.example;

import javax.servlet.http.*;
import java.io.*;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession s = req.getSession(false);
        if (s == null || s.getAttribute("username") == null) { res.sendRedirect("login.html?error=Please+login+first"); return; }

        String user = (String) s.getAttribute("username");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'/><title>Dashboard</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap' rel='stylesheet'/>");
        out.println("<style>");
        out.println("*{box-sizing:border-box;margin:0;padding:0}");
        out.println("body{font-family:Inter,sans-serif;min-height:100vh;background:linear-gradient(135deg,#0f0c29,#302b63,#24243e);display:flex;align-items:center;justify-content:center}");
        out.println(".card{background:rgba(255,255,255,.07);backdrop-filter:blur(20px);border:1px solid rgba(255,255,255,.15);border-radius:24px;padding:2.5rem;max-width:480px;width:100%;box-shadow:0 25px 60px rgba(0,0,0,.4);text-align:center}");
        out.println(".avatar{width:70px;height:70px;background:linear-gradient(135deg,#6c63ff,#3ecf8e);border-radius:50%;display:flex;align-items:center;justify-content:center;font-size:1.8rem;margin:0 auto 1rem}");
        out.println(".badge{display:inline-block;background:rgba(62,207,142,.15);border:1px solid rgba(62,207,142,.4);color:#3ecf8e;font-size:.75rem;font-weight:600;padding:3px 12px;border-radius:999px;margin-bottom:1rem}");
        out.println("h1{color:#fff;font-size:1.6rem;margin-bottom:.3rem}");
        out.println("p{color:rgba(255,255,255,.5);font-size:.85rem;margin-bottom:1.5rem}");
        out.println(".row{background:rgba(255,255,255,.05);border:1px solid rgba(255,255,255,.08);border-radius:12px;padding:.9rem 1.2rem;text-align:left;margin-bottom:.8rem}");
        out.println(".lbl{font-size:.7rem;color:rgba(255,255,255,.4);text-transform:uppercase;letter-spacing:.06em}.val{color:#fff;font-weight:600;font-size:.9rem}");
        out.println("a{display:block;margin-top:1.2rem;padding:.8rem;background:linear-gradient(135deg,#ff416c,#ff4b2b);color:#fff;font-weight:600;border-radius:12px;text-decoration:none;transition:opacity .2s}a:hover{opacity:.88}");
        out.println("</style></head><body><div class='card'>");
        out.println("<div class='avatar'>&#128100;</div><span class='badge'>&#10003; Authenticated</span>");
        out.println("<h1>Welcome, " + user + "!</h1><p>You are securely logged in</p>");
        out.println("<div class='row'><div class='lbl'>Logged in as</div><div class='val'>" + user + "</div></div>");
        out.println("<div class='row'><div class='lbl'>Session timeout</div><div class='val'>30 minutes</div></div>");
        out.println("<a href='logout'>&#128682; Logout</a></div></body></html>");
    }
}
