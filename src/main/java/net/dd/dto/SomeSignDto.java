package net.dd.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

public class SomeSignDto implements Serializable {
    private int id;
    private long stunum;
    private String stuname;
    private long signid;
    private String stusignstate;
    private Date signtime;
    private String values;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStunum() {
        return stunum;
    }

    public void setStunum(long stunum) {
        this.stunum = stunum;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
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

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
