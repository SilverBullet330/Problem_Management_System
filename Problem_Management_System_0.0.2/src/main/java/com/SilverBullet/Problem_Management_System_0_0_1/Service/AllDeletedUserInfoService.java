package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.CurrentPageDeletedUserList;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.CurrentPageUserList;
import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.Page;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 22823 on 2016/12/12.
 */
@Service
public class AllDeletedUserInfoService {
    @Autowired
    mapper mp;

    public CurrentPageDeletedUserList getAllDeletedUserInfo() throws Exception{
        try {
            CurrentPageDeletedUserList currentPageDeletedUserList = new CurrentPageDeletedUserList();
            int sum = mp.deletedUserListSumGet();
            currentPageDeletedUserList.setUserDeletedList(mp.deletedUserListSelect());
            return currentPageDeletedUserList;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
