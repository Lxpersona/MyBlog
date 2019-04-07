package com.lxpnow.blog.Controller;
//2019/3/8  16:53


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxpnow.blog.Service.NoticeService;
import com.lxpnow.blog.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    public static final String ADMIN = "admin";


    @Autowired
    NoticeService noticeService;


    @GetMapping("/toEditBlog")
    public String toEditBlog() {
        return ADMIN + "/EditBlog";
    }

    @GetMapping("/toMessage")
    public String toMessage() {
        return ADMIN + "/Message";
    }

    @GetMapping("/toMySpace")
    public String toMySpage() {
        return ADMIN + "/MySpace";
    }

    @GetMapping("/toUserManage")
    public String toUserManage() {
        return ADMIN + "/UserManage";
    }

    @GetMapping("/toBlogManage")
    public String toBlogManage() {
        return ADMIN + "/BlogManage";
    }


    @GetMapping("/toNoticeBoard")
    public String toNoticeBoard(Map<String, Object> map) {
        PageHelper.startPage(1,5);
        List<Notice> notices = noticeService.getAllNoticeOrderByTimeDesc();
        PageInfo<Notice> pageInfo=new PageInfo<>(notices);
        int noticeCount=notices.size();
        if (notices.size() == 0)
            map.put("noticeCount", noticeCount);
        else {
            map.put("noticeCount",noticeCount);
            map.put("notices",notices);
            map.put("pageInfo",pageInfo);
            map.put("nPage",1);
        }
        return ADMIN + "/NoticeBoard";
    }



}
