package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/12/4.
 */
public class TrolleyPicking {
    private String pid;
    private String id;
    public void setPid(String pid) {
        this.pid = pid;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPid() {
        return pid;
    }
    public String getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(o instanceof TrolleyPicking) {
            TrolleyPicking temp = (TrolleyPicking) o;
            if(this.id.equals(temp.id) && this.pid.equals(temp.pid)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
