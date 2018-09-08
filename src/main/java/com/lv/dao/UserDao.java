package com.lv.dao;

import com.lv.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by simperLv
 * on 2018/08/13 16:39
 *
 * @Description //TODO
 */
@Mapper
public interface UserDao {
    int addUser(User user);
    User findUser(User user);
}
