package com.buliang.service;

import com.buliang.pojo.News;
import com.buliang.util.Pages;

public interface NewsService {
    Pages<News> queryNewsByPage();
}
