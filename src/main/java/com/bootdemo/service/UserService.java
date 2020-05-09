package com.bootdemo.service;

import com.bootdemo.dao.UserMapper;
import com.bootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ASUS
 * @Date: 2020/3/1 17:15
 * @Version: 1.0
 */
@Service
public class UserService {
    UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUser(int userId){
        return userMapper.selectUser(userId);
    }

    public User selectUserByPhoneNumber(String phoneNumber){
        return userMapper.selectUserByPhoneNumber(phoneNumber);
    }

    public Integer selectIdByPhoneNumber(String phoneNumber){
        return userMapper.selectIdByPhoneNumber(phoneNumber);
    }
    
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
