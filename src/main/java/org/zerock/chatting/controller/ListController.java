package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MemberDTO;
import org.zerock.chatting.dto.MsgDTO;
import org.zerock.chatting.service.MemberService;
import org.zerock.chatting.service.MsgService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Log4j2
@WebServlet(name = "ListController", value = "/msg/list")
public class ListController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("member");
        if(obj == null){
            log.info("잘못된 접근");
            response.sendRedirect("/login");
            return;
        }

        log.info("list controller do get....");

        MemberDTO dto = (MemberDTO) obj;

        String user = dto.getMid(); //쿼리에서 데이터 빨아들일때 사용

        Map<String , List<MsgDTO>> result = MsgService.INSTANCE.getList(user);

        //jsp(view)로 택배 전달
        request.setAttribute("Receive", result.get("R"));
        request.setAttribute("Send", result.get("S"));


        request.getRequestDispatcher("/WEB-INF/msg/list.jsp").forward(request,response);
    }


}
