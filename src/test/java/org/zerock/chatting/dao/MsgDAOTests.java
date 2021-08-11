package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.chatting.dto.MsgDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Log4j2
public class MsgDAOTests {

    @Test
    public void testMsgInsert(){

//        IntStream.rangeClosed(1,100).forEach( i ->{
//            MsgDAO.INSTANCE.msgInsert(MsgDTO.builder()
//                    .who("who" + (int)(Math.random() * 10))
//                    .whom("whom" + (int)(Math.random()*10))
//                    .content("Sample" + i)
//                    .build());
//                 });
        IntStream.rangeClosed(1, 100).forEach(i ->{
        String who = "user" + (int)(Math.random() * 10);
        String whom = "user" + (int)(Math.random() * 10);
        String content = "Sample.." + i;

        MsgDTO dto = MsgDTO.builder()
                .who(who)
                .whom(whom)
                .content(content)
                .build();

        MsgDAO.INSTANCE.msgInsert(dto);
    });



    }

    @Test
    public void testMsgSelect(){

        Map<String, List<MsgDTO>> result = MsgDAO.INSTANCE.msgSelectList("user5");

        log.info("받은 목록");

        List<MsgDTO> receiveMsg = result.get("R");

        receiveMsg.forEach(msgDTO -> log.info(msgDTO));

        log.info("보낸 목록");

        List<MsgDTO> sendMsg = result.get("S");

        sendMsg.forEach(msgDTO -> log.info(msgDTO));



    }

}
