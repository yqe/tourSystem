package com.nju.tourSystem.mapper;

import com.nju.tourSystem.entity.Comment;
import com.nju.tourSystem.mapper.provider.CommentProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment WHERE id = #{id}")
    Comment getCommentById(int id);

    @Select("SELECT * FROM comment WHERE receiverUid = #{receiverUid} and checked = 0 ORDER BY commentTime DESC")
    List<Comment> getNewCommentListByReceiverUid(String receiverUid);

    @Select("SELECT * FROM comment WHERE receiverUid = #{receiverUid} and checked = 1 ORDER BY commentTime DESC")
    List<Comment> getHistoryCommentListByReceiverUid(String receiverUid);

    @InsertProvider(type = CommentProvider.class,method = "insert")
    Boolean insert(@Param("comment")Comment comment);

    @UpdateProvider(type = CommentProvider.class,method = "update")
    Boolean update(@Param("comment")Comment comment);
}
