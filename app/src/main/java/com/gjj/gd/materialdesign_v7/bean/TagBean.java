package com.gjj.gd.materialdesign_v7.bean;

/**
 * Created by gaojuanjuan on 2018/2/28.
 */

public class TagBean {

    private String text;
    private int type;
    private String url;

    public TagBean(String text, int type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
