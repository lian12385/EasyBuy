package com.buliang.web;

import com.buliang.bo.ProductBo;
import com.buliang.pojo.Product;
import com.buliang.service.ProductCategoryService;
import com.buliang.service.ProductService;
import com.buliang.util.Pages;
import com.buliang.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/queryProductList")
    public String queryProductList(@RequestParam( defaultValue = "1") Integer level,
                                   Integer category,
                                   String keyWord,
                                   @RequestParam( defaultValue = "1") Integer pageIndex,
                                   Model model){
        ProductBo productBo = new ProductBo();
        Product product = new Product();
        product.setName(keyWord);
        switch (level){
            case 1:
                product.setCategoryLevel1Id(category);
                break;
            case 2:
                product.setCategoryLevel2Id(category);
                break;
            case 3:
                product.setCategoryLevel3Id(category);
                break;
            default:
                break;
        }
        productBo.setProduct(product);
        productBo.setPage(true);
        productBo.setPageIndex(pageIndex);
        productBo.setPageSize(6);
        Pages<Product> pages = productService.queryProductList(productBo);

        /**
         * 构建分页页码的url
         */

        pages.setUrl(creatUrl(level,category,keyWord));
        model.addAttribute("pager",pages);
        List<ProductCategoryVo> productCategoryVoList = productCategoryService.queryAllProductCategory();
        model.addAttribute("productCategoryVoList",productCategoryVoList);

        model.addAttribute("keyWord",keyWord);

        return "forward:/pre/product/queryProductList.jsp";

    }

    private String creatUrl(Integer level,
                            Integer category,
                            String keyWord){
        StringBuffer url = new StringBuffer("Product/queryProductList?time=");
        url.append(System.currentTimeMillis());
        if(category !=null){
            url.append("&category=").append(category);
        }
        if(level !=null){
            url.append("&level=").append(level);
        }
        if(keyWord != null  && keyWord.isEmpty()){
            url.append("&keyWord=").append(keyWord);
        }
        return url.toString();
    }

    @RequestMapping("/queryProductDeatil")
    public String queryProductDetail(Integer id,Model model){
        Product product = productService.queryById(id);
        model.addAttribute("product",product);
        List<ProductCategoryVo> productCategoryVoList = productCategoryService.queryAllProductCategory();
        model.addAttribute("productCategoryVoList",productCategoryVoList);
        return "forward:/pre/product/productDeatil.jsp";
    }


}
