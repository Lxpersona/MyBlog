package com.lxpnow.blog.mapper;

import com.lxpnow.blog.entity.Article;

import java.util.List;

public interface ArticleMapper {

    void saveArticle(Article article);

    List<Article> getAllArticles();

    Article getArticleById(Integer id);

    void addViewCount(Integer id);

    List<Article> getArticlesByTitleOrKeywordsLike(String str);

}
