package net.dd.dto;

import java.io.Serializable;

//@Data
public class RegistDto implements Serializable {

    //@NotNull(message = "用户名不能为空")
    private String username;

    //@NotNull(message = "密码不能为空")
    private String password;
    private Long teacherNum;
    private String email;

    public RegistDto() {
    }

    public RegistDto(String username, String password, Long teacherNum, String email) {
        this.username = username;
        this.password = password;
        this.teacherNum = teacherNum;
        this.email = email;
    }

    public Long getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(Long teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
