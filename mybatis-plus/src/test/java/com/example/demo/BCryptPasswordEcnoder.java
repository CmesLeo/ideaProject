package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by dongao on 2017/12/28.
 */
public class BCryptPasswordEcnoder {

    public static void main(String[] args){
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String code = bc.encode("admin");
        System.out.println(code);
    }

}
