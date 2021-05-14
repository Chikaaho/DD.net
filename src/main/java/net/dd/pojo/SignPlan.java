package net.dd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//签到安排表
//@AllArgsConstructor
//@NoArgsConstructor
public class SignPlan implements Serializable {

    //签到安排编号
    private long id;
    //课程名
    private String classname;
    //签到状态  0表示关闭签到 1表示开启
    private String signstate;
    private long signid;
    private String coursename;
    //删除状态
    private int isdeleted;

    public SignPlan() {
    }


    public SignPlan(long id, String classname, String signstate, long signid, String coursename, int isdeleted) {
        this.id = id;
        this.classname = classname;
        this.signstate = signstate;
        this.signid = signid;
        this.coursename = coursename;
        this.isdeleted = isdeleted;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSignstate() {
        return signstate;
    }

    public void setSignstate(String signstate) {
        this.signstate = signstate;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }
}
