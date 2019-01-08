package com.nju.tourSystem.mapper.provider;

import com.nju.tourSystem.entity.Activity;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ActivityProvider {
    private static final String TABLE_NAME="activity";
    public String insert(Map<String,Object> para){
        Activity activity = (Activity) para.get("activity");
        if(activity!=null){
            BEGIN();
            INSERT_INTO(TABLE_NAME);
            VALUES("name","#{activity.name,javaType=String,jdbcType=VARCHAR}");
            VALUES("description","#{activity.description,javaType=String,jdbcType=VARCHAR}");
            VALUES("createdTime","#{activity.createdTime,javaType=String,jdbcType=VARCHAR}");
            VALUES("deadline","#{activity.deadline,javaType=String,jdbcType=VARCHAR}");
            VALUES("organizerId","#{activity.organizerId,javaType=int,jdbcType=INTEGER}");
            VALUES("maxNum","#{activity.maxNum,javaType=int,jdbcType=INTEGER}");
        }
        return SQL();

    }


    public String update(Map<String,Object> para){
        Activity activity = (Activity) para.get("activity");
        BEGIN();
        UPDATE(TABLE_NAME);
        SET("name = #{activity.name,javaType=String,jdbcType=VARCHAR}");
        SET("description = #{activity.description,javaType=String,jdbcType=VARCHAR}");
        SET("createdTime = #{activity.createdTime,javaType=String,jdbcType=VARCHAR}");
        SET("deadline = #{activity.deadline,javaType=String,jdbcType=VARCHAR}");
        SET("organizerId = #{activity.organizerId,javaType=int,jdbcType=INTEGER}");
        SET("maxNum = #{activity.maxNum,javaType=int,jdbcType=INTEGER}");
        WHERE("id = #{activity.id,javaType=int,jdbcType=INTEGER}");
        return SQL();
    }
}
