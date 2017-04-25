package com.snail.smart.vo;

/**
 * @author snail
 * @create 2017/04/25
 */
public class UserParam extends Base {
    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
