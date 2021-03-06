package com.seu.mstc.dao;

import com.seu.mstc.model.QuestionLike;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by lk on 2018/5/3.
 */
@Mapper
public interface QuestionLikeDao {
    String TABLE_NAME=" question_like_dislike ";
    String INSERT_FIELDS="  user_id, entity_id, entity_type,  is_like, create_time  ";
    String SELECT_FIELDS=" id, " + INSERT_FIELDS;


    @Insert({"insert into ",TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{userId},#{entityId},#{entityType},#{isLike},#{createTime})"})
    int addQuestionLike(QuestionLike questionLike);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    QuestionLike selectQuestionLikeById(int id);

    @Update({"update ",TABLE_NAME, " set is_like=#{isLike} where id=#{id}"})
    void updateIsLike(QuestionLike questionLike);


}
