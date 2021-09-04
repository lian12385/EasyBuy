package com.buliang.service.impl;

import com.buliang.mapper.NewsMapper;
import com.buliang.pojo.News;
import com.buliang.service.NewsService;
import com.buliang.service.ProductService;
import com.buliang.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public Pages<News> queryNewsByPage() {
        Pages<News> pagesNews = new Pages<>();
        pagesNews.setPageIndex(0);
        pagesNews.setPageSize(6);
        pagesNews.setTotalCount(newsMapper.queryTotalCountNews());
        List<News> news = newsMapper.queryNews();
        pagesNews.setRecords(news);
        return pagesNews;

    }
}
