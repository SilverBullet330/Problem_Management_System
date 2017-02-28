package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

import java.util.List;

/**
 * Created by 22823 on 2016/12/11.
 */
public class CurrentPageUserList {
    private int currentSum;
    private int sum;
    Page page;
    List <UserInfo> userInfoList;

    public CurrentPageUserList() {
        Page page = new Page();
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public void setPage(Page page) {
        this.page = page;
    }
    public void setUserInfoList(List<UserInfo> userInfoList) {
        currentSum = userInfoList.size();
        this.userInfoList = userInfoList;
    }
    public int getCurrentSum() {
        return currentSum;
    }
    public int getSum() {
        return sum;
    }
    public Page getPage() {
        return page;
    }
    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }
}
