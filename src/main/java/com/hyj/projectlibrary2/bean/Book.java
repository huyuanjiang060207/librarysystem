package com.hyj.projectlibrary2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("books")
public class Book implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long bookid;
    private String title;
    private String author;
    private Integer price;

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
    public boolean decreaseBook() {
        return false;
    }

    // 可能需要调整为实例方法
    public boolean increaseBook() {
        return false;
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
