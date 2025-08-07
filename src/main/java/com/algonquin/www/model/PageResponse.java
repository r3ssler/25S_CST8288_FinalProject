package com.algonquin.www.model;
/**
 * Model representing pagination response metadata.
 * <p>
 * Contains details about the current page number, page size, and total number of records.
 * </p>
 */

public class PageResponse {
    private int pageSize;
    private int pageNumber;
    private int totalCount;
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
     * Gets the total count of records available across all pages.
     *
     * @return the total count of records
     */

    public int getTotalCount() {
        return totalCount;
    }
     /**
     * Sets the total count of records available across all pages.
     *
     * @param totalCount the total count of records
     */

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
