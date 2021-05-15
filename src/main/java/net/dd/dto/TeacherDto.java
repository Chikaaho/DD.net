package net.dd.dto;

import java.io.Serializable;

public class TeacherDto implements Serializable {
    private String username;
    private long teachernum;

    public TeacherDto(String username, long teachernum) {
        this.username = username;
        this.teachernum = teachernum;
    }

    public TeacherDto() {
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
}
