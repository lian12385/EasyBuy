package Dao;

import entity.EasybuyUserAddress;

public interface EasybuyUserAddressDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EasybuyUserAddress record);

    int insertSelective(EasybuyUserAddress record);

    EasybuyUserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EasybuyUserAddress record);

    int updateByPrimaryKey(EasybuyUserAddress record);
}