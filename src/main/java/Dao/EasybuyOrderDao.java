package Dao;

import entity.EasybuyOrder;

public interface EasybuyOrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyOrder record);

    int insertSelective(EasybuyOrder record);

    EasybuyOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyOrder record);

    int updateByPrimaryKey(EasybuyOrder record);
}