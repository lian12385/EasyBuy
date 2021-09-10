package com.buliang.mapper;

import com.buliang.bo.UserBo;
import com.buliang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User getUser(Integer id);
    int addUser(User user);
    User queryById(Integer id);
    User login(String name);
    List<User> queryAll();
    int delete(Integer id);
    int update(User user);
    Long queryTotalCountUsers(@Param("userBo") UserBo userBo);
    List<User> queryUsers(@Param("userBo") UserBo userBo);
}
