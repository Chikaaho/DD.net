package net.dd.pojo;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Chika
 * @program DDNet
 * @create 2021/5/24 - 14:45
 **/
public class StudentLeaveList implements Serializable {

    private Integer id;
    private Integer leaveid;
    private long stunum;
    private String coursename;

    public StudentLeaveList() {
    }

    public StudentLeaveList(Integer id, Integer leaveid, long stunum, String coursename) {
        this.id = id;
        this.leaveid = leaveid;
        this.stunum = stunum;
        this.coursename = coursename;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaveid() {
        return leaveid;
    }

    public void setLeaveid(Integer leaveid) {
        this.leaveid = leaveid;
    }

    public long getStunum() {
        return stunum;
    }

    public void setStunum(long stunum) {
        this.stunum = stunum;
    }
}
