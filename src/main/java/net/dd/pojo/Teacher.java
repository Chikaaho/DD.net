package net.dd.pojo;


import java.time.LocalDateTime;
import java.util.Objects;

public class Teacher {

  private long id;
  private String username;
  private String password;
  private int isDeleted;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

  public Teacher() {
  }

  public Teacher(long id, String username, String password, int isDeleted, LocalDateTime createTime, LocalDateTime updateTime) {
    this.id = id;
    this.username = username;
    this.password = password;
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
    Teacher teacher = (Teacher) o;
    return id == teacher.id &&
            isDeleted == teacher.isDeleted &&
            Objects.equals(username, teacher.username) &&
            Objects.equals(password, teacher.password) &&
            Objects.equals(createTime, teacher.createTime) &&
            Objects.equals(updateTime, teacher.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, isDeleted, createTime, updateTime);
  }

  @Override
  public String toString() {
    return "Teacher{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", isDeleted=" + isDeleted +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
