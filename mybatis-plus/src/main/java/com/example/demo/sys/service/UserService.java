package com.example.demo.sys.service;

import com.example.demo.sys.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AntMa
 * @since 2017-12-27
 */
public interface UserService extends IService<User> {

    User selectByUsername(User user);
}
