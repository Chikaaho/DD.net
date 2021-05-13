package net.dd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


public class SignPlanDto implements Serializable {
    private int id;
    private String classname;  //班级名
    private int signstate;    //签到表是否激活 0表示未激活 1表示激活
    private long signid;      //签到表id  根据当天的日期定义
    private String coursename; //课程名

    public SignPlanDto(int id, String classname, int signstate, long signid, String coursename) {
        this.id = id;
        this.classname = classname;
        this.signstate = signstate;
        this.signid = signid;
        this.coursename = coursename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getSignstate() {
        return signstate;
    }

    public void setSignstate(int signstate) {
        this.signstate = signstate;
    }

    public long getSignid() {
        return signid;
    }

    public void setSignid(long signid) {
        this.signid = signid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
}
