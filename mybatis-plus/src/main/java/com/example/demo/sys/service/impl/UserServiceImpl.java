package com.example.demo.sys.service.impl;

import com.example.demo.sys.entity.User;
import com.example.demo.sys.dao.UserMapper;
import com.example.demo.sys.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author AntMa
 * @since 2017-12-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
    private UserMapper userMapper;


	public void addUser(){
	    userMapper.selectById(1);
    }
}
