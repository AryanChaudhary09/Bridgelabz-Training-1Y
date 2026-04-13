class Order implements Runnable {
    private int orderId;
    private String restaurant;
    private int deliveryTime;
    private String type;

    public Order(int id, String restaurant, int time, String type) {
        this.orderId = id;
        this.restaurant = restaurant;
        this.deliveryTime = time;
        this.type = type;
    }

    @Override
    public void run() {
        String agent = Thread.currentThread().getName();
        long startTime = System.currentTimeMillis();

        System.out.println(agent + " Picked up Order #" + orderId + " (" + type + ") from " + restaurant);
        try {
            System.out.println("Order #" + orderId + " is In Transit...");
            Thread.sleep(deliveryTime * 1000);
            System.out.println("Order #" + orderId + " Delivered!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long totalTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println(">> Total delivery time for Order #" + orderId + ": " + totalTime + "s");
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Thread[] orders = {
            createOrder(101, "Pizza Hut", 2, "Express", 10),
            createOrder(102, "Burger King", 4, "Standard", 5),
            createOrder(103, "Sushi Zen", 5, "Economy", 3),
            createOrder(104, "Taco Bell", 1, "Express", 10),
            createOrder(105, "Subway", 3, "Standard", 5)
        };

        for (Thread t : orders) t.start();
    }

    private static Thread createOrder(int id, String res, int time, String type, int prio) {
        Thread t = new Thread(new Order(id, res, time, type), "Agent-" + id);
        t.setPriority(prio);
        return t;
    }
}
