package com.mould;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *cookie 和 session
 *
 */
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                String value = cookies[i].getValue();
                writer.println("cookie的value值" + value);
            }
        }else {
            writer.println("第一次进入页面没有携带cookie");
        }
        Cookie cookie = new Cookie("localDateTime", dtf.format(LocalDateTime.now()));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
