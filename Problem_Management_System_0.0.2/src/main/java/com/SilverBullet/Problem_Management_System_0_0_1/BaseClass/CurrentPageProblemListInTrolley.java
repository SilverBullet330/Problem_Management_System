package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

import java.util.List;

/**
 * Created by 22823 on 2016/12/12.
 */
public class CurrentPageProblemListInTrolley extends Page{
    private int currentSum;
    //private int sum;
    List<ProblemInfo> problemInfoList;
    public void setProblemInfoList(List<ProblemInfo> problemInfoList) {
        if(problemInfoList != null)
            currentSum = problemInfoList.size();
        this.problemInfoList = problemInfoList;
    }
    public int getCurrentSum() {
        return currentSum;
    }
    public List<ProblemInfo> getProblemInfoList() {
        return problemInfoList;
    }
}
