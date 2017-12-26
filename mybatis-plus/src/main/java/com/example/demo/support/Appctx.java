package com.example.demo.support;

import org.springframework.context.ApplicationContext;

/**
 * Created by dongao on 2017/12/26.
 */
public class Appctx {
    public static ApplicationContext ctx=null;
    public static Object getObject(String string){
        return ctx.getBean(string);
    }
}
