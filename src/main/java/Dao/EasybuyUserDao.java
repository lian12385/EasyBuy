package Dao;

import entity.EasybuyUser;

public interface EasybuyUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUser record);

    int insertSelective(EasybuyUser record);

    EasybuyUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyUser record);

    int updateByPrimaryKey(EasybuyUser record);
}