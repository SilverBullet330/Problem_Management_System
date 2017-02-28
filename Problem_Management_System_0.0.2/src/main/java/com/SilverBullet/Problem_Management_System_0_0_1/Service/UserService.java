package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.User;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.UserLogin;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/10/28.
 */

@Service
public class UserService {//单个用户所有信息服务
    @Autowired
    private mapper mp;

    public User getUserInfo(String id) throws Exception{
        try {
            User u = mp.userInfo(id);
            return u;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
