package com.example.demo.sys.dao;

import com.example.demo.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author AntMa
 * @since 2017-12-27
 */
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(User user);
}