package cn.white.controller;


import cn.white.entity.User;
import cn.white.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @Autowired
    private UserService userService;
   //注册
    @RequestMapping(value = "/register.do",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String register(User user) {
        userService.register(user);
        return "注册成功";
    }

   //邮箱激活
    @RequestMapping(value = "/activate.do",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public String active(String code){
       return userService.updateUserState(code);
    }
}
