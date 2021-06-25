package com;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class Session {

    private String sessionId;

    Map<String, Object> content = new HashMap<>();

    public String getSessionId() {
        return sessionId;
    }

    void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setAttribute(String key, Object value) {
        content.put(key, value);
    }

    public Object getAttribute(String key) {
        return content.get(key);
    }

    public int size() {
        return content.size();
    }

    public void removeAttribute(String key) {
        content.remove(key);
    }
}
