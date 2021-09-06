package com.buliang.mapper;

import com.buliang.bo.NewsBo;
import com.buliang.pojo.News;
import com.buliang.util.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:applicationContext.xml")
public class NewsMapperTest {


    @Autowired
    NewsMapper newsMapper;


    @Test
    public void queryNews() {
        NewsBo newsBo = new NewsBo();
        newsBo.setPage(true);
        newsBo.setPageSize(5);
        newsBo.setPageIndex(1);

        Pages<News> pagesNews = new Pages<>();
        if (newsBo == null) {
            System.out.println("null");;
        }
        pagesNews.setPageIndex(newsBo.getPageIndex());
        pagesNews.setPageSize(newsBo.getPageSize());
        pagesNews.setTotalCount(newsMapper.queryTotalCountNews(newsBo));
        List<News> news = newsMapper.queryNews(newsBo);
        pagesNews.setRecords(news);
        System.out.println(pagesNews);
    }

    @Test
    public void testQueryTotalCountNews() {
    }

    @Test
    public void queryNewsDetail() {
        newsMapper.queryNewsDetail(531);
    }
}