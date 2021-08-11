package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum TimeDAO {
    INSTANCE;

    private static final String  SQL = "select now()";


    public void getTime() {

        log.info("get time.......");

        new JdbcTemplate(){

            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL);
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                log.info(resultSet.getString(1));
            }
        }.makeAll();
    }

}
