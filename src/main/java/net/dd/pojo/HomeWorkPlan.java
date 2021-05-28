package net.dd.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class HomeWorkPlan implements Serializable {  //教师发布作业
    private Integer id;
    private String title;
    private String content;
    private Date deadline;
    private Date creattime;
    private Date updatetime;
    private String file;
    private String coursename;
    private String classname;

    public HomeWorkPlan() {
    }

    public HomeWorkPlan(Integer id, String title, String content, Date deadline, Date creattime, Date updatetime, String file, String coursename, String classname) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.creattime = creattime;
        this.updatetime = updatetime;
        this.file = file;
        this.coursename = coursename;
        this.classname = classname;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }



    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
