package com.lxpnow.blog.Service;
//2019/3/13  21:18


import com.lxpnow.blog.entity.Message;
import com.lxpnow.blog.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageService {

    @Autowired
    MessageMapper messageMapper;

    public void saveMessage(Message message){
        message.setMessageStatus(0);
        message.setMessageTime(new Date());
        messageMapper.saveMessage(message);
    }

}
