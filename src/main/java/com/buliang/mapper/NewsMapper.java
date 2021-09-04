package com.buliang.mapper;

import com.buliang.pojo.News;
import com.buliang.pojo.User;
import com.buliang.util.Pages;

import java.util.List;

public interface NewsMapper {
    List<News> queryNews();
    Long queryTotalCountNews();
}
