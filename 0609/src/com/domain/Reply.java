package com.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aidenli
 */
public class Reply implements Serializable {
    private Integer rno;
    private String content;
    private Integer bno;
    private Integer uno;
    private Date createdate;

    public Reply() {
    }

    public Reply(Integer rno, String content, Integer bno, Integer uno, Date createdate) {
        this.rno = rno;
        this.content = content;
        this.bno = bno;
        this.uno = uno;
        this.createdate = createdate;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
