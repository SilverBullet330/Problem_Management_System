package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.HttpJsonResponse;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 22823 on 2016/10/14.
 */
@Service
public class UserRegisterService {
    @Autowired
    private mapper mp;

    public int register(UserRegister ur) throws Exception {//用户注册服务先填充缺省信息再判断是否已注册
        try {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(now);
            ur.setJoinTime(today);
            ur.setAuthority("B");
            String exist = null;
            exist = mp.userExist(ur.getId());
            if(exist != null) {
                return -1;
            } else
            {
                if(mp.userRegister(ur) == 1)
                    return 1;
                else
                    return 0;
            }
        }catch (Exception ex) {
            throw ex;
        }
    }
}
