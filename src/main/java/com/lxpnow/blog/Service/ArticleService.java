package com.lxpnow.blog.Service;
//2019/3/11  20:52


import com.lxpnow.blog.entity.Article;
import com.lxpnow.blog.mapper.ArticleMapper;
import com.lxpnow.blog.util.HTMLTagFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public boolean saveArticle(Article article,int userId){
        article.setArticleLike(0);
        article.setArticleView(0);
        article.setCommentCount(0);
        article.setUpdateCount(0);
        article.setArticleStatus(0);
        article.setCreateTime(new Date());
        article.setUserId(userId);
        String shortString=HTMLTagFilter.HTMLTagsFilter(article.getArticleHtml());
        if (shortString.length()>100)
            shortString=shortString.substring(0,100);
        article.setArticleShort(shortString);
        articleMapper.saveArticle(article);
        return true;
    }


    public List getAllArticles(){
        return articleMapper.getAllArticles();
    }

    public Article getArticleById(Integer id){
        return articleMapper.getArticleById(id);
    }

    public void addArticleViewCount(Integer id){
        articleMapper.addViewCount(id);
    }


    public List getArticlesByTitleOrKeywordsLike(String str){
        str="%"+str+"%";
        List list=articleMapper.getArticlesByTitleOrKeywordsLike(str);
        return list;
    }

}
