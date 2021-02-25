package net.dd.pojo;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Student implements Serializable {

    private long id;
    private long usernum;
    private String username;
    private String password;
    private String classname;
    private long isDeleted;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;

    public Student(long id, long usernum, String username, String password, String classname, long isDeleted, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.usernum = usernum;
        this.username = username;
        this.password = password;
        this.classname = classname;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getUsernum() {
        return usernum;
    }

    public void setUsernum(long usernum) {
        this.usernum = usernum;
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


    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }


    public long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(long isDeleted) {
        this.isDeleted = isDeleted;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                usernum == student.usernum &&
                isDeleted == student.isDeleted &&
                username.equals(student.username) &&
                password.equals(student.password) &&
                classname.equals(student.classname) &&
                createTime.equals(student.createTime) &&
                updateTime.equals(student.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usernum, username, password, classname, isDeleted, createTime, updateTime);
    }

}
