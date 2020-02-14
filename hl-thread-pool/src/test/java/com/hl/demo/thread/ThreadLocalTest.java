package com.hl.demo.thread;

import org.junit.Test;

/**
 * @author Hailin
 * @date 2019/12/27
 */
public class ThreadLocalTest {

    @Test
    public void test() {

        User user = new User();
        ThreadLocal<String> username = new ThreadLocal<>();
        username.set("Jack");
        user.setUsername(username);
        ThreadLocal<String> password = new ThreadLocal<>();
        password.set("123");
        user.setPassword(password);
        System.out.println(user.getUsername().get());
        System.out.println(user.getPassword().get());
        System.out.println(username.get());

    }
}

class User {

    private ThreadLocal<String> username;

    private ThreadLocal<String> password;

    public ThreadLocal<String> getUsername() {
        return username;
    }

    public void setUsername(ThreadLocal<String> username) {
        this.username = username;
    }

    public ThreadLocal<String> getPassword() {
        return password;
    }

    public void setPassword(ThreadLocal<String> password) {
        this.password = password;
    }
}
