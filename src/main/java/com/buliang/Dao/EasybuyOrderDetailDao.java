package com.buliang.Dao;

import com.buliang.entity.EasybuyOrderDetail;

public interface EasybuyOrderDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyOrderDetail record);

    int insertSelective(EasybuyOrderDetail record);

    EasybuyOrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyOrderDetail record);

    int updateByPrimaryKey(EasybuyOrderDetail record);
}