package com.hyj.projectlibrary2.bean;

public class Admin {
    private long adminid;
    private String password;
    private String username;
    public long getAdminId() {
        return adminid;
    }

    public void setAdminId(long admin_id) {
        this.adminid = adminid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
