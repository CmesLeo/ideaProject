package com.example.demo.common.util;

import org.springframework.util.DigestUtils;

/**
 * Created by dongao on 2017/12/28.
 */
public class MD5Utils {
    public static String encrypt(String password){
        return DigestUtils.md5Digest(password.getBytes()).toString();
    }



}
