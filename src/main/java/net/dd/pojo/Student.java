package net.dd.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.dd.pojo.request.StudentRequest;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * 
* @program Student
* @author Chika
* @create 2021/3/4 - 14:18
 * 
**/
@ApiModel(value = "Student对象")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;

    @ApiModelProperty(value = "学号")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private long usernum;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "班级")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private String classname;

    @ApiModelProperty(value = "是否删除 0: 没有删除 1 :已删除")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    @TableLogic
    @EnumValue
    private int isDeleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
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

    public Student(StudentRequest studentRequest) {
        BeanUtils.copyProperties(studentRequest, this);
        Date date = new Date();
        this.createTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.updateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
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
