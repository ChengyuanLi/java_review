package com.service;

import java.util.Map;

/**
 * for basic variables
 */
public class Request {
    private String content;
    private Map<String, String> params;
    private String ip;

    public String getParameter(String key) {
        return params.get(key);
    }

    public String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getParams() {
        return params;
    }

    void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    void setIp(String ip) {
        this.ip = ip;
    }
}
