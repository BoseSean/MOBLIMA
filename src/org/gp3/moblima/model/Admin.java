package org.gp3.moblima.model;

/**
 * The model to hold all the admin info.
 * Also holds all the getter and sertter for the attributes in admin class
 */
public class Admin implements Model {
    private String username ;
    /**
     * The administrator password
     */
    private String password ;

    /**
     * Admin Class constructor
     * @param username usernme to be set for admin
     * @param password password to be set for admin
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
     * @param password value to be set as the password
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
     * @param username username to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
