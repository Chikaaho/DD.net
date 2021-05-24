package net.dd.dto;

import java.io.Serializable;
import java.util.Date;

public class CourseDto implements Serializable {
    private Integer courseid;  //课程id
    private String coursename;  //课程名
    private Date starttime;  //开始时间
    private Date endtime; //结束时间
    private String classesname; //班级名
    private Integer teachernum;  //教师id

    public CourseDto() {
    }

    public CourseDto(Integer courseid, String coursename, Date starttime, Date endtime, String classesname, Integer teachernum) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.starttime = starttime;
        this.endtime = endtime;
        this.classesname = classesname;
        this.teachernum = teachernum;
    }

    public String getCoursename() {
        return coursename;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
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

    public Integer getTeachernum() {
        return teachernum;
    }

    public void setTeachernum(Integer teachernum) {
        this.teachernum = teachernum;
    }
}
