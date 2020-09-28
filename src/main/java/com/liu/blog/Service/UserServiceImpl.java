package com.liu.blog.Service;

import com.liu.blog.Dao.UserRepository;
import com.liu.blog.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liu.blog.util.MD5Utils;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);//MD5Utils.code(password)
        return user;
    }
}
