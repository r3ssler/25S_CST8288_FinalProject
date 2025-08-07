package com.algonquin.www.model;
/**
 * Request model for user login authentication.
 * <p>
 * Contains the username and password submitted by a user for authentication.
 * </p>
 */

public class LoginRequest {
    private String username;
    private String password;
    
     /**
     * Gets the username provided by the user.
     *
     * @return the username
     */

    public String getUsername() {
        return username;
        
    }
    
    /**
     * Sets the username provided by the user.
     *
     * @param username the username
     */

    public void setUsername(String username) {
        this.username = username;
        
    }
    
     /**
     * Gets the password provided by the user.
     *
     * @return the password
     */

    public String getPassword() {
        return password;
    }
    
     /**
     * Sets the password provided by the user.
     *
     * @param password the password
     */

    public void setPassword(String password) {
        this.password = password;
    }
}
