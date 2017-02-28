package com.SilverBullet.Problem_Management_System_0_0_1.BaseClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 22823 on 2016/11/28.
 */
public class ProblemCondition {
    private String list;
    private String type;
    private String page;
    private Page p;
    private Course c;
    private String classification;
    private String faculty;
    private String subject;
    private String problemType;
    private static Map<String, String> categoryFirstMap = new HashMap<>();
    private static Map<String, String> categorySecondMap = new HashMap<>();
    private static Map<String, String> categoryThirdMap = new HashMap<>();
    private static Map<String, String> typeMap = new HashMap<>();


    ProblemCondition() {
        categoryFirstMap.put("AL1", "All");
        categoryFirstMap.put("ENG", "Engineering");
        categoryFirstMap.put("NAS", "NaturalScience");
        categoryFirstMap.put("LAW", "Law");
        categoryFirstMap.put("LIT", "Literature");
        categorySecondMap.put("AL2", "All");
        categorySecondMap.put("CS_", "ComputerScienceAndTechnology");
        categorySecondMap.put("EST", "ElectronicScienceAndTechnology");
        categorySecondMap.put("MAM", "MathematicsAndAppliedMathematics");
        categorySecondMap.put("LAW", "Law");
        categorySecondMap.put("ENG", "English");
        c = new Course();
        typeMap.put("*", "All");
        typeMap.put("1","Choice");
        typeMap.put("2", "FillBlank");
        p = new Page();
    }
    public void setList(String list) {
        this.list = list;
    }
    public String getList() {
        return list;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public String getPage() {
        return page;
    }
    public void handleString() {
        classification = categoryFirstMap.get(list.substring(0, 3));
        faculty = categorySecondMap.get(list.substring(3, 6));
        subject = c.getCname();
        problemType = typeMap.get(type);
        c.setCid(list.substring(6, 14));
        p.setCurrentPage(Integer.parseInt(page.substring(0, page.indexOf("/"))));
        p.setAllPages(Integer.parseInt(page.substring(page.indexOf("/")+1, page.length())));
    }
    public String getClassification() {
        return classification;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) { this.subject = subject; }
    public String getProblemType() {
        return problemType;
    }
    public String getP() {
        return p.toString();
    }
    public Page getPageP() {
        return p;
    }
    public Course getC() {return c; }
}
