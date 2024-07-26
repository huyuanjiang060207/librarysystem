package com.hyj.projectlibrary2.bean;

import java.io.Serializable;
import java.util.Date;


public class Lend implements Serializable {
    private long num;
    private long bookid;
    private long readerid;
    private Date lenddate;
    private Date backdate;
    public long getReaderId() {
        return readerid;
    }

    public void setReaderId(long reader_id) {
        this.readerid = readerid;
    }

    public long getBookId() {
        return bookid;
    }

    public void setBookId(long book_id) {
        this.bookid = bookid;
    }

    public void setSer_num(long ser_num) {
        this.num = num;
    }

    public Date getBackDate() {
        return backdate;
    }

    public void setBackDate(Date back_date) {
        this.backdate = backdate;
    }

    public Date getLendDate() {
        return lenddate;
    }

    public void setLendDate(Date lend_date) {
        this.lenddate = lenddate;
    }

    public long getSer_num() {
        return num;
    }
}
