package com.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 装载一个post信息
 * @author aidenli
 */
public class Blog implements Serializable {
    private Integer bno;
    private String content;
    private Integer uno;
    private Date createDate;

    //关联属性
    private String uname;

    public Blog() {
    }

    public Blog(Integer bno, String content, Integer uno, Date createDate, String uname) {
        this.bno = bno;
        this.content = content;
        this.uno = uno;
        this.createDate = createDate;
        this.uname = uname;
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
