
package com.algonquin.www.dao;

import com.algonquin.www.domain.UserDTO;

/**
 * Data Access Object (DAO) interface for managing {@link UserDTO} entities.
 * <p>
 * Defines methods to perform user-related database operations such as
 * finding a user by credentials and adding a new user.
 * </p>
 * 
 * <p>This interface abstracts the data storage mechanism for user data,
 * allowing implementations to interact with various persistence solutions.</p>
 * 
 * @author
 * @version 1.0
 * @since 2025-08-07
 */

public interface UserDAO {
    
    /**
     * Finds a user by the specified username and password.
     *
     * @param username the username of the user to find
     * @param password the password associated with the username
     * @return the {@link UserDTO} matching the username and password, or null if no match is found
     */

    UserDTO findUser(String username, String password);
    /**
     * Adds a new user to the data store.
     *
     * @param user the {@link UserDTO} object containing user details to add
     * @return true if the user was successfully added, false otherwise
     */

    boolean addUser(UserDTO user);

}
