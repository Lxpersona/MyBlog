package com.lxpnow.blog;

import com.lxpnow.blog.mapper.UserMapper;
import com.lxpnow.blog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    UserMapper mapper;

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        System.out.println(context.getBean("pageHelper"));
    }

}

