package com.buliang.web;

import com.buliang.pojo.User;
import com.buliang.service.UserService;
import com.buliang.util.SessionUtil;
import com.buliang.vo.ResultCode;
import com.buliang.vo.ResultVo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    //@RequestMapping(value = "/queryById",method = RequestMethod.GET)
    @GetMapping("/queryById")
    public String queryById(Integer id, Model model){
        User user = userService.queryById(id);
        model.addAttribute("user",user);
        return "forward:/index.jsp";
    }


    @ResponseBody
    @PostMapping("/Login")
    public ResultVo<Null> login(String loginName, String password){
        //boolean isOk = userService.login(loginName,msg);
        if(userService.queryByNameAndPassword(loginName,password)){
            return ResultVo.success();
        }
        return ResultVo.fail(ResultCode.LOGIN_FAIL);

        //return userService.login(loginName,msg)?ResultVo.success():ResultVo.returnFail(ResultCode.LOGIN_FAIL);
    }
    @RequestMapping("/page/{page}")
    public String jumpPage(@PathVariable String page){
        return "redirect:/pre/" + page + ".jsp";
    }


    @RequestMapping("/loginOut")
    public String loginOut(){
        SessionUtil.invalidSession();
        return "redirect:/pre/login.jsp";
    }

    @ResponseBody
    @PostMapping("/Register")
    public ResultVo<Null> register(User user){
        if (userService.addUser(user)){
            return  ResultVo.success();
        }
        return ResultVo.fail(ResultCode.REGISTER_FAIL);
    }
}
