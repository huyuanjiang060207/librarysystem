package com.hyj.projectlibrary2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lend implements Serializable {
    private long num;
    private long bookid;
    private long userid;
    private long lendid;
    private Date lenddate;
    private Date backdate;
    private User user;
    private Book book;  //借阅书籍
    private String dateOfBorrowing;  //借书日期
    private String dateOfReturn;
}
