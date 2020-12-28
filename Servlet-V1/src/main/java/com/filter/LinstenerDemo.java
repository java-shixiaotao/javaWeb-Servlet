package com.filter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LinstenerDemo implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = 1;
        } else {
            onlineCount += 1;
        }

        servletContext.setAttribute("OnlineCount",onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null){
            onlineCount = 0;
        } else {
            onlineCount -= 1;
        }

        servletContext.setAttribute("OnlineCount",onlineCount);
    }
}
