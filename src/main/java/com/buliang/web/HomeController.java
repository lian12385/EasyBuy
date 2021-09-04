package com.buliang.web;

import com.buliang.pojo.News;
import com.buliang.service.NewsService;
import com.buliang.service.ProductCategoryService;
import com.buliang.util.Pages;
import com.buliang.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/Home")
public class HomeController {

    //@Autowired
    //ProductCategoryService productCategoryService;

    @Resource( type = ProductCategoryService.class)
    ProductCategoryService productCategoryService;

    @Autowired
    NewsService newsService;

    @RequestMapping("/index")
    public String toIndex(Model model){

        List<ProductCategoryVo> productCategoryVoList = productCategoryService.queryAllProductCategory();
        model.addAttribute("productCategoryVoList",productCategoryVoList);

        Pages<News> newsPages = newsService.queryNewsByPage();
        model.addAttribute("news",newsPages.getRecords());

        return "forward:/pre/index.jsp";
    }
}
