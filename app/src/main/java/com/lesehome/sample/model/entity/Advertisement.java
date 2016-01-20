package com.lesehome.sample.model.entity;


import com.lesehome.carrot.recycler.modularadapter.IItemEntity;

import java.io.Serializable;


/**
 * 广告
 */
public class Advertisement implements IItemEntity,Serializable{
    private String title;
    private String imageUrl;
    private String linkUrl;

    public Advertisement() {
        this.title = "默认广告";
        this.imageUrl = "http://www.lesehome.com/wp-content/uploads/2015/09/logo.png";
        this.linkUrl = "http://g.hiphotos.baidu.com/zhidao/pic/item/5243fbf2b2119313cebf2df565380cd790238df3.jpg";
    }

    public Advertisement(String title, String imageUrl, String linkUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
