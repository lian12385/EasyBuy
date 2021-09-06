package com.buliang.mapper;

import com.buliang.bo.NewsBo;
import com.buliang.pojo.News;
import com.buliang.pojo.User;
import com.buliang.util.Pages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    List<News> queryNews(@Param("newsBo") NewsBo newsBo);
    Long queryTotalCountNews(@Param("newsBo") NewsBo newsBo);
    News queryNewsDetail(@Param("id") Integer id);
}
