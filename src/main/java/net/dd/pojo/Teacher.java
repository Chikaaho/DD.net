package net.dd.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Teacher implements Serializable {

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

  @ApiModelProperty(value = "激活状态")
  private int status;

  @ApiModelProperty(value = "激活码")
  private String activeCodes;

  @ApiModelProperty(value = "邮箱")
  private String email;

  public Teacher() {
  }

  public Teacher(long id, String username, String password, int isDeleted, LocalDateTime createTime, LocalDateTime updateTime, int roles, int status, String activeCodes, String email) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.isDeleted = isDeleted;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.roles = roles;
    this.status = status;
    this.activeCodes = activeCodes;
    this.email = email;
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getActiveCodes() {
    return activeCodes;
  }

  public void setActiveCodes(String activeCodes) {
    this.activeCodes = activeCodes;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Teacher)) return false;
    Teacher teacher = (Teacher) o;
    return getId() == teacher.getId() &&
            getIsDeleted() == teacher.getIsDeleted() &&
            getRoles() == teacher.getRoles() &&
            getStatus() == teacher.getStatus() &&
            Objects.equals(getUsername(), teacher.getUsername()) &&
            Objects.equals(getPassword(), teacher.getPassword()) &&
            Objects.equals(getCreateTime(), teacher.getCreateTime()) &&
            Objects.equals(getUpdateTime(), teacher.getUpdateTime()) &&
            Objects.equals(getActiveCodes(), teacher.getActiveCodes());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUsername(), getPassword(), getIsDeleted(), getCreateTime(), getUpdateTime(), getRoles(), getStatus(), getActiveCodes());
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
            ", roles=" + roles +
            ", status=" + status +
            ", active_codes='" + activeCodes + '\'' +
            '}';
  }
}
