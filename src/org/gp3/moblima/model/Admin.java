package org.gp3.moblima.model;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class Admin implements Model {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
