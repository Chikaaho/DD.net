package net.dd.pojo;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
    private int courseid;
    private String coursename;
    private Date starttime;
    private Date endtime;
    private String classesname;
    private long teachernum;
    private String major;

    public Course(){};

    public Course(int courseid, String coursename, Date starttime, Date endtime, String classesname, long teachernum, String major) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.starttime = starttime;
        this.endtime = endtime;
        this.classesname = classesname;
        this.teachernum = teachernum;
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getClassesname() {
        return classesname;
    }

    public void setClassesname(String classesname) {
        this.classesname = classesname;
    }

    public long getTeachernum() {
        return teachernum;
    }

    public void setTeachernum(long teachernum) {
        this.teachernum = teachernum;
    }
}
