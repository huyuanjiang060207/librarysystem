package com.hyj.projectlibrary2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.service.BookService;
import com.hyj.projectlibrary2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/addBook")
    @ResponseBody
    public String addBook(Book book){
        boolean res=adminService.addBook(book);
        if(res){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/showBooksResultPageByCategoryId")
    public String showBooksResultPageByCategoryId(@RequestParam("pageNum") int pageNum, @RequestParam("bookCategory") int bookCategory, Model model){
        Page<Book> page=bookService.findBooksByCategoryId(bookCategory,pageNum);
        model.addAttribute("page",page);
        model.addAttribute("bookCategory",bookCategory);
        return "admin/showBooks";
    }

    @RequestMapping("/findBookByName")
    public String findBooksResultPage(@RequestParam("bookName") String bookName,Model model){
        List<Book> bookVos =bookService.findBooksByBookName(bookName);
        model.addAttribute("bookList",bookVos);
        return "user/findBook";
    }


}