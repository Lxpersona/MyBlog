package com.lxpnow.blog.secruity;
//2019/3/7  16:22

import com.lxpnow.blog.entity.User;
import com.lxpnow.blog.mapper.UserMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class BlogUserServiceDetail implements UserDetailsService {


    @Autowired
    UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(s);
        return user;
    }



}
