package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum TimeDAO {

    INSTANCE; // enum은 객체갯수 선언
    // 외부에서 선언시 TimeDAO.INSTANCE.getTIME으로 선언 가능

    private static final String SQL = "select now()"; //바꾸지 않을 변수는 final로 선언

    public String getTime()throws RuntimeException {

        StringBuffer buffer = new StringBuffer();

        //(JdbcTemplate)() -> {}).makeAll(); 이렇게 람다로 변경하고 싶다...
        new JdbcTemplate() {// jdbctemplate클래스의 execute 메서드 재정의 필요
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL);//출력
                resultSet = preparedStatement.executeQuery();//입력
                resultSet.next();
                buffer.append(resultSet.getString(1));//resultset을 통해 첫번째 문장 읽어라.
            }
        }.makeAll();


        return buffer.toString(); //return값은 buffer로 반환.
    }
}
