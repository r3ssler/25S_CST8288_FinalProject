package com.algonquin.www.model;

/**
 * Response model returned after a successful user login.
 * <p>
 * Contains user identification details including ID, username, email, name,
 * and user type.
 * </p>
 */

public class LoginResponse {
    private String id;
    private String username;
    private String email;
    private String name;
    private int type;
    
     /**
     * Gets the unique identifier of the user.
     *
     * @return the user ID as a String
     */

    public String getId() {
        return id;
    }
    
    
    
    /**
     * Sets the unique identifier of the user.
     *
     * @param id the user ID as a String
     */

    public void setId(String id) {
        this.id = id;
    }
    
    
    /**
     * Gets the username of the user.
     *
     * @return the username
     */

    public String getUsername() {
        return username;
    }
    
     /**
     * Sets the username of the user.
     *
     * @param username the username
     */

    public void setUsername(String username) {
        this.username = username;
    }
    
     /**
     * Gets the email address of the user.
     *
     * @return the email address
     */

    public String getEmail() {
        return email;
    }
    
     /**
     * Sets the email address of the user.
     *
     * @param email the email address
     */

    public void setEmail(String email) {
        this.email = email;
    }
    
      /**
     * Gets the full name of the user.
     *
     * @return the user's full name
     */

    public String getName() {
        return name;
    }
    
    /**
     * Sets the full name of the user.
     *
     * @param name the user's full name
     */

    public void setName(String name) {
        this.name = name;
    }
    
     /**
     * Gets the user type.
     * <p>
     * Typically represents roles or access levels (e.g., admin, regular user).
     * </p>
     *
     * @return the user type as an integer
     */
    
    public int getType() {
        return type;
    }
    
    /**
     * Sets the user type.
     *
     * @param type the user type as an integer
     */

    public void setType(int type) {
        this.type = type;
    }
}
