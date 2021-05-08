package net.dd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//学生签到表
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StuSign implements Serializable {
    //学生签到编号
    private Integer id;
    //学号
    private long stunum;
    //签到安排编号
    private long signid;
    //学生签到状态
    private String stusignstate;

    public StuSign() {
    }

    public StuSign(Integer id, long stunum, long signid, String stusignstate) {
        this.id = id;
        this.stunum = stunum;
        this.signid = signid;
        this.stusignstate = stusignstate;
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

    public long getSignid() {
        return signid;
    }

    public void setSignid(long signid) {
        this.signid = signid;
    }

    public String getStusignstate() {
        return stusignstate;
    }

    public void setStusignstate(String stusignstate) {
        this.stusignstate = stusignstate;
    }
}
