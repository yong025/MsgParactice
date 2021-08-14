package org.zerock.chatting.dao;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.chatting.dto.MsgDTO;


import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Log4j2
public class MsgDAOTests {

    @Test
    public void testInsertDummies() {
        //// 람다 방식 (매개변수, ... ) -> { 실행문 ... }

        IntStream.rangeClosed(1,100).forEach(i -> {
            String who = "user" + (int)(Math.random()* 10);
            String whom = "user" + (int)(Math.random()* 10);
            String content = "Sample.." + i;

            MsgDTO dto = MsgDTO.builder()
                    .who(who)
                    .whom(whom)
                    .content(content)
                    .build();

            MsgDAO.INSTANCE.insert(dto);

        });
    }

    @Test
    public void testList() {

        Map<String, List<MsgDTO>> result = MsgDAO.INSTANCE.selectList("user5");

        log.info("받은 목록............");

        List<MsgDTO> receiveList = result.get("R");

        receiveList.forEach(msgDTO -> log.info(msgDTO));

        log.info("보낸 목록............");

        List<MsgDTO> sendList = result.get("S");

        sendList.forEach(msgDTO -> log.info(msgDTO));

    }

    @Test
    public void testSelect(){

        log.info(MsgDAO.INSTANCE.read(110L));

    }

    @Test
    public void testRemove(){

       MsgDAO.INSTANCE.remove(110L,"user");
    }
}
