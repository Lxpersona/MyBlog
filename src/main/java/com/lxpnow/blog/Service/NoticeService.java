package com.lxpnow.blog.Service;
//2019/3/10  11:59


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxpnow.blog.entity.Notice;
import com.lxpnow.blog.entity.User;
import com.lxpnow.blog.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    NoticeMapper noticeMapper;


    public void saveNotice(Notice notice, User user) {
        notice.setPublisherId(user.getUserId());
        notice.setPublishTime(new Date());
        noticeMapper.saveNotice(notice);
    }

    public Notice getNewNotice(){
        return noticeMapper.getNewNotice();
    }

    public List<Notice> getAllNoticeOrderByTimeDesc() { ;
        return noticeMapper.getAllNotice();
    }
}
