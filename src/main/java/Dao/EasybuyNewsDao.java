package Dao;

import entity.EasybuyNews;

public interface EasybuyNewsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyNews record);

    int insertSelective(EasybuyNews record);

    EasybuyNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyNews record);

    int updateByPrimaryKey(EasybuyNews record);
}