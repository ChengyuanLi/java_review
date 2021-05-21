package com.store;
import com.domain.User;
import com.util.ArrayBox;
import com.util.Box;
/**
 * @author aidenli
 */
public class UserStore {
    private UserStore(){}
    private static UserStore userStore;
    public static UserStore getInstance() {
        if (userStore == null) {
            userStore = new UserStore();
        }
        return userStore;
    }
    private Box users = new ArrayBox();

    {
        User u1 = new User("lcy", "123");
        User u2 = new User("mtf", "123");
        User u3 = new User("yxh", "123");
        User u4 = new User("lzj", "123");
        User u5 = new User("tzr", "123");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
    }

    public User findUserByName(String uname) {
        for (int i = 0; i < users.size(); i++) {
            User user = (User) users.get(i);
            if (user.getUname().equals(uname)) {
                return user;
            }
        }
        return null;
    }
}
