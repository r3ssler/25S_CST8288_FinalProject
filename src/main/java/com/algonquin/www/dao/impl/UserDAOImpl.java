
package com.algonquin.www.dao.impl;

import com.algonquin.www.common.db.DataSource;
import com.algonquin.www.dao.AbstractGenericDAO;
import com.algonquin.www.dao.UserDAO;
import com.algonquin.www.domain.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Implementation of {@link UserDAO} for managing User entities in the database.
 */

public class UserDAOImpl extends AbstractGenericDAO implements UserDAO {
    
    /**
     * Finds a user by their username and password.
     * <p>
     * This method queries the database for a user record matching the provided
     * username and password. If a match is found, a {@link UserDTO} object
     * representing the user is returned; otherwise, returns null.
     * </p>
     *
     * @param username the username to search for
     * @param password the password to match
     * @return the matching {@link UserDTO} if found; otherwise null
     */
    
    @Override
    public UserDTO findUser(String username, String password) {
        Connection connection = DataSource.createConnection();
        UserDTO user = null;
        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new UserDTO();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                    user.setType(rs.getString("type"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
    /**
     * Adds a new user to the database.
     * <p>
     * This method inserts a new user record into the database using the details
     * provided in the given {@link UserDTO} object.
     * </p>
     *
     * @param user the {@link UserDTO} object containing user details to be added
     * @return {@code true} if the user was successfully added; {@code false} otherwise
     */
    
    

    @Override
    public boolean addUser(UserDTO user) {
        Connection connection = DataSource.createConnection();
        String sql = "INSERT INTO User (username, password, email, name, type) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getType());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
