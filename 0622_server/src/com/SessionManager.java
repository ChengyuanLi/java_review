package com;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * manage session
 * @author aidenli
 */
public class SessionManager {
    static Map<String, Session> sessions = new HashMap<>();

    public static Session getSession(String key) {
        Session session = sessions.get(key);

        if (session == null) {
            session = new Session();
            String sid = generateSessionId();
            session.setSessionId(sid);
            sessions.put(key, session);
            return session;
        }

        return session;
    }

    private static String generateSessionId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
