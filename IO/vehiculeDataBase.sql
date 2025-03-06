CREATE TABLE maintenance_records (
    id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_id VARCHAR(20),
    service_date DATE,
    service_description VARCHAR(255),
    parts_replaced VARCHAR(255)
);

CREATE TABLE driver_profiles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_name VARCHAR(50),
    driver_preference VARCHAR(255)
);

CREATE TABLE trip_logs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    distance FLOAT,
    fuel_consumption FLOAT,
    route VARCHAR(255)
);

CREATE TABLE telematics_data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_id VARCHAR(20),
    timestamp TIMESTAMP,
    gps_latitude FLOAT,
    gps_longitude FLOAT,
    speed FLOAT,
    engine_status VARCHAR(50)
);

CREATE TABLE vehicle_configuration (
    id INT PRIMARY KEY AUTO_INCREMENT,
    system_name VARCHAR(50),
    configuration_setting VARCHAR(255)
);
