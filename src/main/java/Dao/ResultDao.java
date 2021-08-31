package Dao;

import entity.Result;

public interface ResultDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Result record);

    int insertSelective(Result record);

    Result selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);
}