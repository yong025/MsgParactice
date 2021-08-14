package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MemberDTO;
import org.zerock.chatting.dto.MsgDTO;
import org.zerock.chatting.service.MemberService;
import org.zerock.chatting.service.MsgService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet (name = "ReadController", value="/msg/read")
public class ReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        Object obj = session.getAttribute("member");
        if(obj == null){
            log.info("잘못된 접근");
            response.sendRedirect("/login");
            return;
        }

        Long mno = Long.parseLong(request.getParameter("mno"));

        MsgDTO msgDTO = MsgService.INSTANCE.read(mno);



        request.setAttribute("dto", msgDTO);
        request.getRequestDispatcher("/WEB-INF/msg/read.jsp").forward(request, response);

    }
}
