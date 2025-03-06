public class Main {
    public static void main(String[] args) {
        // Create instances of each class
        InVehicleInfotainment ivs = new InVehicleInfotainment();
        TelematicsSystem ts = new TelematicsSystem();
        VehicleDiagnostics vd = new VehicleDiagnostics();
        AdvancedDriverAssistance ada = new AdvancedDriverAssistance();
        ConnectedCarApp cca = new ConnectedCarApp();

        // Create threads for each module
        Thread ivsThread = new Thread(ivs);
        Thread tsThread = new Thread(ts);
        Thread vdThread = new Thread(vd);
        Thread adaThread = new Thread(ada);
        Thread ccaThread = new Thread(cca);

        // Start all threads
        ivsThread.start();
        tsThread.start();
        vdThread.start();
        adaThread.start();
        ccaThread.start();

        // Wait for all threads to finish
        try {
            ivsThread.join();
            tsThread.join();
            vdThread.join();
            adaThread.join();
            ccaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All modules have finished running.");
    }
}
