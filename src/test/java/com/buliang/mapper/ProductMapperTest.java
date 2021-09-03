package com.buliang.mapper;

import com.buliang.bo.ProductBo;
import com.buliang.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:applicationContext.xml")
public class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;
    @Test
    public void queryByPages() {
        ProductBo productBo = new ProductBo();
        productBo.setPage(true);
        productBo.setPageSize(5);
        productBo.setStartIndex(0);

        Product product = new Product();
        productBo.setProduct(product);
        product.setCategoryLevel1Id(548);
        //product.setName("香");

        productMapper.queryByPages(productBo);
    }
}