package net.dd.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {
    private long usernum;
    private String classname;
    private String username;
    private String password;

    public StudentDto() {
    }

    public StudentDto(long usernum, String classname, String username, String password) {
        this.usernum = usernum;
        this.classname = classname;
        this.username = username;
        this.password = password;
    }

    public long getUsernum() {
        return usernum;
    }

    public void setUsernum(long usernum) {
        this.usernum = usernum;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
