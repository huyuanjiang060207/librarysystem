package com.hyj.projectlibrary2.bean;

import java.io.Serializable;

public  class ReaderInfo implements Serializable {

    private long readerid;
    private String name;
    private String sex;
    private String address;
    private String phone;

    public long getReaderId() {
        return readerid;
    }

    public void setReaderId(long readerid) {
        this.readerid = readerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
