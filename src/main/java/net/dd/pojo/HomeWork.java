package net.dd.pojo;

import java.io.Serializable;
import java.util.Date;

public class HomeWork implements Serializable {  //教师发布作业
    private Integer id;
    private long stunum;
    private String title;
    private String answer;
    private String file;
    private String score;
    private String coursename;
    private String classname;
    private String username;
    private String stufile;
    private String content;
    private Date deadline;
    private Date creattime;


    public HomeWork() {
    }

    public HomeWork(Integer id, long stunum, String title, String answer, String file, String score, String coursename, String classname, String username, String stufile, String content, Date deadline, Date creattime) {
        this.id = id;
        this.stunum = stunum;
        this.title = title;
        this.answer = answer;
        this.file = file;
        this.score = score;
        this.coursename = coursename;
        this.classname = classname;
        this.username = username;
        this.stufile = stufile;
        this.content = content;
        this.deadline = deadline;
        this.creattime = creattime;
    }

    public String getStufile() {
        return stufile;
    }

    public void setStufile(String stufile) {
        this.stufile = stufile;
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

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getStunum() {
        return stunum;
    }

    public void setStunum(long stunum) {
        this.stunum = stunum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
}
