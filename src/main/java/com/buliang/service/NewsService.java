package com.buliang.service;

import com.buliang.bo.NewsBo;
import com.buliang.pojo.News;
import com.buliang.util.Pages;

public interface NewsService {
    Pages<News> queryNewsByPage(NewsBo newsBo);
    News queryNewsDetail(Integer id);
}
