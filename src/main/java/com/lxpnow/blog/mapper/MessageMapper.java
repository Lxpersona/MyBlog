package com.lxpnow.blog.mapper;

import com.lxpnow.blog.entity.Message;

import java.util.List;

public interface MessageMapper {

    void saveMessage(Message message);

    Message getMessageById(Integer messageId);

    List<Message> getAllMessage();

    void updateMessageStatus(Integer messageId);

}
