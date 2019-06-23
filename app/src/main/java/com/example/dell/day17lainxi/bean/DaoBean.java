package com.example.dell.day17lainxi.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dell on 2019/6/20.
 */
@Entity
public class DaoBean {
    @Id(autoincrement = true)
    private Long id;
    private String url;
    private String title;
    private String desc;
    @Generated(hash = 681065214)
    public DaoBean(Long id, String url, String title, String desc) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.desc = desc;
    }
    @Generated(hash = 405743142)
    public DaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
