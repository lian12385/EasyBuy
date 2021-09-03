package com.buliang.vo;

import com.buliang.pojo.Product;
import com.buliang.pojo.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class  ProductCategoryVo {
    private ProductCategory productCategory;
    private List<ProductCategoryVo> productCategoryVoList = new ArrayList<>(); //二级分类
    private List<Product> productList;
}
