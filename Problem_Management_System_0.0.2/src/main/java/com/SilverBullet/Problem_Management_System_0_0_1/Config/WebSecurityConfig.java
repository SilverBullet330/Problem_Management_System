package com.SilverBullet.Problem_Management_System_0_0_1.Config;

import com.SilverBullet.Problem_Management_System_0_0_1.Service.UserLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 22823 on 2016/10/16.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//1
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/home", "/login/error", "/register").permitAll()

                .and()

                .authorizeRequests()
                    .antMatchers("/userInfoUpdate", "/userInfo", "/trolley/personal", "/trolley/deleteProblem", "/trolley/addProblem", "/user", "/userLogOut").authenticated()

                .and()

                .authorizeRequests()
                .antMatchers("/allUserInfo", "/userDelete", "/allDeletedUserInfo", "/userRecover").hasAuthority("A")

                .and()

                .csrf()
                    .disable()
                    .formLogin()
                        .loginPage("/")
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/login/success")
                        .failureForwardUrl("/login/error")
                        .permitAll()
                .and()

                    .logout()
                        .permitAll()
                        .logoutUrl("/logout");


    }

    @Bean
    UserDetailsService UserLoginService() {
        return new UserLoginService();
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(UserLoginService());
    }

}
