package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.UserDelete;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.UserRecover;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/12/12.
 */
@Service
public class UserRecoverService {
    @Autowired
    private mapper mp;

    public Boolean UserRecover(UserRecover ur) throws Exception{
        try {
            UserDelete ud = null;
            ud = mp.userDeletedSelect(ur.getId());
            if(ud == null) {
                return false;
            }
            mp.userDeletedDelete(ur);
            mp.userRecover(ud);
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
