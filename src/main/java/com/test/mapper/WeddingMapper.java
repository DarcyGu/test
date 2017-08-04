package com.test.mapper;

import com.test.entity.Wedding;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WeddingMapper {

    @Select("SELECT * FROM wedding")
    List<Wedding> getAll();

    @Select("SELECT * FROM wedding WHERE weddingId = #{weddingId}")
    Wedding getOne(int weddingId);

    @Insert("INSERT INTO wedding(weddingName,weddingStyle,weddingPrice,weddingIntro,weddingHotel,weddingPic) VALUES(#{weddingName},#{weddingStyle},#{weddingPrice},#{weddingIntro},#{weddingHotel},#{weddingPic})")
    void insert(Wedding wedding);

    @Update("UPDATE wedding SET weddingName=#{weddingName},weddingStyle=#{weddingStyle},weddingPrice=#{weddingPrice},weddingIntro=#{weddingIntro},weddingHotel=#{weddingHotel},weddingPic=#{weddingPic} WHERE weddingId =#{weddingId}")
    void update(Wedding wedding);

    @Delete("DELETE FROM wedding WHERE weddingId =#{weddingId}")
    void delete(int weddingId);

}