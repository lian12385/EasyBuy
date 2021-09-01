package com.buliang.web;

import com.buliang.pojo.User;
import com.buliang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public String queryById(Integer id, Model model){
        User user = userService.queryById(id);
        model.addAttribute("user",user);
        return "forward:/index.jsp";
    }
}
