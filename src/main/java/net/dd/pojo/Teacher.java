package net.dd.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.Objects;

public class Teacher {

  private static final long serialVersionUID = 1L;

//  @TableId(type = IdType.ASSIGN_ID)
  @JsonSerialize(using = ToStringSerializer.class)
  private long id;

  @ApiModelProperty(value = "用户名")
  private String username;

  @ApiModelProperty(value = "密码")
  private String password;

  @ApiModelProperty(value = "是否删除 0: 没有删除 1 :已删除")
  @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
//  @TableLogic
//  @EnumValue
  private int isDeleted;

  @ApiModelProperty(value = "创建时间")
  private LocalDateTime createTime;

  @ApiModelProperty(value = "修改时间")
  private LocalDateTime updateTime;

  @ApiModelProperty(value = "权限")
  private int roles;

  public Teacher() {
  }

  public Teacher(long id, String username, String password, int isDeleted, LocalDateTime createTime, LocalDateTime updateTime, int roles) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.isDeleted = isDeleted;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.roles = roles;
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

  public int getRoles() {
    return roles;
  }

  public void setRoles(int roles) {
    this.roles = roles;
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
