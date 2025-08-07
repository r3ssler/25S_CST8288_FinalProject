package com.algonquin.www.model;
/**
 * Model representing pagination request parameters.
 * <p>
 * Used to specify the page number and size for paginated queries.
 * </p>
 */

public class PageRequest {
    private int pageNumber;
    private int pageSize;
    /**
     * Gets the current page number (starting from 1).
     *
     * @return the page number
     */

    public int getPageNumber() {
        return pageNumber;
    }
     /**
     * Sets the current page number (starting from 1).
     *
     * @param pageNumber the page number to set
     */

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
     /**
     * Gets the number of records per page.
     *
     * @return the page size
     */

    public int getPageSize() {
        return pageSize;
    }
      /**
     * Sets the number of records per page.
     *
     * @param pageSize the page size to set
     */

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
