package com.example.demo.sys.dao;

import com.example.demo.SuperMapper;
import com.example.demo.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author AntMa
 * @since 2017-12-27
 */
@Repository
public interface UserMapper extends SuperMapper<User> {
    User selectByUsername(String name);
}