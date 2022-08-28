package com.so.studyonline.entity;


public class SoUser {

    private long id;
    private String userNo;
    private String password;
    private String userName;
    private long userType;
    private String userRole;
    private long gander;
    private String email;
    private String phone;
    private String tel;
    private String desc;
    private String theme;
    private String userImg;
    private String coverImg;
    private String tags;
    private String token;
    private java.sql.Timestamp creationTime;
    private String creatingBy;
    private java.sql.Timestamp updateTime;
    private String updateBy;
    private String isVerifyCode;
    private String hot;
    private String homepage;
    private String remoteImgDomain;

    public String getRemoteImgDomain() {
        return remoteImgDomain;
    }

    public void setRemoteImgDomain(String remoteImgDomain) {
        this.remoteImgDomain = remoteImgDomain;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getIsVerifyCode() {
        return isVerifyCode;
    }

    public void setIsVerifyCode(String isVerifyCode) {
        this.isVerifyCode = isVerifyCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public long getUserType() {
        return userType;
    }

    public void setUserType(long userType) {
        this.userType = userType;
    }


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


    public long getGander() {
        return gander;
    }

    public void setGander(long gander) {
        this.gander = gander;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }


    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }


    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public java.sql.Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(java.sql.Timestamp creationTime) {
        this.creationTime = creationTime;
    }


    public String getCreatingBy() {
        return creatingBy;
    }

    public void setCreatingBy(String creatingBy) {
        this.creatingBy = creatingBy;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

}
