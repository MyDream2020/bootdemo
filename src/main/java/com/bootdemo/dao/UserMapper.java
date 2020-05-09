package com.bootdemo.dao;

import com.bootdemo.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: ASUS
 * @Date: 2020/3/1 17:13
 * @Version: 1.0
 */
@Repository
public interface UserMapper {
    User selectUser(int userId);

    User selectUserByPhoneNumber(String phoneNumber);

    Integer selectIdByPhoneNumber(String phoneNumber);

    int insertUser(User user);
}
