package cn.skyln.news.pojo;

public class NewsWithBLOBs extends News {
    private String newsTitle;

    private String newsContent;

    private String newsDownload;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public String getNewsDownload() {
        return newsDownload;
    }

    public void setNewsDownload(String newsDownload) {
        this.newsDownload = newsDownload == null ? null : newsDownload.trim();
    }
}