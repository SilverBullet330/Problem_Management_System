package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/11/5.
 */
public class UserDelete {
    private String id;
    private String password;
    private String joinTime;
    private String name;
    private String authority;
    private String handleId;
    private String deleteTime;

    public void fillWithUser(User u) {
        this.id = u.getId();
        this.password = u.getPassword();
        this.joinTime = u.getJoinTime();
        this.name = u.getName();
        this.authority = u.getAuthority();
    }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
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
    public String getHandleId() {
        return handleId;
    }
    public String getDeleteTime() {
        return deleteTime;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public void setHandleId(String handleId) {
        this.handleId = handleId;
    }
    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }
}
