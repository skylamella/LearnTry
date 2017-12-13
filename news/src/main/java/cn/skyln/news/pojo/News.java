package cn.skyln.news.pojo;

import java.util.Date;

public class News {
    private Integer newsId;

    private Date newsCreate;

    private Date newsUpdate;

    private Integer userIdCre;

    private Integer userIdUpd;

    private Integer columnId;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getNewsCreate() {
        return newsCreate;
    }

    public void setNewsCreate(Date newsCreate) {
        this.newsCreate = newsCreate;
    }

    public Date getNewsUpdate() {
        return newsUpdate;
    }

    public void setNewsUpdate(Date newsUpdate) {
        this.newsUpdate = newsUpdate;
    }

    public Integer getUserIdCre() {
        return userIdCre;
    }

    public void setUserIdCre(Integer userIdCre) {
        this.userIdCre = userIdCre;
    }

    public Integer getUserIdUpd() {
        return userIdUpd;
    }

    public void setUserIdUpd(Integer userIdUpd) {
        this.userIdUpd = userIdUpd;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }
}