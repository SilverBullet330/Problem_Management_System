package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/10/28.
 */
public class User {//用户所有信息基类
    private String id;
    private String password;
    private String joinTime;
    private String name;
    private String authority;
    private int online;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getJoinTime(){ return joinTime; }
    public void setJoinTime(String joinTime){ this.joinTime = joinTime; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public int getOnline() {
        return online;
    }
    public void setOnline(int online) {
        this.online = online;
    }
}
