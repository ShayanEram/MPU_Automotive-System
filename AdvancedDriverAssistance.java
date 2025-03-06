public class AdvancedDriverAssistance implements Runnable {
    @Override
    public void run() {
        laneDepartureWarning();
        adaptiveCruiseControl();
        collisionAvoidance();
    }

    public void laneDepartureWarning() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Lane departure warning activated...");
    }

    public void adaptiveCruiseControl() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Adaptive cruise control activated...");
    }

    public void collisionAvoidance() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Collision avoidance system activated...");
    }
}
