import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InVehicleInfotainment implements Runnable {
    @Override
    public void run() {
        playMusic();
        showNavigation();
        connectSmartphone();
    }

    private final String filePath = "./Ressources/music.wav";
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
        String[] directions = {
            "Head north on Main St",
            "Turn right onto 1st Ave",
            "Continue straight for 3 miles",
            "Turn left onto Elm St",
            "Your destination is on the right"
        };
        int[] distances = {50, 40, 30, 20, 10, 0};
        try {
            for (int i = 0; i < directions.length; i++) {
                System.out.println(directions[i]);
                System.out.println("Distance to destination: " + distances[i] + " miles");

                // Simulate time taken to reach the next direction
                TimeUnit.SECONDS.sleep(2);
            }
            System.out.println("Arrived at destination!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void connectSmartphone() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to smartphone...");
    }
}