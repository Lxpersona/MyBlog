package com.lxpnow.blog.Controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxpnow.blog.Service.ArticleService;
import com.lxpnow.blog.entity.Article;
import com.lxpnow.blog.entity.ImageUploadResponse;
import com.lxpnow.blog.entity.Notice;
import com.lxpnow.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @ResponseBody
    @PostMapping("/saveBlog")
    public String saveBlog(Article article, HttpServletRequest request){
        int userId=((User)request.getSession().getAttribute("user")).getUserId();
        articleService.saveArticle(article,userId);
        return "success";
    }


    @GetMapping("/article/{articleId}")
    public String readArticle(@PathVariable(value = "articleId") Integer articleId,
                              Map<String,Object> map){
        Article article=articleService.getArticleById(articleId);
        articleService.addArticleViewCount(articleId);
        map.put("article",article);
        return "public/Reader";
    }


    @ResponseBody
    @GetMapping("/articleList")
    public List getArticle(){
        List<Article> articles= articleService.getAllArticles();
        return articles;
    }


    @Value("${file.imageUploadPath}")
    private String imageUploadPath;

    @ResponseBody
    @PostMapping("/imageUpload")
    public ImageUploadResponse imageUpload(
            @RequestParam(value = "editormd-image-file")MultipartFile imageFile,
            HttpServletRequest request){
        System.out.println("filename"+imageFile.getSize());
        ImageUploadResponse uploadResponse=new ImageUploadResponse();
        if (!imageFile.isEmpty()){
            String userDir=((User)request.getSession().getAttribute("user")).getUserId().toString();
            //String userDir="ArticleImage/"+"aaa";
            String destDir=imageUploadPath+userDir;
            String fileName=imageFile.getOriginalFilename();
            File file=new File(destDir);
            if (!file.exists()){
                file.mkdir();
            }
            try {
                File dest= new File(destDir + "/" + imageFile.getOriginalFilename());
                imageFile.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            uploadResponse.setSuccess(1);
            uploadResponse.setMessage("ok");
            uploadResponse.setUrl("/ArticleImage/"+userDir+"/"+fileName);
            System.out.println(uploadResponse);
            return uploadResponse;
        }

        uploadResponse.setSuccess(0);
        uploadResponse.setMessage("ok");
        uploadResponse.setUrl(null);
        return uploadResponse;
    }


    @GetMapping("/BlogListPage")
    public String toBlogList(Map<String ,Object> map){
        List<Article> articles=articleService.getAllArticles();
        map.put("articles",articles);
        return "public/BlogList";
    }


    @GetMapping("/search")
    public String searchArticleByCondition(@RequestParam(required = false,defaultValue = "") String condition,Map<String ,Object> map){
        List<Article> articles=articleService.getArticlesByTitleOrKeywordsLike(condition);
        map.put("articles",articles);
        if (condition==null||condition.trim()==""){
        }else {
            map.put("condition",condition);
        }
        System.out.println("con"+condition);
        return "public/BlogList";
    }
}
