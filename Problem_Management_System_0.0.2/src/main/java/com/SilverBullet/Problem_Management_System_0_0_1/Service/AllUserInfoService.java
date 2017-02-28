package com.SilverBullet.Problem_Management_System_0_0_1.Service;

import com.SilverBullet.Problem_Management_System_0_0_1.BaseClass.*;
import com.SilverBullet.Problem_Management_System_0_0_1.Mapper.mapper;
import org.apache.ibatis.session.RowBounds;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 22823 on 2016/10/28.
 */

@Service
public class AllUserInfoService {//返回所有用户信息
    @Autowired
    private mapper mp;

    public CurrentPageUserList getAllUserInfo(Page p) throws Exception{
        try {
            CurrentPageUserList currentPageUserList = new CurrentPageUserList();
            int sum = mp.userListSumGet();
            if (p.getCurrentPage() == -1 && p.getAllPages() == -1) {
                if (sum % 9 > 0 || sum == 0)
                    p.setAllPages(sum / 9 + 1);
                else
                    p.setAllPages(sum / 9);
                p.setCurrentPage(1);
                currentPageUserList.setPage(p);
                currentPageUserList.setSum(sum);
                currentPageUserList.setUserInfoList(mp.userListSelect(new RowBounds((p.getCurrentPage() - 1) * 9, 9)));
                return currentPageUserList;
            } else {
                currentPageUserList.setPage(p);
                currentPageUserList.setSum(sum);
                currentPageUserList.setUserInfoList(mp.userListSelect(new RowBounds((p.getCurrentPage() - 1) * 9, 9)));
                return currentPageUserList;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
