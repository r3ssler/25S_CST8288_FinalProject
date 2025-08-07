package com.algonquin.www.domain;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) representing a User entity.
 * <p>
 * Contains user details such as ID, username, password, email, full name,
 * and user type (e.g., admin, operator).
 * </p>
 */

public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String type;
    
        /**
     * Gets the unique identifier of the user.
     *
     * @return the user's id
     */


    public Long getId() {
        return id;
    }
    
    /**
     * Sets the unique identifier of the user.
     *
     * @param id the user's id
     */


    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * Gets the username used for login.
     *
     * @return the username
     */

    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username used for login.
     *
     * @param username the username
     */

    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Gets the user's password.
     * <p>
     * Note: For security, passwords should be hashed and handled carefully.
     * </p>
     *
     * @return the password
     */

    public String getPassword() {
        return password;
    }
    
    
    /**
     * Sets the user's password.
     * <p>
     * Note: For security, passwords should be hashed and handled carefully.
     * </p>
     *
     * @param password the password
     */

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Gets the user's email address.
     *
     * @return the email
     */

    public String getEmail() {
        return email;
    }
    
     /**
     * Sets the user's email address.
     *
     * @param email the email
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
     * Gets the type of user.
     * <p>
     * Examples include roles like "admin", "operator", etc.
     * </p>
     *
     * @return the user type
     */

    public String getType() {
        return type;
    }
    
    /**
     * Sets the type of user.
     * <p>
     * Examples include roles like "admin", "operator", etc.
     * </p>
     *
     * @param type the user type
     */

    public void setType(String type) {
        this.type = type;
    }
}
