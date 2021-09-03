package com.buliang.mapper;

import com.buliang.pojo.ProductCategory;
import com.buliang.pojo.User;
import com.buliang.vo.ProductCategoryVo;

import java.util.List;

public interface ProductCategoryMapper {
    public List<ProductCategory> queryByType(int i);
    public List<ProductCategory> queryByParentId(Integer id);
}
