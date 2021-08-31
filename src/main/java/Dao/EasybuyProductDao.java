package Dao;

import entity.EasybuyProduct;

public interface EasybuyProductDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyProduct record);

    int insertSelective(EasybuyProduct record);

    EasybuyProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyProduct record);

    int updateByPrimaryKey(EasybuyProduct record);
}