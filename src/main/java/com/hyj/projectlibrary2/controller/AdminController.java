package com.hyj.projectlibrary2.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyj.projectlibrary2.bean.Book;
import com.hyj.projectlibrary2.bean.User;
import com.hyj.projectlibrary2.service.AdminService;
import com.hyj.projectlibrary2.service.BookService;
import com.hyj.projectlibrary2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @RequestMapping("/isAdminExist")
    @ResponseBody
    public String adminIsExist(@Param("adminName") String adminName){
        boolean b=adminService.adminIsExist(adminName);
        if(b){
            return "true";
        }else{
            return "false";
        }
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(@Param("adminName") String adminName, @Param("password") String password, HttpServletRequest request){
        boolean res=adminService.adminLogin(adminName,password);
        if(res==false){
            return "adminLogin";
        }
        request.getSession().setAttribute("admin","admin");
        return "admin/index";
    }

    @RequestMapping("/addBookPage")
    public String addBookPage(){
        return "admin/addBook";
    }

    @RequestMapping("/showStausPage")
    public String showStausPage(){
        return "admin/showStaus";
    }

    @RequestMapping("/adminIndex")
    public String returnAdminIndexPage(){
        return "admin/index";
    }

    @RequestMapping("/showUsersPage")
    public String showUsersPage(Model model, @RequestParam("pageNum") int pageNum){
        Page<User> page=userService.findUserByPage(pageNum);
        model.addAttribute("page",page);
        return "admin/showUsers";
    }

    @RequestMapping("/adminLogOut")
    public String userLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "adminLogin";
    }

    @RequestMapping("/addUserPage")
    public String addUserPage(){
        return "admin/addUser";
    }
}
