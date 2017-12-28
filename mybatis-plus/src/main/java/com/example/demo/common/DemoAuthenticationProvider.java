package com.example.demo.common;

import com.example.demo.sys.entity.User;
import com.example.demo.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by dongao on 2017/12/28.
 */
@Component
public class DemoAuthenticationProvider implements AuthenticationProvider {

    UserDetailsService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("user name: "+authentication.getName());
        //password
        System.out.println("password: "+authentication.getCredentials());
        System.out.println("getPrincipal: "+authentication.getPrincipal());
        System.out.println("getAuthorities: "+authentication.getAuthorities());
        System.out.println("getDetails: "+authentication.getDetails());

        UserDetails userDetails = (UserDetails)this.userDetailsService.loadUserByUsername(authentication.getName());

        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                userDetails, authentication.getCredentials(),userDetails.getAuthorities());
        return result;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
