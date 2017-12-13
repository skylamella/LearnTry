package cn.skyln.pojo;

public class Mail {
    private Integer mailId;

    private String mailTitle;

    private String mailChk;

    private Integer mailCreateuser;

    private Integer mailTouser;

    private String mailText;

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle == null ? null : mailTitle.trim();
    }

    public String getMailChk() {
        return mailChk;
    }

    public void setMailChk(String mailChk) {
        this.mailChk = mailChk == null ? null : mailChk.trim();
    }

    public Integer getMailCreateuser() {
        return mailCreateuser;
    }

    public void setMailCreateuser(Integer mailCreateuser) {
        this.mailCreateuser = mailCreateuser;
    }

    public Integer getMailTouser() {
        return mailTouser;
    }

    public void setMailTouser(Integer mailTouser) {
        this.mailTouser = mailTouser;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText == null ? null : mailText.trim();
    }
}