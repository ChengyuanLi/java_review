package com;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Request {
    private String requestContent;
    private Map<String, String> params = new HashMap<>();
    private InetAddress ip;

    public Request(String requestContnet, Map<String, String> params, InetAddress inetAddress) {
        this.requestContent = requestContnet;
        this.params = params;
        this.ip = inetAddress;
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
        return this.params.get(key);
    }



}
