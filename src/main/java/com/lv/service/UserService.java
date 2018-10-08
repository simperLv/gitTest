package com.lv.service;

import com.lv.model.User;

import java.util.List;

/**
 * Created by simperLv
 * on 2018/08/13 16:44
 *
 * @Description //TODO
 */
public interface UserService {
    int addUser(User user);

    List<User> findUser(User user);
}
