package com;

import java.net.InetAddress;
import java.util.Enumeration;
import java.util.Map;

public class Request {
    private String requestContent;
    private Map<String, String> params;
    private InetAddress ip;

    public Request() {
    }

    public Request(String requestContent, Map<String, String> params, InetAddress ip) {
        this.requestContent = requestContent;
        this.params = params;
        this.ip = ip;
    }

    public String getRequestContent() {
        return requestContent;
    }

    void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    Map<String, String> getParams() {
        return params;
    }

    void setParams(Map<String, String> params) {
        this.params = params;
    }

    public InetAddress getIp() {
        return ip;
    }

    void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public String getParameter(String key) {
        return params.get(key);
    }


}
