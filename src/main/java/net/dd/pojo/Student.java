package net.dd.pojo;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Student implements Serializable {

  private long id;
  @ApiModelProperty(value="学号")
  private long usernum;
  @ApiModelProperty(value="用户名")
  private String username;
  @ApiModelProperty(value="密码")
  private String password;
  @ApiModelProperty(value="班级")
  private String classname;
  @ApiModelProperty(value="是否删除 0: 没有删除 1 :已删除")
  private int isDeleted;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

  public Student() {
  }

  public Student(long id, long usernum, String username, String password, String classname, int isDeleted, LocalDateTime createTime, LocalDateTime updateTime) {
    this.id = id;
    this.usernum = usernum;
    this.username = username;
    this.password = password;
    this.classname = classname;
    this.isDeleted = isDeleted;
    this.createTime = createTime;
    this.updateTime = updateTime;
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


  public int getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(int isDeleted) {
    this.isDeleted = isDeleted;
  }


  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }


  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDateTime updateTime) {
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
            Objects.equals(username, student.username) &&
            Objects.equals(password, student.password) &&
            Objects.equals(classname, student.classname) &&
            Objects.equals(createTime, student.createTime) &&
            Objects.equals(updateTime, student.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, usernum, username, password, classname, isDeleted, createTime, updateTime);
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", usernum=" + usernum +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", classname='" + classname + '\'' +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
