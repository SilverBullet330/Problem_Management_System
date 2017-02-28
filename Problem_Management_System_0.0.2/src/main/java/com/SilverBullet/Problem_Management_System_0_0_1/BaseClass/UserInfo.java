package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/12/11.
 */
public class UserInfo {
    private String id;
    private String joinTime;
    private String name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getJoinTime(){ return joinTime; }
    public void setJoinTime(String joinTime){ this.joinTime = joinTime; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
