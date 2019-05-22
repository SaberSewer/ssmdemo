package online.cangjie.po;

import java.io.Serializable;

public class TLiuyan implements Serializable{
    private Integer liuyanId;

    private String liuyanTitle;

    private String liuyanContent;

    private String liuyanDate;

    private String liuyanUser;

    public Integer getLiuyanId() {
        return liuyanId;
    }

    public void setLiuyanId(Integer liuyanId) {
        this.liuyanId = liuyanId;
    }

    public String getLiuyanTitle() {
        return liuyanTitle;
    }

    public void setLiuyanTitle(String liuyanTitle) {
        this.liuyanTitle = liuyanTitle == null ? null : liuyanTitle.trim();
    }

    public String getLiuyanContent() {
        return liuyanContent;
    }

    public void setLiuyanContent(String liuyanContent) {
        this.liuyanContent = liuyanContent == null ? null : liuyanContent.trim();
    }

    public String getLiuyanDate() {
        return liuyanDate;
    }

    public void setLiuyanDate(String liuyanDate) {
        this.liuyanDate = liuyanDate == null ? null : liuyanDate.trim();
    }

    public String getLiuyanUser() {
        return liuyanUser;
    }

    public void setLiuyanUser(String liuyanUser) {
        this.liuyanUser = liuyanUser == null ? null : liuyanUser.trim();
    }
}