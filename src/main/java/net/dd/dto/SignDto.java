package net.dd.dto;

import lombok.Data;

import java.io.Serializable;
//@Data
public class SignDto implements Serializable {
    long stunum;  //学生学号
    String state;  //签到状态


    public SignDto() {
    }

    public SignDto(long stunum, String state) {
        this.stunum = stunum;
        this.state = state;
    }

    public long getStunum() {
        return stunum;
    }

    public void setStunum(long stunum) {
        this.stunum = stunum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
