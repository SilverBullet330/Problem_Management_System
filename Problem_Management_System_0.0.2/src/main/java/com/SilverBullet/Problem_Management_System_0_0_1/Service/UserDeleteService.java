package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.User;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.UserDelete;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 22823 on 2016/11/6.
 */
@Service
public class UserDeleteService {
    @Autowired
    private mapper mp;

    public Boolean UserDelete(UserDelete ud) throws Exception{
        try {
            User u = null;
            u = mp.userInfo(ud.getId());
            if(u == null) {
                return false;
            }
            ud.fillWithUser(u);
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(now);
            ud.setDeleteTime(today);
            mp.userDelete(ud.getId());
            mp.deletedUserInsert(ud);
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
