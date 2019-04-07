package com.lxpnow.blog.mapper;

import com.lxpnow.blog.entity.User;

public interface UserMapper {

   User getUserByUsername(String username);

   void saveUser(User user);

   User getUserByEmail(String email);

}
