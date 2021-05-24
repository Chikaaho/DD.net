package net.dd.pojo;

import java.io.Serializable;

public class Banji implements Serializable {
    private Integer classesid; //id
    private String classname; //班级名
    private Integer stunum; //班级人数
    private String major;  //专业

    public Banji(Integer classesid, String classname, Integer stunum, String major) {
        this.classesid = classesid;
        this.classname = classname;
        this.stunum = stunum;
        this.major = major;
    }

    public Banji() {

    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getStunum() {
        return stunum;
    }

    public void setStunum(Integer stunum) {
        this.stunum = stunum;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
