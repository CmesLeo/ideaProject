package com.example.demo.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.sys.entity.User;
import com.example.demo.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 * Created by dongao on 2017/12/26.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.setEntity(new User());
        ew.where("username={0}", s);
        User user = userService.selectOne(ew);
        if (user == null || user.equals("")) {
            throw new UsernameNotFoundException("未查询到" + s + "用户的信息");
        }
        System.out.println(user);
        return  user;
    }
}
