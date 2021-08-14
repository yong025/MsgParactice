package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MsgDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public enum MsgDAO {
    INSTANCE; // 객체 갯수 지정

    private static final String  SQL_INSERT = "insert into tbl_msg(who, whom, content) values(?, ?, ?)";

    private static final String SQL_LIST = "select mno, who, whom, if ( whom = ?, 'R', 'S' ) kind, content, regdate, opendate\n" +
            "from\n" +
            " tbl_msg\n" +
            "where\n" +
            " whom = ? or who = ?\n" +
            "order by kind asc, mno desc";

    private static final String SQL_SELECT = "select mno,who,whom,content,regdate,opendate from tbl_msg where mno = ? ";

    private static final String SQL_UPDATE_OPEN = "update tbl_msg set opendate = now() where mno = ? ";

    private static final String SQL_REMOVE = " delete from tbl_msg where mno = ? and who = ? ";


    public MsgDTO read(Long mno) throws RuntimeException {

        MsgDTO msgDTO = MsgDTO.builder().build();

        new JdbcTemplate(){

            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_UPDATE_OPEN);
                preparedStatement.setLong(1, mno);
                preparedStatement.executeUpdate();

                preparedStatement.close();
                preparedStatement = null;//메모리에서 빨리 비우기 위해 실행한다.


                preparedStatement = connection.prepareStatement(SQL_SELECT);
                preparedStatement.setLong(1, mno);

                resultSet = preparedStatement.executeQuery();
                resultSet.next();

                log.info(resultSet);

                msgDTO.setMno(resultSet.getLong(1));
                msgDTO.setWho(resultSet.getString(2));
                msgDTO.setWhom(resultSet.getString(3));
                msgDTO.setContent(resultSet.getString(4));
                msgDTO.setRegdate(resultSet.getTimestamp(5));
                msgDTO.setOpendate(resultSet.getTimestamp(6));

            }
        }.makeAll();


        return msgDTO ;
    }

    public void insert(MsgDTO msgDTO) throws RuntimeException {

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                //who, whom, content 써야 할 것들 먼저 정리
                int idx = 1;
                preparedStatement = connection.prepareStatement(SQL_INSERT);
               preparedStatement.setString(idx++,msgDTO.getWho());
                preparedStatement.setString(idx++,msgDTO.getWhom());
                preparedStatement.setString(idx++,msgDTO.getContent());

                int count = preparedStatement.executeUpdate();
                log.info("count: " + count);
            }
        }.makeAll();

    }

    public Map<String, List<MsgDTO>> selectList(String user) throws RuntimeException{
        Map <String, List<MsgDTO>> listMap = new HashMap<>();//Map<>로 키:string, 값:msgDTO배열타입 listmap 정의
        listMap.put("R",new ArrayList<>()); // 키:R 값: 배열 키 R을 주면 그에 해당하는 배열을 가져와라
        listMap.put("S",new ArrayList<>()); // 키:S 값: 배열

        new JdbcTemplate() {

            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_LIST);
                preparedStatement.setString(1,user);
                preparedStatement.setString(2,user);
                preparedStatement.setString(3,user);

                resultSet = preparedStatement.executeQuery();

                log.info(resultSet);
                while(resultSet.next()){ //next의 리턴값이 boolean이다 . true, false

                   String kind = (resultSet.getString(4));//DB를 통해 4번째 kind컬럼을 가져와라

                   List<MsgDTO> targetList = listMap.get(kind);


                    // mno, who, whom, if ( whom = ?, 'R', 'S' ) kind, content,
                    // regdate, opendate

                    targetList.add(MsgDTO.builder()
                            .mno(resultSet.getLong(1))
                            .who(resultSet.getString(2))
                            .whom(resultSet.getString(3))
                            .content(resultSet.getString(5))
                            .regdate(resultSet.getTimestamp(6))
                            .opendate(resultSet.getTimestamp(7))
                            .build());
                }
            }
        }.makeAll();

        return listMap;
    }

    public MsgDTO remove(Long mno, String who) throws RuntimeException {// /msg/read에서 메세지 선택한 값(DB값)을 기준으로 매개인자받음

        MsgDTO msgDTO = MsgDTO.builder().build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {


                preparedStatement = connection.prepareStatement(SQL_REMOVE);
                preparedStatement.setLong(1, mno);
                preparedStatement.setString(2, who);
                preparedStatement.executeUpdate();//쿼리문에 매개인자값 담아 SQL DB에 날림.
                log.info("삭제 완료");

            }
        }.makeAll();
        return msgDTO;//msgDTO형태로 리턴
    }
}
