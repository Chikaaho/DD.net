package net.dd.pojo;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer is_deleted;
    private Integer roles;
    private long adminnum;

    public Admin(){}
    public Admin(Integer id, String username, String password, Integer is_deleted, Integer roles, long adminnum) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.is_deleted = is_deleted;
        this.roles = roles;
        this.adminnum = adminnum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }

    public long getAdminnum() {
        return adminnum;
    }

    public void setAdminnum(long adminnum) {
        this.adminnum = adminnum;
    }
}
