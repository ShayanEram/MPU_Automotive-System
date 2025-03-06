import java.sql.*;

public class VehicleDataBase implements Runnable {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/automotive";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "your_password"; // Replace with your root password

    @Override
    public void run() {
        // Example operations
        addMaintenanceRecord("VIN123", Date.valueOf("2023-04-05"), "Oil Change", "Oil Filter");
        getMaintenanceRecords("VIN123");
        addDriverProfile("John Doe", "Seat Position: 3, Temperature: 22C");
        getDriverProfiles();
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }

    public static void addMaintenanceRecord(String vehicleId, Date serviceDate, String serviceDescription, String partsReplaced) {
        String sql = "INSERT INTO maintenance_records (vehicle_id, service_date, service_description, parts_replaced) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehicleId);
            pstmt.setDate(2, serviceDate);
            pstmt.setString(3, serviceDescription);
            pstmt.setString(4, partsReplaced);
            pstmt.executeUpdate();
            System.out.println("Maintenance record added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getMaintenanceRecords(String vehicleId) {
        String sql = "SELECT * FROM maintenance_records WHERE vehicle_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehicleId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Service Date: " + rs.getDate("service_date"));
                System.out.println("Service Description: " + rs.getString("service_description"));
                System.out.println("Parts Replaced: " + rs.getString("parts_replaced"));
                System.out.println("---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addDriverProfile(String driverName, String driverPreference) {
        String sql = "INSERT INTO driver_profiles (driver_name, driver_preference) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, driverName);
            pstmt.setString(2, driverPreference);
            pstmt.executeUpdate();
            System.out.println("Driver profile added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDriverProfiles() {
        String sql = "SELECT * FROM driver_profiles";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Driver Name: " + rs.getString("driver_name"));
                System.out.println("Driver Preference: " + rs.getString("driver_preference"));
                System.out.println("---");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
