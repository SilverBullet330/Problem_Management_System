package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/10/29.
 */
public class ProblemInfo {
    private String pid;
    private String difficulty;

    public ProblemInfo() {}
    public ProblemInfo(String pid, String difficulty) {
        this.pid = pid;
        //this.cid = cid;
        //this.chapter = chapter;
        this.difficulty = difficulty;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getPid() {
        return pid;
    }
    /*public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCid() {
        return cid;
    }
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
    public String getChapter() {
        return chapter;
    }*/
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getDifficulty() {
        return difficulty;
    }
    /*public static ProblemInfo convertFromString(String s) {
        ProblemInfo p = new ProblemInfo();
        p.setPid(Integer.parseInt(s.substring(0, s.indexOf(","))));
        p.setDifficulty(s.substring(s.lastIndexOf(",") + 1, s.length()));
        s = s.substring(s.indexOf(",") + 1, s.lastIndexOf(","));
        p.setCid(s.substring(0, s.indexOf(",")));
        p.setChapter(s.substring(s.indexOf(",") + 1));
        return p;
    }*/
}
