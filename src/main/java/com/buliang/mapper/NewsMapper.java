package com.buliang.mapper;

import com.buliang.pojo.News;
import com.buliang.pojo.User;

public interface NewsMapper {
    public User getNew(Integer id);
    public User addNew(News news);
    public User queryById(Integer id);
}
