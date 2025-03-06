public class InVehicleInfotainment implements Runnable {
    @Override
    public void run() {
        playMusic();
        showNavigation();
        connectSmartphone();
    }

    public void playMusic() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Playing music...");
    }

    public void showNavigation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Showing navigation...");
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
