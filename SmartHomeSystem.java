import java.time.LocalTime;

class Device extends Thread {
    private String deviceName;
    private int interval;

    public Device(String name, int interval, int priority) {
        this.deviceName = name;
        this.interval = interval;
        this.setPriority(priority);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(LocalTime.now() + " - " + deviceName + " performing cycle " + i);
            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(deviceName + " completed all cycles.");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Device security = new Device("Security Camera", 3, 10);
        Device temp = new Device("Temp Sensor", 5, 7);
        Device light = new Device("Light Controller", 4, 5);
        Device door = new Device("Door Monitor", 6, 5);

        security.start();
        temp.start();
        light.start();
        door.start();
    }
}
