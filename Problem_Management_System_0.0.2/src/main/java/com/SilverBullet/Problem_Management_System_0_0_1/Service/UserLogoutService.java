package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/12/13.
 */
@Service
public class UserLogoutService{
    @Autowired
    mapper mp;
    public void userLogout(String id) {
        try {
            mp.userLogout(id);
        } catch (Exception ex) {
            throw ex;
        }
    }


}
