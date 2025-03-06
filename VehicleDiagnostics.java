import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthStyle;

public class VehicleDiagnostics implements Runnable {
    @Override
    public void run() {
        try
        {
            readDTC();
            checkVehicleHealth();
            maintenanceReminder();
        }
        catch (IOException e)
        {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.err.println("Unexpected error: " +  e.getMessage());
        }

    }

    private final String dtcFile = "./IO/dtc_codes.txt";
    public void readDTC() throws IOException{
        System.out.println("Reading Diagnostic Trouble Codes (DTCs)...");
        String dtc = readFile(dtcFile);
        System.out.println("DTC: " + dtc);
        logDTC(dtc);
        
    }

    private void logDTC(String dtc) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("dtc_log.txt", true));
        writer.write("DTC: " + dtc + "\n");
        writer.close();
        System.out.println("DTC logged");
    }

    private String engineTemp;
    private String oilPressure;
    private String tirePressure;

    public void checkVehicleHealth() throws IOException {
        System.out.println("Checking vehicle health...");
        try {
            checkHealth();
        } catch (IOException e) {
            System.err.println("Error checking vehicle health: " + e.getMessage());
        }
    }

    private void checkHealth() throws IOException {
        engineTemp = readFile("./IO/engine_temp.txt");
        tirePressure = readFile("./IO/tire_pressure.txt");
        oilPressure = readFile("./IO/oil_pressure.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter("vehicle_health.txt", true));
        writer.write("Engine Temp: " + engineTemp + "\n");
        writer.write("Tire Pressure: " + tirePressure + "\n");
        writer.write("Oil Level: " + oilPressure + "\n");
        writer.close();

        System.out.println("Vehicle health logged");
    }

    public void maintenanceReminder() {
        System.out.println("Maintenance reminder:");
        if (!engineTemp.equals("Normal")) {
            System.out.println("Check engine temperature system.");
        }
        if (!oilPressure.equals("Normal")) {
            System.out.println("Check oil pressure system.");
        }
        if (!tirePressure.equals("Normal")) {
            System.out.println("Check and inflate tires to the recommended pressure.");
        }
        if (engineTemp.equals("Normal") && oilPressure.equals("Normal") && tirePressure.equals("Normal")) {
            System.out.println("No maintenance required at the moment.");
        }
    }

    private String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        return content.toString();
    }
}
