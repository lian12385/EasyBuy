package com.buliang.web;

import com.buliang.pojo.User;
import com.buliang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String jumpPage(){
        return "redirect:/backend/user/userInfo.jsp";
    }

    @RequestMapping("/queryUserList")
    public String queryUserList(Model model){
        List<User> userList = userService.AdminQueryAllUser();
        model.addAttribute("userList",userList);
        return "forward:/backend/user/userList.jsp";
    }

    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Integer id){
        return "forward:/backend/user/toUpdateUser.jsp";
    }


}
