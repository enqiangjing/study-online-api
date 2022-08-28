package com.so.studyonline.entity;


public class SoVideoChapter {

  private long id;
  private long videoId;
  private long part;
  private String partName;
  private long chapter;
  private String chapterName;
  private String linkUrl;
  private String extrai;
  private String extraii;
  private String extraiii;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getVideoId() {
    return videoId;
  }

  public void setVideoId(long videoId) {
    this.videoId = videoId;
  }


  public long getPart() {
    return part;
  }

  public void setPart(long part) {
    this.part = part;
  }


  public String getPartName() {
    return partName;
  }

  public void setPartName(String partName) {
    this.partName = partName;
  }


  public long getChapter() {
    return chapter;
  }

  public void setChapter(long chapter) {
    this.chapter = chapter;
  }


  public String getChapterName() {
    return chapterName;
  }

  public void setChapterName(String chapterName) {
    this.chapterName = chapterName;
  }


  public String getLinkUrl() {
    return linkUrl;
  }

  public void setLinkUrl(String linkUrl) {
    this.linkUrl = linkUrl;
  }


  public String getExtrai() {
    return extrai;
  }

  public void setExtrai(String extrai) {
    this.extrai = extrai;
  }


  public String getExtraii() {
    return extraii;
  }

  public void setExtraii(String extraii) {
    this.extraii = extraii;
  }


  public String getExtraiii() {
    return extraiii;
  }

  public void setExtraiii(String extraiii) {
    this.extraiii = extraiii;
  }

}
