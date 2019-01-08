package com.nju.tourSystem.mapper.provider;

import com.nju.tourSystem.entity.Participant;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ParticipantProvider {
    private static final String TABLE_NAME="participant";
    public String insert(Map<String,Object> para){
        Participant participant = (Participant) para.get("participant");
        if(participant!=null){
            BEGIN();
            INSERT_INTO(TABLE_NAME);
            VALUES("uid","#{participant.uid,javaType=int,jdbcType=INTEGER}");
            VALUES("aid","#{participant.aid,javaType=int,jdbcType=INTEGER}");
            VALUES("agree","#{participant.agree,javaType=boolean,jdbcType=TINYINT}");
            VALUES("score","#{participant.score,javaType=double,jdbcType=DOUBLE}");
        }
        return SQL();

    }


    public String update(Map<String,Object> para){
        Participant participant = (Participant) para.get("participant");
        BEGIN();
        UPDATE(TABLE_NAME);
        SET("uid = #{participant.uid,javaType=int,jdbcType=INTEGER}");
        SET("aid = #{participant.aid,javaType=int,jdbcType=INTEGER}");
        SET("agree = #{participant.agree,javaType=boolean,jdbcType=TINYINT}");
        SET("score = #{participant.score,javaType=double,jdbcType=DOUBLE}");
        WHERE("id = #{participant.id,javaType=int,jdbcType=INTEGER}");
        return SQL();
    }
}
