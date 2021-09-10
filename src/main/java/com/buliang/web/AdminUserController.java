package com.buliang.web;

import com.buliang.bo.NewsBo;
import com.buliang.bo.UserBo;
import com.buliang.pojo.News;
import com.buliang.pojo.User;
import com.buliang.service.UserService;
import com.buliang.util.Pages;
import com.buliang.vo.ResultCode;
import com.buliang.vo.ResultVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Retention;
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
    public String queryUserList(@RequestParam(defaultValue = "1") Integer pageIndex, Model model){

        UserBo userBo = new UserBo();
        userBo.setPage(true);
        userBo.setPageIndex(pageIndex);
        userBo.setPageSize(5);
        userBo.setStartIndex(userBo.getStartIndex());


        Pages<User> userPages = userService.queryUserByPage(userBo);
        userPages.setUrl("admin/user/queryUserList?time="+System.currentTimeMillis());

        model.addAttribute("pager",userPages);
        return "forward:/backend/user/userList.jsp";
    }

    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Integer id, Model model){
        User user = userService.queryById(id);
        model.addAttribute("user",user);
        return "forward:/backend/user/toUpdateUser.jsp";
    }




    @RequestMapping("/updateUser")
    @ResponseBody
    public ResultVo updateUser(User user){
        boolean res = user.getId() == null?userService.addUser(user):userService.updateUser(user);
        if (res){
            return  ResultVo.success();
        }
        return ResultVo.fail(ResultCode.Fail);
    }

    /*
    some question happen in it
     */
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public ResultVo deleteUserById(Integer id){
        if (userService.logicDelete(id)){
            return ResultVo.mySuccess(ResultCode.LOGIC_DELETE_SUCCESS);
        }
        return ResultVo.fail(ResultCode.LOGIC_DELETE_FAIL);
    }

    //@RequestMapping()


}
