package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "ListController", value = "/list1")//url
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("List Controller.......");

        request.getRequestDispatcher("/WEB-INF/list1.jsp")
                .forward(request,response);

    }
}


