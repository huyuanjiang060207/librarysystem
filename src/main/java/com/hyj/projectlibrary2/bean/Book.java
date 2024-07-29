package com.hyj.projectlibrary2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("books")
public class Book implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long bookid;
    private String title;
    private String author;

    public long getBookId() {
        return bookid;
    }
    public void setBookId(long bookid) {
        this.bookid = bookid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString(){
        return "Book{" +
                "book_id=" + bookid +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
