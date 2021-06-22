package com.domain;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
    private Integer rno;
    private String content;
    private Integer bno;
    private Integer uno;
    private Date createDate;

    //关联属性
    private String uname;

    public Reply() {
    }

    public Reply(Integer rno, String content, Integer bno, Integer uno, Date createDate, String uname) {
        this.rno = rno;
        this.content = content;
        this.bno = bno;
        this.uno = uno;
        this.createDate = createDate;
        this.uname = uname;
    }

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
