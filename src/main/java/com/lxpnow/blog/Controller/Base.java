package com.lxpnow.blog.Controller;
//2019/1/14  19:03

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxpnow.blog.Service.ArticleService;
import com.lxpnow.blog.Service.NoticeService;
import com.lxpnow.blog.Service.UserService;
import com.lxpnow.blog.entity.Article;
import com.lxpnow.blog.entity.Notice;
import com.lxpnow.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class Base {

    @Autowired
    UserService userService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String indexPage(Map<String,Object>map){
        Notice notice=noticeService.getNewNotice();
        PageHelper.startPage(1,10);
        List<Article> articleList = articleService.getAllArticles();
        PageInfo<Article> pageInfo=new PageInfo<>(articleList);
        map.put("articles",articleList);
        map.put("notice",notice);
        map.put("pageInfo",pageInfo);
        return "index";
    }

    @GetMapping("/showArticles")
    public String listBlog(@RequestParam Integer page,Map<String,Object> map){
        Notice notice=noticeService.getNewNotice();
        PageHelper.startPage(page,10);
        List<Article> articleList = articleService.getAllArticles();
        PageInfo<Article> pageInfo=new PageInfo<>(articleList);
        map.put("articles",articleList);
        map.put("notice",notice);
        map.put("pageInfo",pageInfo);
        return "index";
    }

    @RequestMapping("/link")
    public String link(){
        return "public/Link";
    }


    @RequestMapping("/leaveMessage")
    public String toTalkPage(){
        return "public/LeaveMessage";
    }

    @GetMapping("/blogInfo")
    public String blogInfo(){
        return "public/blogInfo";
    }

}
