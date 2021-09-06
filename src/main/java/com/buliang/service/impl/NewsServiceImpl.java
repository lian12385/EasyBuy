package com.buliang.service.impl;

import com.buliang.bo.NewsBo;
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
    public Pages<News> queryNewsByPage(NewsBo newsBo) {
        Pages<News> pagesNews = new Pages<>();
        if (newsBo == null) {
            return null;
        }
        pagesNews.setPageIndex(newsBo.getPageIndex());
        pagesNews.setPageSize(newsBo.getPageSize());
        pagesNews.setTotalCount(newsMapper.queryTotalCountNews(newsBo));
        List<News> news = newsMapper.queryNews(newsBo);
        pagesNews.setRecords(news);
        return pagesNews;
    }

    @Override
    public News queryNewsDetail(Integer id) {
        return newsMapper.queryNewsDetail(id);
    }
}
