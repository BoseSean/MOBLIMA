package org.gp3.moblima.model;

/**
 * Created by zhangxinye on 19/10/17.
 */
public class Admin implements Model {
    /**
     * username -> administrator username
     * password -> administrator password
     */
    private String username ;
    private String password ;

    /**
     * Admin Class constructor
     * @param username
     * @param password
     */
    public Admin(String username,String password)
    {
        this.username=username;
        this.password=password;
    }

    /**
     * Get Administrator Password
     * @return password of Administrator
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set Administrator Password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get Administrator Username
     * @return username of Administrator
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set Administrator Username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
