package com.buliang.service.impl;

import com.buliang.bo.ProductBo;
import com.buliang.mapper.ProductMapper;
import com.buliang.pojo.Product;
import com.buliang.service.ProductService;
import com.buliang.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Pages<Product> queryProductList(ProductBo productBo) {
        if( productBo == null){
            return null;
        }
        Pages<Product> pages = new Pages<>();
        pages.setPageIndex(productBo.getPageIndex());
        pages.setPageSize(productBo.getPageSize());
        System.out.println(productBo.getStartIndex());
        pages.setTotalCount(productMapper.count(productBo));
        pages.setRecords(productMapper.queryByPages(productBo));

        return pages;
    }

    @Override
    public Product queryById(Integer id) {
        if(id == null){
            return null;
        }
        return productMapper.queryById(id);
    }
}
