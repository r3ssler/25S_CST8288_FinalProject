package com.algonquin.www.model;
/**
 * Request model for registering a new vehicle.
 * <p>
 * Contains details required to register a vehicle including its type,
 * unique vehicle number, and assigned route.
 * </p>
 */

public class RegisterVehicleRequest {

    private String vehicleType;

    private String vehicleNumber;

    private String route;
     /**
     * Gets the type of the vehicle.
     *
     * @return the vehicle type
     */

    public String getVehicleType() {
        return vehicleType;
    }
     /**
     * Sets the type of the vehicle.
     *
     * @param vehicleType the vehicle type
     */

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
     /**
     * Gets the unique vehicle number.
     *
     * @return the vehicle number
     */

    public String getVehicleNumber() {
        return vehicleNumber;
    }
      /**
     * Sets the unique vehicle number.
     *
     * @param vehicleNumber the vehicle number
     */

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
     /**
     * Gets the route assigned to the vehicle.
     *
     * @return the route
     */

    public String getRoute() {
        return route;
    }
     /**
     * Sets the route assigned to the vehicle.
     *
     * @param route the route
     */

    public void setRoute(String route) {
        this.route = route;
    }
}
