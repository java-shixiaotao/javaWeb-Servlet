package com.mould;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ContextResp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   /*     PrintWriter writer = resp.getWriter();
        writer.println("Hello world");*/
        ServletContext servletContext = this.getServletContext();
        Object userName = servletContext.getAttribute("userName");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("名字：" +  userName);
    }
}
