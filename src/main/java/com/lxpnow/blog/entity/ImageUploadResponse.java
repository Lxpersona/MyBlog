package com.lxpnow.blog.entity;
//2019/3/13  9:51

public class ImageUploadResponse {

    private Integer success;
    private String message;
    private String url;

    public ImageUploadResponse() {
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
