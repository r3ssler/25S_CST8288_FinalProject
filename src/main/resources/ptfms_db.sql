-- Drop the database if it exists
DROP DATABASE IF EXISTS ptfms;

-- Create the database
CREATE DATABASE IF NOT EXISTS ptfms CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ptfms;

-- Table: User
CREATE TABLE User (
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL UNIQUE,
    name     VARCHAR(100),
    type     VARCHAR(100) NOT NULL
);

INSERT INTO User (username, password, email, name, type) VALUES
('admin1', 'adminpass123', 'admin1@example.com', 'Alice Manager', 'admin'),
('op_john', 'opjohnpass', 'john.doe@example.com', 'John Doe', 'operator'),
('op_jane', 'opjanepass', 'jane.smith@example.com', 'Jane Smith', 'operator'),
('admin2', 'adminpass456', 'admin2@example.com', 'Bob Supervisor', 'admin'),
('tech_lee', 'lee123', 'lee.tech@example.com', 'Lee Technician', 'operator');

-- Table: Vehicle
CREATE TABLE Vehicle (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    vehicleNumber   VARCHAR(20) NOT NULL UNIQUE,
    vehicleType     VARCHAR(50) NOT NULL,
    energyType      VARCHAR(50) NOT NULL,
    consumptionRate DOUBLE,
    maxPassengers   INT,
    route           VARCHAR(100),
    status          VARCHAR(50) DEFAULT 'Active'
);

INSERT INTO Vehicle (vehicleNumber, vehicleType, energyType, consumptionRate, maxPassengers, route, status) VALUES
('BUS1001', 'Bus', 'Diesel', 8.2, 40, 'Route A', 'Active'),
('TRAM201', 'Tram', 'Electric', 12.5, 60, 'Route B', 'Under Maintenance'),
('TRAIN3001', 'Train', 'Diesel-Electric', 30.1, 150, 'Route C', 'Active'),
('BUS1002', 'Bus', 'Electric', 6.0, 45, 'Route D', 'Inactive'),
('BUS1003', 'Bus', 'Diesel', 7.9, 50, 'Route E', 'Active');

-- Table: Component
CREATE TABLE Component (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    vehicleNumber VARCHAR(20),
    name          VARCHAR(100) NOT NULL,
    usedHours     DOUBLE DEFAULT 0
);

INSERT INTO Component (vehicleNumber, name, usedHours) VALUES
('BUS1001', 'Brake Pads', 1500),
('BUS1001', 'Battery', 800),
('TRAM201', 'Engine Motor', 3000),
('TRAIN3001', 'Cooling System', 5000),
('BUS1002', 'Suspension', 1200);

-- Table: ExpenseRecord
CREATE TABLE ExpenseRecord (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    vehicleNumber VARCHAR(20) NOT NULL,
    type         VARCHAR(50) NOT NULL,
    expense      DOUBLE NOT NULL,
    usageAmount  DOUBLE,
    lastMile     DOUBLE,
    currentMile  DOUBLE
);

INSERT INTO ExpenseRecord (vehicleNumber, type, expense, usageAmount, lastMile, currentMile) VALUES
('BUS1001', 'Fuel', 120.50, 15, 10000, 10050),
('TRAM201', 'Maintenance', 450.00, NULL, 15000, 15000),
('BUS1002', 'Battery Replacement', 600.00, NULL, 8500, 8500),
('TRAIN3001', 'Oil Change', 200.00, 5, 20000, 20030),
('BUS1003', 'Fuel', 90.00, 10, 3000, 3050);

-- Table: PerformanceMetric
CREATE TABLE PerformanceMetric (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId          BIGINT NOT NULL,
    userName        VARCHAR(100),
    totalTrip       INT DEFAULT 0,
    totalOnTimeTrip INT DEFAULT 0,
    totalTime       INT DEFAULT 0
);

INSERT INTO PerformanceMetric (userId, userName, totalTrip, totalOnTimeTrip, totalTime) VALUES
(2, 'John Doe', 120, 115, 3000),
(3, 'Jane Smith', 98, 90, 2400),
(5, 'Lee Technician', 85, 80, 2100),
(2, 'John Doe', 20, 19, 600),  -- sample for duplicate trip periods
(3, 'Jane Smith', 50, 48, 1100);

-- Table: VehicleLog
CREATE TABLE VehicleLog (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    vehicleNumber VARCHAR(20),
    logType       VARCHAR(50),
    location      VARCHAR(100),
    logTime       DATETIME NOT NULL
);

INSERT INTO VehicleLog (vehicleNumber, logType, location, logTime) VALUES
('BUS1001', 'Start', 'Depot A', '2025-08-01 08:00:00'),
('BUS1001', 'Stop', 'Station 3', '2025-08-01 09:15:00'),
('TRAM201', 'Breakdown', 'Station 1', '2025-08-02 10:00:00'),
('TRAIN3001', 'Start', 'Yard C', '2025-08-02 06:30:00'),
('BUS1003', 'Stop', 'Depot B', '2025-08-03 18:45:00');
