package com.buliang.mapper;

import com.buliang.bo.ProductBo;
import com.buliang.pojo.Product;
import com.buliang.pojo.User;
import com.buliang.service.ProductService;
import com.buliang.vo.ProductCategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    List<Product> queryByPages(@Param("productBo") ProductBo productBo);
    Long count(@Param("productBo") ProductBo productBo);
    Product queryById(Integer id);
    boolean subStock(@Param("productId") Integer productId, @Param("afterSubStock") Integer afterSubStock);
}
