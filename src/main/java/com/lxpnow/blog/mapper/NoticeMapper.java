package com.lxpnow.blog.mapper;

import com.lxpnow.blog.entity.Notice;

import java.util.List;

public interface NoticeMapper {

    void saveNotice(Notice notice);

    Notice getNewNotice();

    List<Notice> getAllNotice();
}
