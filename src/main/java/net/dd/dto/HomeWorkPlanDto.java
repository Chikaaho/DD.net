package net.dd.dto;

import java.io.Serializable;
import java.util.Date;

public class HomeWorkPlanDto implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private Date deadline;
    private Date creat_time;
    private Date update_time;
    private String file;
    private String coursename;
    private String classname;

    public HomeWorkPlanDto() {
    }

    public HomeWorkPlanDto(Integer id, String title, String content, Date deadline, Date creat_time, Date update_time, String file, String coursename, String classname) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.creat_time = creat_time;
        this.update_time = update_time;
        this.file = file;
        this.coursename = coursename;
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

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
}
