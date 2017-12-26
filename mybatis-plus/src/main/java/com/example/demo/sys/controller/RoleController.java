package com.example.demo.sys.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.sys.entity.Role;
import com.example.demo.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author AntMa
 * @since 2017-12-26
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public Page addRole(Role role, Model model){
      return   roleService.selectPage(new Page<Role>());
    }
}
