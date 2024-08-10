package com.hyj.projectlibrary2.controller;

import com.hyj.projectlibrary2.bean.User;
import com.hyj.projectlibrary2.service.BookService;
import com.hyj.projectlibrary2.service.LendService;
import com.hyj.projectlibrary2.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LendService lendService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/userLogin")
    public String userLogin(@Param("userName") String userName,
                            @Param("password") String password, HttpServletRequest request){
        User user=userService.userLogin(userName,password);
        if(null!=user){
            request.getSession().setAttribute("user",user);
            return "user/index";
        }
        return "index";
    }

    @RequestMapping("/isUserExist")
    public String isUserExist(@Param("userName") String userName){
        List<User> users=userService.findUserByUserName(userName);
        if(null==users){
            return "false";
        }
        if(users.size()<1){
            return "false";
        }
        return "true";
    }

    @RequestMapping("/userReturnBooksPage")
    public String userReturnBooksPage(){
        return "user/returnBooks";
    }

    @RequestMapping("/userMessagePage")
    public String userMessagePage(Model model, HttpServletRequest request){
        User session_user= (User) request.getSession().getAttribute("user");
        User user=userService.findUserById(session_user.getUserId());
        model.addAttribute("message_user",user);
        return "user/userMessage";
    }


    @RequestMapping("/borrowingPage")
    public String borrowing(){
        return "user/borrowingBooks";
    }

    @RequestMapping("/userIndex")
    public String userIndex(){
        return "user/index";
    }

    @RequestMapping("/updateUser")
    public boolean updateUser(User user,HttpServletRequest request){
        return userService.updateUser(user,request);
    }


    @RequestMapping("/userReturnBook")
    public boolean returnBook(int bookId,HttpServletRequest request){
        return userService.userReturnBook(bookId,request);
    }

    @RequestMapping("/userBorrowingBook")
    public boolean borrowingBook(int bookId,HttpServletRequest request){
        return userService.userBorrowingBook(bookId,request);
    }


    @RequestMapping("/adminLoginPage")
    public String adminLoginPage(){
        return "adminLogin";
    }


    @RequestMapping("/userLogOut")
    public String userLogOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/findBookPage")
    public String findBookPage(){
        return "user/findBook";
    }

    @RequestMapping("/deleteUser")
    public String deleteUserByUserId(@RequestParam("userId") int userId){
        int res=userService.deleteUserById(userId);
        if(res>0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        int res=userService.insertUser(user);
        if(res>0){
            return "true";
        }else{
            return "false";
        }
    }
}
