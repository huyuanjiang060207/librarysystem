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
    private Long id;
    private String title;
    private String author;

    public long getBookId() {
        return id;
    }
    public void setBookId(long book_id) {
        this.id = id;
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
                "book_id=" + id +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
