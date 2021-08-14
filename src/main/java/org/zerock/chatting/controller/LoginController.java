package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MemberDTO;
import org.zerock.chatting.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="LoginController", value = "/login")
@Log4j2
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("do get!!!!!");

        request.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //mid,mpw,mname,nickname,regdate,moddate
        try {
            String mid = request.getParameter("mid");
            String mpw = request.getParameter("mpw");

            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            log.info("아이디 패스워드 나온다");

            HttpSession session = request.getSession();
            session.setAttribute("member", memberDTO);

            Object obj = session.getAttribute("mid");

            response.sendRedirect("/msg/list");
        }catch (Exception e){
            log.info("login failed..................");
            response.sendRedirect("/login?result=fail");
            return;
        }

    }
}
