package org.example.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.example.userservice.entity.User;
import org.example.userservice.mapper.UserMapper;
import org.example.userservice.service.UserService;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
