class BankAccount implements Runnable {
    private String name;
    private String type;

    public BankAccount(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[Check " + i + "] User: " + name + " | Type: " + type + 
                               " | Priority: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(2000); // Simulate 2-second check
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Thread t1 = new Thread(new BankAccount("Alice", "Premium"));
        Thread t2 = new Thread(new BankAccount("Bob", "Regular"));
        Thread t3 = new Thread(new BankAccount("Charlie", "Basic"));

        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t3.setPriority(Thread.MIN_PRIORITY);  // 1

        t1.start();
        t2.start();
        t3.start();
    }
}
