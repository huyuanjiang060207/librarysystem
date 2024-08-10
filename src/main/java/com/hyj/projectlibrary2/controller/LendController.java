package com.hyj.projectlibrary2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyj.projectlibrary2.bean.Lend;
import com.hyj.projectlibrary2.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LendController {
    @Autowired
    private LendService lendService;

    @RequestMapping("/allBorrowBooksRecordPage")
    public String allBorrowingBooksRecordPage(Model model, @RequestParam("pageNum") int pageNum){
        Page<Lend> page=LendService.selectAllByPage(pageNum);
        model.addAttribute("page",page);
        return "admin/allBorrowingBooksRecord";
    }

}
