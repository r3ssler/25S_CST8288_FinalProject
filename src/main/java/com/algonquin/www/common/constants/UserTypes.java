package com.algonquin.www.common.constants;

/**
 * Defines constant string values representing different user roles in the system.
 * <p>
 * These constants help standardize references to user types throughout the application.
 * </p>
 * 
 * <ul>
 *   <li>{@code ADMIN} - Represents an administrator user with elevated privileges.</li>
 *   <li>{@code OPERATOR} - Represents an operator user with standard operational privileges.</li>
 * </ul>
 * 
 * <p><b>Example usage:</b></p>
 * <pre>
 * if (user.getType().equals(UserTypes.ADMIN)) {
 *     // admin-specific logic
 * }
 * </pre>
 * 
 * <p><b>Note:</b> This interface is intended only for constants and should not be implemented.</p>
 * 
 * @author YourName
 */
public interface UserTypes {

    /**
     *
     */
    String ADMIN = "admin";

    /**
     *
     */
    String OPERATOR = "operator";
}
