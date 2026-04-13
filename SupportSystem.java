import java.util.Random;

class Ticket extends Thread {
    private int ticketNum;
    private String type;
    private static long totalWaitTime = 0;
    private static int processedCount = 0;

    public Ticket(int num, String type, int priority) {
        this.ticketNum = num;
        this.type = type;
        this.setPriority(priority);
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Agent [" + Thread.currentThread().getName() + "] STARTING Ticket #" + 
                           ticketNum + " (" + type + ") Priority: " + this.getPriority());
        
        try {
            int processTime = new Random().nextInt(5) + 1;
            Thread.sleep(processTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000;
        
        synchronized(Ticket.class) {
            totalWaitTime += duration;
            processedCount++;
            System.out.println("Ticket #" + ticketNum + " COMPLETED. Time: " + duration + "s");
            if (processedCount == 10) {
                System.out.println("\n--- Statistics ---");
                System.out.println("Average Processing Time: " + (double)totalWaitTime/10 + "s");
            }
        }
    }
}

public class SupportSystem {
    public static void main(String[] args) {
        String[] types = {"Critical Bug", "Feature Request", "General Query", "Feedback"};
        int[] priorities = {10, 4, 2, 1};

        for (int i = 1; i <= 10; i++) {
            int randIndex = new Random().nextInt(4);
            Ticket t = new Ticket(i, types[randIndex], priorities[randIndex]);
            t.setName("Agent-" + i);
            t.start();
        }
    }
}
