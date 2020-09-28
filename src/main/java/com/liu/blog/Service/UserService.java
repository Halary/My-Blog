package com.liu.blog.Service;

import com.liu.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
