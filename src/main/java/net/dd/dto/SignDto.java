package net.dd.dto;

import lombok.Data;

import java.io.Serializable;
//@Data
public class SignDto implements Serializable {
    long stunum;  //学生学号
    String classname;  //班级名
    long signid;     //签到安排的id
    String stusignstate;  //签到状态
    String coursename; //课程名

    public SignDto() {
    }

    public SignDto(long stunum, String classname, long signid, String stusignstate, String coursename) {
        this.stunum = stunum;
        this.classname = classname;
        this.signid = signid;
        this.stusignstate = stusignstate;
        this.coursename = coursename;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public long getStunum() {
        return stunum;
    }

    public void setStunum(long stunum) {
        this.stunum = stunum;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public long getSignid() {
        return signid;
    }

    public void setSignid(long signid) {
        this.signid = signid;
    }

    public String getStusignstate() {
        return stusignstate;
    }

    public void setStusignstate(String stusignstate) {
        this.stusignstate = stusignstate;
    }
}
