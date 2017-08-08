package com.test.mapper;

import com.test.entity.Corp;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CorpMapper {

    @Select("SELECT * FROM corp WHERE corpId = 1")
    Corp get();

    @Update("UPDATE corp SET corpName=#{corpName},corpAddress=#{corpAddress},corpContact=#{corpContact},corpEmail=#{corpEmail},corpIntro=#{corpIntro} WHERE corpId=1")
    void update(Corp corp);

}
