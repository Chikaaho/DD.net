package net.dd.dto;

import java.io.Serializable;
import java.util.Date;

public class HomeWorkDto implements Serializable {
    private Integer id;
    private long stunum;
    private String title;
    private String answer;
    private Integer score;
    private String file;
    private String coursename;
    private String classname;

    public HomeWorkDto() {
    }

    public HomeWorkDto(Integer id, long stunum, String title, String answer, Integer score, String file, String coursename, String classname) {
        this.id = id;
        this.stunum = stunum;
        this.title = title;
        this.answer = answer;
        this.score = score;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
