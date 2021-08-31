package com.buliang.Dao;

import com.buliang.entity.EasybuyProductCategory;

public interface EasybuyProductCategoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyProductCategory record);

    int insertSelective(EasybuyProductCategory record);

    EasybuyProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyProductCategory record);

    int updateByPrimaryKey(EasybuyProductCategory record);
}