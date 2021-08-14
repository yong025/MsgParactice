package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Log4j2
public class TimeDAOTests {

    @Test
    public void testGetTime() {
        log.info("test get time................");

        String timeStr= TimeDAO.INSTANCE.getTime();

        Assertions.assertNotNull(timeStr);
        //"이 테스트 결과는 null이 절대 아니다."라는 기준으로 실시해서 null값이라면 failed로 표시된다.
        //TDD - Test Driven Development
    }
}
