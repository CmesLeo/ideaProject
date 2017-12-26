package com.example.demo.sys.util;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by dongao on 2017/12/26.
 */
public class MyPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean accessable = false;
        if(authentication.getPrincipal().toString().compareToIgnoreCase("anonymousUser")!=0){
            String privilege = targetDomainObject+"_"+permission;
            for(GrantedAuthority authority:authentication.getAuthorities()){
                if(authority.getAuthority().compareToIgnoreCase(privilege) == 0){
                    accessable=true;
                    break;
                }
            }
            return accessable;
        }
        return accessable;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return true;
    }
}
