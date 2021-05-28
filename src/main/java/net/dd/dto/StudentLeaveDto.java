package net.dd.dto;

import java.io.Serializable;
import java.util.Date;

//@Data
public class StudentLeaveDto implements Serializable {
    private Integer leaveId;
    private Long stunum;
    private String coursename;
    private String classname;
    private Integer leavestate;
    private String leavereason;
    private Date leavetime;
    private String stuname;


    public StudentLeaveDto() {
    }

    public StudentLeaveDto(Integer leaveId, Long stunum, String coursename, String classname, Integer leavestate, String leavereason, Date leavetime, String stuname) {
        this.leaveId = leaveId;
        this.stunum = stunum;
        this.coursename = coursename;
        this.classname = classname;
        this.leavestate = leavestate;
        this.leavereason = leavereason;
        this.leavetime = leavetime;
        this.stuname = stuname;
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
