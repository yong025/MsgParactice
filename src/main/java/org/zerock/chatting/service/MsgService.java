package org.zerock.chatting.service;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dao.MsgDAO;
import org.zerock.chatting.dto.MsgDTO;


import java.util.List;
import java.util.Map;

@Log4j2
public enum MsgService { //고객의 요구사항을 반영하는 계층

    INSTANCE;

    public void register(MsgDTO msgDTO) throws RuntimeException{

        log.info("service register....." + msgDTO);

        MsgDAO.INSTANCE.insert(msgDTO);
    }

    public Map<String, List<MsgDTO>> getList(String user) throws RuntimeException {//DTO는 중요한 데이터단위가 된다.
       long start = System.currentTimeMillis();

       Map<String ,List<MsgDTO>> result = MsgDAO.INSTANCE.selectList(user);

       long end = System.currentTimeMillis();

       log.info("Time: " + (end - start));

       return result;


    }

    public MsgDTO read(Long mno){
        log.info("read~~~~");

        return MsgDAO.INSTANCE.read(mno);
    }

    public void remove(MsgDTO msgDTO) throws RuntimeException{//DAO에서 리턴한 값을 매개인자로 받음

        log.info("remove ~~~~");

        MsgDAO.INSTANCE.remove(msgDTO.getMno(),msgDTO.getWho());//DAO를 참조해 받은 값을 remove메서드 실행

    }
}