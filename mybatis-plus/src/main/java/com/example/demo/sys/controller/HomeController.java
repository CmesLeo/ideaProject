package com.example.demo.sys.controller;

import com.example.demo.sys.service.PermissionService;
import com.example.demo.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dongao on 2017/12/26.
 */
@Controller
@RequestMapping
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/","/home"})
    public String getHomePage() {

        System.out.println(userService.selectById(1));
        LOGGER.debug("Getting home page");
        return "home";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/hello")
    public String toHello(Model model) {
        LOGGER.debug("Getting hello page");
        model.addAttribute("user","user");
        return "hello";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/say")
    public String say(Model model) {
        LOGGER.debug("Getting hello page");
        System.out.println("...................");
        model.addAttribute("user","user");
        return "hello";
    }

    @PostAuthorize("hasPermission('ADMIN')")
    @RequestMapping(value = "/say1")
    @ResponseBody
    public String say1(Model model) {
        LOGGER.debug("Getting hello page");
        System.out.println("...................");
        return "hello";
    }

    @RequestMapping(value = "/api/test")
    @ResponseBody
    public String say2(Model model) {
        LOGGER.debug("Getting hello page");
        System.out.println("...................");
        return "hello";
    }
}
