package com.lxpnow.blog.entity;
//2019/3/10  11:08

import java.util.Date;

public class Notice {

    private Integer noticeId;
    private Integer publisherId;
    private Date publishTime;
    private String publishTitle;
    private String publishText;
    private User user;
    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPublishTitle() {
        return publishTitle;
    }

    public void setPublishTitle(String publishTitle) {
        this.publishTitle = publishTitle;
    }

    public String getPublishText() {
        return publishText;
    }

    public void setPublishText(String publishText) {
        this.publishText = publishText;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", publisherId=" + publisherId +
                ", publishTime=" + publishTime +
                ", publishTitle='" + publishTitle + '\'' +
                ", publishText='" + publishText + '\'' +
                ", user=" + user +
                '}';
    }
}
