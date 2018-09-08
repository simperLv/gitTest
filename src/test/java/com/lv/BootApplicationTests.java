package com.lv;

import com.lv.model.User;
import com.lv.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    @Resource
    private UserService userService;
    @Autowired
    private User user;

    @Test
    @Rollback
    public void contextLoads() {
            user.setUserPassword("123456");
            //user.setUserName("user");
        System.out.println("=========>"+userService.findUser(user).toString());
    }

}
