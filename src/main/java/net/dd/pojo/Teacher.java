package net.dd.pojo;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Teacher implements Serializable {

    private long id;
    private String username;
    private String password;
    private long isDeleted;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;

    public Teacher(long id, String username, String password, long isDeleted, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Teacher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                isDeleted == teacher.isDeleted &&
                username.equals(teacher.username) &&
                password.equals(teacher.password) &&
                createTime.equals(teacher.createTime) &&
                updateTime.equals(teacher.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, isDeleted, createTime, updateTime);
    }

}
