package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.UserLogin;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 22823 on 2016/10/18.
 */
public class UserLoginService implements UserDetailsService {//用户登陆服务需实现并重写Spring Boot提供的用户登陆信息服务
    @Autowired
    private mapper mp;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserLogin ul = null;
        try {
            ul = mp.sqlById(id);
            if (ul == null) {
                throw new UsernameNotFoundException("用户名不存在");
            }
            Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(ul.getAuthority().toString()));
            if(mp.userOnlineNum() == 0 )
                mp.userOnline(id);
            return new org.springframework.security.core.userdetails.User(ul.getId(), ul.getPassword(),authorities);
        } catch (Exception ex) {
            throw new UsernameNotFoundException(ex.toString());
        }
    }
}
