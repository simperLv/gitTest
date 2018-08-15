package com.lv.service;

import com.lv.model.User;

/**
 * Created by simperLv
 * on 2018/08/13 16:44
 *
 * @Description //TODO
 */
public interface UserService {
    int addUser(User user);
    int login(User user);
}
