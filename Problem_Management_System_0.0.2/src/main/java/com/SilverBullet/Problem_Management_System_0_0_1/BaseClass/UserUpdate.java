package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/10/22.
 */
public class UserUpdate {//用户信息更新基类
    private String id;//主键不进行更新
    private String name;
    private String password;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword(){ return password; }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) { this.password = password; }
}
