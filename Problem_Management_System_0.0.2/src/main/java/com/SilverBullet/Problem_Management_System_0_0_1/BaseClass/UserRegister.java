package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/10/22.
 */
public class UserRegister {//用户注册基类
    private String id;
    private String joinTime;
    private String name;
    private String authority;
    private String password;

    public UserRegister() {

    }
    public UserRegister(String id, String name, String authority, String password) {
        super();
        this.id = id;
        this.name = name;
        this.authority = authority;
        this.password = password;
    }
    public String getId() {
        return id;
    }
    public String getJoinTime() {
        return joinTime;
    }
    public String getName() {
        return name;
    }
    public String getAuthority() {
        return authority;
    }
    public String getPassword(){ return password; }
    public void setId(String id) {
        this.id = id;
    }
    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public void setPassword(String password) { this.password = password; }
}
