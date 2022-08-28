package com.so.studyonline.entity;

public class VerifyCode {
    private int id;
    private String findIp;
    private String addTime;
    private String codeValue;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFindIp() {
        return findIp;
    }

    public void setFindIp(String findIp) {
        this.findIp = findIp;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
