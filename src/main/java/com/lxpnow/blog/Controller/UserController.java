package com.lxpnow.blog.Controller;
//2019/3/4  16:54

import com.lxpnow.blog.Service.UserService;
import com.lxpnow.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/userLogin")
    public String login(){
        return "index";
    }



    @PostMapping("/register")
    public String register(User user,HttpServletRequest request){
        userService.saveUser(user);
        request.getSession().setAttribute("user",user);
        return "index";
    }

    @GetMapping("/userRegisterPage")
    public String userRegister(){
        return "public/register";
    }


    @ResponseBody
    @GetMapping("/isUsernameExist")
    public boolean isUsernameExist(@RequestParam String username){
        return userService.isUsernameExist(username);
    }

    @ResponseBody
    @GetMapping("/isEmailExist")
    public boolean isEmailExist(@RequestParam String userEmail){
        boolean bool=userService.isEmailExist(userEmail);
        return bool;
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin/BlogManage";
    }


    @ResponseBody
    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        return "success";
    }


    @ResponseBody
    @RequestMapping("/loginFail")
    public String loginFail(Map<String,Object> map){
        return "fail";
    }


    @ResponseBody
    @GetMapping("/guanli/lxp/byLink")
    public String adminAddLinkBy(@RequestParam String username,@RequestParam String password,
                                 @RequestParam String nickname){
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        userService.admin(user);
        return "ok";
    }

}
