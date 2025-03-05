public class Main {
    public static void main(String[] args) {
        // Create instances of each class
        InVehicleInfotainment ivs = new InVehicleInfotainment();
        TelematicsSystem ts = new TelematicsSystem();
        VehicleDiagnostics vd = new VehicleDiagnostics();
        AdvancedDriverAssistance ada = new AdvancedDriverAssistance();
        ConnectedCarApp cca = new ConnectedCarApp();

        // Demonstrate functionality
        System.out.println("In-Vehicle Infotainment System:");
        ivs.playMusic();
        ivs.showNavigation();
        ivs.connectSmartphone();
        System.out.println();

        System.out.println("Telematics System:");
        ts.trackVehicle();
        ts.remoteDiagnostics();
        ts.emergencyAssistance();
        System.out.println();

        System.out.println("Vehicle Diagnostics:");
        vd.readDTC();
        vd.checkVehicleHealth();
        vd.maintenanceReminder();
        System.out.println();

        System.out.println("Advanced Driver Assistance Systems (ADAS):");
        ada.laneDepartureWarning();
        ada.adaptiveCruiseControl();
        ada.collisionAvoidance();
        System.out.println();

        System.out.println("Connected Car Application:");
        cca.remoteStart();
        cca.lockUnlockDoors();
        cca.vehicleStatus();
    }
}
