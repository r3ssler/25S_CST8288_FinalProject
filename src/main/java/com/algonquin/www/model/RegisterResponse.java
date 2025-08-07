package com.algonquin.www.model;
/**
 * Response model representing the result of a user registration attempt.
 * <p>
 * Contains a boolean flag indicating whether the registration was successful.
 * </p>
 */

public class RegisterResponse {

    private boolean result;
     /**
     * Returns whether the registration was successful.
     *
     * @return true if registration succeeded; false otherwise
     */

    public boolean isResult() {
        return result;
    }
     /**
     * Sets the result of the registration attempt.
     *
     * @param result true if registration succeeded; false otherwise
     */

    public void setResult(boolean result) {
        this.result = result;
    }
}
