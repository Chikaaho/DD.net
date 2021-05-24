package net.dd.dto;

import java.io.Serializable;

public class TeacherDto implements Serializable {
    private String username;
    private long teachernum;
    private String password;
    private String email;

    public TeacherDto() {
    }

    public TeacherDto(String username, long teachernum, String password, String email) {
        this.username = username;
        this.teachernum = teachernum;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTeachernum() {
        return teachernum;
    }

    public void setTeachernum(long teachernum) {
        this.teachernum = teachernum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
