package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

/**
 * Created by 22823 on 2016/12/5.
 */
public class Page {
    private int currentPage;
    private int allPages;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public int getAllPages() {
        return allPages;
    }
    @Override
    public String toString() {
        return "/" + String.valueOf(currentPage) + "/" + String.valueOf(allPages);
    }
//    public Page getPage() {
//        return this;
//    }
}
