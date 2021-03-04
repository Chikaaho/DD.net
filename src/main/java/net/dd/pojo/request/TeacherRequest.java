package net.dd.pojo.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public class TeacherRequest {

    @TableId(type = IdType.ASSIGN_ID)
    private long id;

    @ApiModelProperty(value = "用户名")
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "是否删除 0: 没有删除 1 :已删除")
    @TableLogic
    private int isDeleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("服务端验证码")
    private String key;

    @ApiModelProperty("图片")
    private String picName;

    @ApiModelProperty("验证码")
    private String verifyCode;


    public TeacherRequest() {
    }

    public TeacherRequest(long id, @NotNull(message = "密码不能为空") @NotBlank(message = "密码不能为空") String username, @NotNull(message = "密码不能为空") @NotBlank(message = "密码不能为空") String password, int isDeleted, LocalDateTime createTime, LocalDateTime updateTime, String key, String picName, String verifyCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.key = key;
        this.picName = picName;
        this.verifyCode = verifyCode;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherRequest)) return false;
        TeacherRequest that = (TeacherRequest) o;
        return getId() == that.getId() &&
                getIsDeleted() == that.getIsDeleted() &&
                Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getCreateTime(), that.getCreateTime()) &&
                Objects.equals(getUpdateTime(), that.getUpdateTime()) &&
                Objects.equals(getKey(), that.getKey()) &&
                Objects.equals(getPicName(), that.getPicName()) &&
                Objects.equals(getVerifyCode(), that.getVerifyCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getIsDeleted(), getCreateTime(), getUpdateTime(), getKey(), getPicName(), getVerifyCode());
    }

    @Override
    public String toString() {
        return "TeacherRequest{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", key='" + key + '\'' +
                ", picName='" + picName + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }

}
