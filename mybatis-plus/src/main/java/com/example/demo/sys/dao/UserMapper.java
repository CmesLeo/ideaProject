package com.example.demo.sys.dao;

import com.example.demo.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
  * 系统用户 Mapper 接口
 * </p>
 *
 * @author AntMa
 * @since 2017-12-26
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}