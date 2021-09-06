package com.buliang.web;

import com.buliang.bo.NewsBo;
import com.buliang.pojo.News;
import com.buliang.service.NewsService;
import com.buliang.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//这个url没有
//http://localhost:8888/easybuy/admin/news/newDetail?id=664


@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {
    @Autowired
    NewsService newsService;
    @RequestMapping("/queryNewsList")
    public String queryNewList(@RequestParam(defaultValue = "1") Integer pageIndex, Model model){
        NewsBo newsBo = new NewsBo();
        newsBo.setPage(true);
        newsBo.setPageIndex(pageIndex);
        newsBo.setPageSize(5);

        Pages<News> newsPages = newsService.queryNewsByPage(newsBo);
        newsPages.setUrl("admin/news/queryNewsList?time="+System.currentTimeMillis());
        model.addAttribute("pager",newsPages);
        return "forward:/backend/news/newsList.jsp";
    }

    @RequestMapping("/newDetail")
    public String queryNewDetail(@RequestParam Integer id,Model model){
        News news = newsService.queryNewsDetail(id);
        model.addAttribute("news",news);
        return "forward:/backend/news/newsDetail.jsp";
    }


}
