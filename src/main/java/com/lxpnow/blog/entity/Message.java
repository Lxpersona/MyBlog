package com.lxpnow.blog.entity;
//2019/3/12  21:13

import java.util.Date;

public class Message {

    private Integer messageId;
    private Date messageTime;
    private String messageFrom;
    private String messageText;
    private Integer messageStatus;
    private String messageContact;


    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessageContact() {
        return messageContact;
    }

    public void setMessageContact(String messageContact) {
        this.messageContact = messageContact;
    }
}
