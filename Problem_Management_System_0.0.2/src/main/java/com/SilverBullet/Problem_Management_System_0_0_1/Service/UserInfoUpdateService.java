package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.UserUpdate;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/10/25.
 */
@Service
public class UserInfoUpdateService{
    @Autowired
    private mapper mp;

    public Boolean update(UserUpdate up) throws Exception{//用户更新服务
        try {
            mp.userUpdate(up);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
