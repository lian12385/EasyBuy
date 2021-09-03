package com.buliang.service.impl;

import com.buliang.bo.ProductBo;
import com.buliang.mapper.ProductCategoryMapper;
import com.buliang.mapper.ProductMapper;
import com.buliang.pojo.Product;
import com.buliang.pojo.ProductCategory;
import com.buliang.service.ProductCategoryService;
import com.buliang.util.Pages;
import com.buliang.vo.ProductCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Autowired
    ProductMapper productMapper;


    @Override
    public List<ProductCategoryVo> queryAllProductCategory() {

        ProductBo productBo = new ProductBo();
        productBo.setPage(true);
        productBo.setStartIndex(0);
        productBo.setPageSize(5);

        Product product = new Product();
        productBo.setProduct(product);

        //分类一
        List<ProductCategoryVo> firstProductCategoryVoList = new ArrayList<>();

        List<ProductCategory> firstProductCategoryList = productCategoryMapper.queryByType(1);
        for (ProductCategory firstProductCategory : firstProductCategoryList) {
            ProductCategoryVo firstProductCategoryVo = new ProductCategoryVo();
            firstProductCategoryVo.setProductCategory(firstProductCategory);

            //分类二
            List<ProductCategoryVo> secondProductCategoryVoList = new ArrayList<>();

            List<ProductCategory> secondProductCategoryList = productCategoryMapper.queryByParentId(firstProductCategory.getId());
            for (ProductCategory secondProductCategory : secondProductCategoryList) {
                ProductCategoryVo secondProductCategoryVo = new ProductCategoryVo();
                secondProductCategoryVo.setProductCategory(secondProductCategory);

                //分类三
                List<ProductCategoryVo> threeProductCategoryVoList = new ArrayList<>();

                List<ProductCategory> threeProductCategoryList = productCategoryMapper.queryByParentId(secondProductCategory.getId());
                for (ProductCategory threeProductCategory : threeProductCategoryList) {
                    ProductCategoryVo threeProductCategoryVo = new ProductCategoryVo();
                    threeProductCategoryVo.setProductCategory(threeProductCategory);

                    threeProductCategoryVoList.add(threeProductCategoryVo);
                }
                secondProductCategoryVo.setProductCategoryVoList(threeProductCategoryVoList);
                secondProductCategoryVoList.add(secondProductCategoryVo);

            }

            firstProductCategoryVo.setProductCategoryVoList(secondProductCategoryVoList);

            product.setCategoryLevel1Id(firstProductCategory.getId());
            List<Product> productList = productMapper.queryByPages(productBo);
            firstProductCategoryVo.setProductList(productList);

            firstProductCategoryVoList.add(firstProductCategoryVo);
        }
        return firstProductCategoryVoList;
    }
}
