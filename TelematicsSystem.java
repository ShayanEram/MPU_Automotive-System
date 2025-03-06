import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;

public class TelematicsSystem implements Runnable {
    @Override
    public void run() {
        trackVehicle();
        remoteDiagnostics();
        emergencyAssistance();
    }

    public void trackVehicle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Tracking vehicle location...");
    }

    public void remoteDiagnostics() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Performing remote diagnostics...");
    }

    public void emergencyAssistance() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Providing emergency assistance...");
    }
}
