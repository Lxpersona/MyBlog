package com.lxpnow.blog.Controller;
//2019/3/13  21:17


import com.lxpnow.blog.Service.MessageService;
import com.lxpnow.blog.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {


    @Autowired
    MessageService messageService;

    @ResponseBody
    @PostMapping("/leaveMessage")
    public String saveMessage(Message message){
        messageService.saveMessage(message);
        return "success";
    }

}
