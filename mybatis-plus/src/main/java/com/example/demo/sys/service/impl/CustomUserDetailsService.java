package com.example.demo.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.sys.dao.PermissionMapper;
import com.example.demo.sys.dao.UserMapper;
import com.example.demo.sys.entity.Permission;
import com.example.demo.sys.entity.User;
import com.example.demo.sys.service.PermissionService;
import com.example.demo.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dongao on 2017/12/26.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService{

    private static Logger logger = LoggerFactory
            .getLogger(CustomUserDetailsService.class);
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EntityWrapper<User> ew = new EntityWrapper<User>();
        User user = new User();
        ew.setEntity(user);
        user.setUsername(s);
        permissionService.findAll();
        user = userService.selectByUsername(user);
        logger.debug("查询得到用户：{}", user);
        if (user == null || user.equals("")) {
            throw new UsernameNotFoundException("未查询到" + s + "用户的信息");
        }else{
            List<Permission> permissions = permissionService.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
    }
}
