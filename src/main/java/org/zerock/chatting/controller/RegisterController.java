package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MsgDTO;
import org.zerock.chatting.service.MsgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "RegisterController" , value = "/msg/register")
public class RegisterController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("member");
        if(obj == null){
            log.info("잘못된 접근");
            response.sendRedirect("/login");
            return;
        }

        log.info("등록 화면 조회");

        request.getRequestDispatcher("/WEB-INF/msg/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //한글처리
        request.setCharacterEncoding("UTF-8");
        //who,whom,content

        String who = request.getParameter("who");
        String whom = request.getParameter("whom");
        String content = request.getParameter("content");

        log.info("who:" + who);
        log.info("whom: " + whom);
        log.info("content: " + content);

        //파라미터 수집 -> MsgDTO를 생성

        MsgDTO msgDTO = MsgDTO.builder()
                .who(who)
                .whom(whom)
                .content(content)
                .build();

        //MsgService의 register( ) 호출

        MsgService.INSTANCE.register(msgDTO);

        //리다이렉트

        response.sendRedirect("/msg/list?whom=" + who );
    }
}
