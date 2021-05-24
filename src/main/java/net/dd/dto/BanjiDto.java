package net.dd.dto;

import java.io.Serializable;
import java.util.Date;

public class BanjiDto implements Serializable {
    private Integer classesid;
    private String classname;
    private String major;

    public BanjiDto() {
    }

    public BanjiDto(Integer classesid, String classname, String major) {
        this.classesid = classesid;
        this.classname = classname;
        this.major = major;
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
