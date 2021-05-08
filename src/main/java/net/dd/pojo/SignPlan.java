package net.dd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//签到安排表
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SignPlan implements Serializable {

    //签到安排编号
    private long id;
    //课程编号
    private long classid;
    //签到状态
    private String signstate;
    //删除状态
    private int isdeleted;

    public SignPlan() {
    }

    public SignPlan(long id, long classid, String signstate, int isdeleted) {
        this.id = id;
        this.classid = classid;
        this.signstate = signstate;
        this.isdeleted = isdeleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClassid() {
        return classid;
    }

    public void setClassid(long classid) {
        this.classid = classid;
    }

    public String getSignstate() {
        return signstate;
    }

    public void setSignstate(String signstate) {
        this.signstate = signstate;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }
}
