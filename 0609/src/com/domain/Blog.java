package com.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author aidenli
 */
public class Blog implements Serializable {
    private Integer bno;
    private String content;
    private Integer uno;
    private Date createdate;

    public Blog() {
    }

    public Blog(Integer bno, String content, Integer uno, Date createdate) {
        this.bno = bno;
        this.content = content;
        this.uno = uno;
        this.createdate = createdate;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
