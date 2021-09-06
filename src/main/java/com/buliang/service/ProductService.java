package com.buliang.service;

import com.buliang.bo.ProductBo;
import com.buliang.pojo.Product;
import com.buliang.util.Pages;
import com.buliang.vo.ProductCategoryVo;

public interface ProductService {
    Pages<Product> queryProductList(ProductBo productBo);
    Product queryById(Integer id);
}
