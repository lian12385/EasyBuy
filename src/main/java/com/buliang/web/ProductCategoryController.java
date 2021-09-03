package com.buliang.web;

import com.buliang.service.ProductCategoryService;
import com.buliang.service.ProductService;
import com.buliang.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ProductCategory")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @ResponseBody
    @GetMapping("/queryAll")
    public ProductCategoryVo getProductCategoryVo(){
        //ProductCategoryVo productCategoryVo = productCategoryService.queryAllProductCategory();
        //return productCategoryVo;
        return null;
    }
}
