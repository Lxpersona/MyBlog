package com.lxpnow.blog.Controller;
//2019/3/10  11:11


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxpnow.blog.Service.NoticeService;
import com.lxpnow.blog.entity.Notice;
import com.lxpnow.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @ResponseBody
    @PostMapping("/newNotice")
    public String newNotice(Notice notice, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        noticeService.saveNotice(notice,user);
        return "success";
    }




    @GetMapping("/notices/list")
    public String getAllNoticeList(
            @RequestParam Integer startPage,
            Map<String,Object> map){
        PageHelper.startPage(startPage,5);
        List<Notice> notices=noticeService.getAllNoticeOrderByTimeDesc();
        PageInfo<Notice> pageInfo=new PageInfo<>(notices);
        map.put("pageInfo",pageInfo);
        map.put("nPage",startPage);
        return "admin/NoticeBoard";
    }


}
