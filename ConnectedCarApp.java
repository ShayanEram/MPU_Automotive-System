public class ConnectedCarApp implements Runnable {
    @Override
    public void run() {
        remoteStart();
        lockUnlockDoors();
        vehicleStatus();
    }

    public void remoteStart() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Starting the car remotely...");
    }

    public void lockUnlockDoors() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Locking/unlocking doors remotely...");
    }

    public void vehicleStatus() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Retrieving vehicle status...");
    }
}
