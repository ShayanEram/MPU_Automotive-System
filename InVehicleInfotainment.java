import javax.sound.sampled.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;

public class InVehicleInfotainment implements Runnable {
    @Override
    public void run() {
        // playMusic();
        // showNavigation();
        // connectSmartphone();
    }

    private final String filePath = "./IO/music.wav";
    private Clip clip;
    public void playMusic() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Playing music...");

        try{
            File musicFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
            if(clip != null && clip.isRunning()){
                clip.stop();
                clip.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();}
    }

    public void showNavigation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Starting navigation...");
        readFromGPS();
    }

    private final String gps = "./IO/navigation_instructions.txt";
    private void readFromGPS()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(gps)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private final String smartphoneConnection = "./IO/smartphone_connection.txt";
    public void connectSmartphone() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to smartphone...");
        readPhoneConnection();

    }

    private void readPhoneConnection()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(smartphoneConnection)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}