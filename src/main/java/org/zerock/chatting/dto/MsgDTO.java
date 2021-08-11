package org.zerock.chatting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MsgDTO {

    private Long mno;
    private String who,whom,content;
    private Timestamp regdate;
    private Timestamp opendate;

}
