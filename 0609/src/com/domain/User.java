package com.domain;

import java.io.Serializable;

/**
 * 装一个用户信息
 * @author aidenli
 */

public class User implements Serializable {
    private Integer uno;
    private String uname;
    private String upass;

    public User() {
    }

    public User(Integer uno, String uname, String upass) {
        this.uno = uno;
        this.uname = uname;
        this.upass = upass;
    }

    public Integer getUno() {
        return uno;
    }

    public void setUno(Integer uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
