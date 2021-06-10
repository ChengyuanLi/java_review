package com.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 一个回复实体类
 * @author aidenli
 */
public class Reply implements Serializable {
    private Integer rno;
    private String content;
    private Integer uno;
    private Integer bno;
    private Date createDate;

    public Reply() {}

    public Reply(Integer rno, String content, Integer uno, Integer bno, Date createDate) {
        this.rno = rno;
        this.content = content;
        this.uno = uno;
        this.bno = bno;
        this.createDate = createDate;
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

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
