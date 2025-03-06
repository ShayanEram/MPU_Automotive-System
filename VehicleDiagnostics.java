public class VehicleDiagnostics implements Runnable {
    @Override
    public void run() {
        readDTC();
        checkVehicleHealth();
        maintenanceReminder();
    }

    public void readDTC() {
        // Simulated reading of diagnostic trouble codes (DTCs)
        // System.out.println("Reading Diagnostic Trouble Codes (DTCs)...");
        // System.out.println("DTC: P0420 - Catalyst System Efficiency Below Threshold (Bank 1)");
    }

    public void checkVehicleHealth() {
        //System.out.println("Checking vehicle health...");
    }

    public void maintenanceReminder() {
        //System.out.println("Maintenance reminder: Time for an oil change.");
    }
}
