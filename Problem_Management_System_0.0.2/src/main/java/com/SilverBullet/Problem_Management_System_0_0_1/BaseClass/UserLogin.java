package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/10/16.
 */
public class UserLogin{//用户登陆基类
    private String id;
    private String password;
    private Character authority;

    public UserLogin(String id, String password, Character authority) {
        this.id = id;
        this.password = password;
        this.authority = authority;
    }
    public UserLogin() {

    }
    public void setid(String id) {
        this.id = id;
    }
    public String getId() {
        return  id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return  password;
    }
    public void setAuthority(Character authority) { this.authority = authority; }
    public Character getAuthority() { return authority; }

}
