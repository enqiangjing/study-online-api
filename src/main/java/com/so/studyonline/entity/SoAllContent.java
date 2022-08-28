package com.so.studyonline.entity;


public class SoAllContent {

    private long id;
    private String title;
    private String content;
    private String author;
    private long readTimes;
    private long discussTimes;
    private String type;
    private String banner;
    private String thumbnail;
    private int hot;
    private String createdTime;
    private String updateTime;
    private String deletedTime;
    private long status;
    private String extraA;
    private String extraB;
    private String extraC;
    private String orderType;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getExtraA() {
        return extraA;
    }

    public void setExtraA(String extraA) {
        this.extraA = extraA;
    }

    public String getExtraB() {
        return extraB;
    }

    public void setExtraB(String extraB) {
        this.extraB = extraB;
    }

    public String getExtraC() {
        return extraC;
    }

    public void setExtraC(String extraC) {
        this.extraC = extraC;
    }

    // 扩展字段
    private int pageIndex;
    private int pageNum;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public long getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(long readTimes) {
        this.readTimes = readTimes;
    }


    public long getDiscussTimes() {
        return discussTimes;
    }

    public void setDiscussTimes(long discussTimes) {
        this.discussTimes = discussTimes;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(String deletedTime) {
        this.deletedTime = deletedTime;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


}
