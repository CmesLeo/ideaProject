package com.example.demo.config;

import com.example.demo.common.DemoAuthenticationProvider;
import com.example.demo.sys.handle.LoginSuccessHandler;
import com.example.demo.sys.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by dongao on 2017/12/26.
 */
@Configuration
@EnableGlobalMethodSecurity
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home","/").permitAll()//访问：/home 无需登录认证权限
                .anyRequest().authenticated() //其他所有资源都需要认证，登陆后访问
                .antMatchers("/hello").hasAuthority("ADMIN")
                .antMatchers("/say").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
             //   .successHandler(loginSuccessHandler())
                .and()
                .logout()
                .permitAll()//注销请求可直接用
                .invalidateHttpSession(true)
                .and()
                .rememberMe()//登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
                .tokenValiditySeconds(1209600);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
        auth
                //.inMemoryAuthentication()
                // .withUser("mazeyi").password("123").roles("ADMIN");
               // .authenticationProvider(getDemoAuthenticationProvider())
        .userDetailsService(getCustomUserDetailsService())
        .passwordEncoder(passwordEncoder());
      /*  auth.userDetailsService(customUserDetailsService);

        auth.eraseCredentials(false);
        auth.authenticationProvider(daoAuthenticationProvider(new DaoAuthenticationProvider()));*/
    }

    @Bean
    public CustomUserDetailsService getCustomUserDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public DemoAuthenticationProvider getDemoAuthenticationProvider(){
        return new DemoAuthenticationProvider();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
