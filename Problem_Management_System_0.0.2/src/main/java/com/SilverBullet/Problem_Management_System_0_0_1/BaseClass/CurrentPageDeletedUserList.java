package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

import java.util.List;

/**
 * Created by 22823 on 2016/12/12.
 */
public class CurrentPageDeletedUserList {
    private int sum;
    List<UserDeleted> userDeletedList;

    public void setUserDeletedList(List<UserDeleted> userDeletedList) {
        sum = userDeletedList.size();
        this.userDeletedList = userDeletedList;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public int getSum() {
        return sum;
    }
    public List<UserDeleted> getUserDeletedList() {
        return userDeletedList;
    }
}
