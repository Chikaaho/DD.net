package net.dd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//学生签到表
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StuSign implements Serializable {
    //学生签到编号
    private Integer id;
    //学号
    private long stunum;
    //姓名
    private String stuname;
    //签到安排编号
    private long signid;
    //学生签到状态
    private String stusignstate;
    //签到时间
    private Date signtime;
    //课程名
    private String coursename;
    //班级
    private String classname;

    public StuSign() {
    }

    public StuSign(Integer id, long stunum, String stuname, long signid, String stusignstate, Date signtime, String coursename, String classname) {
        this.id = id;
        this.stunum = stunum;
        this.stuname = stuname;
        this.signid = signid;
        this.stusignstate = stusignstate;
        this.signtime = signtime;
        this.coursename = coursename;
        this.classname = classname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getId() {
        return id;
    }

    public long getStunum() {
        return stunum;
    }

    public String getStuname() {
        return stuname;
    }

    public long getSignid() {
        return signid;
    }

    public String getStusignstate() {
        return stusignstate;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStunum(long stunum) {
        this.stunum = stunum;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setSignid(long signid) {
        this.signid = signid;
    }

    public void setStusignstate(String stusignstate) {
        this.stusignstate = stusignstate;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }
}
