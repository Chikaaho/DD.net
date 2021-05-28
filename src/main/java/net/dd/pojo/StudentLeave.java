package net.dd.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:45
 **/
public class StudentLeave implements Serializable {

    private Integer leaveId;
    private Long stunum;
    private String coursename;
    private String classname;
    private Integer leavestate;
    private String leavereason;
    private Date leavetime;
    private String stuname;
    private Date creattime;
    private Date updatetime;


    public StudentLeave() {
    }

    public StudentLeave(Integer leaveId, Long stunum, String coursename, String classname, Integer leavestate, String leavereason, Date leavetime, String stuname, Date creattime, Date updatetime) {
        this.leaveId = leaveId;
        this.stunum = stunum;
        this.coursename = coursename;
        this.classname = classname;
        this.leavestate = leavestate;
        this.leavereason = leavereason;
        this.leavetime = leavetime;
        this.stuname = stuname;
        this.creattime = creattime;
        this.updatetime = updatetime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Long getStunum() {
        return stunum;
    }

    public void setStunum(Long stunum) {
        this.stunum = stunum;
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

    public Integer getLeavestate() {
        return leavestate;
    }

    public void setLeavestate(Integer leavestate) {
        this.leavestate = leavestate;
    }

    public String getLeavereason() {
        return leavereason;
    }

    public void setLeavereason(String leavereason) {
        this.leavereason = leavereason;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }
}
