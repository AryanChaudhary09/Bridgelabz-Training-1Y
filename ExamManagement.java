class ExamActivity extends Thread {
    private String activityName;
    private int delay;

    public ExamActivity(String name, int delay, int priority) {
        this.activityName = name;
        this.delay = delay;
        this.setPriority(priority);
    }

    public void run() {
        try {
            Thread.sleep(delay * 1000);
            System.out.println("State of " + activityName + " during execution: " + this.getState());
            System.out.println("Starting: " + activityName + " (Priority: " + this.getPriority() + ")");
            Thread.sleep(2000); // Simulate activity duration
            System.out.println("Finished: " + activityName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExamManagement {
    public static void main(String[] args) throws InterruptedException {
        ExamActivity entry = new ExamActivity("Student Entry", 0, 5);
        ExamActivity papers = new ExamActivity("Paper Distribution", 5, 10);
        ExamActivity attendance = new ExamActivity("Attendance", 10, 8);
        ExamActivity collection = new ExamActivity("Sheet Collection", 15, 7);

        System.out.println("Initial State - Entry: " + entry.getState());
        
        entry.start();
        papers.start();
        attendance.start();
        collection.start();

        entry.join();
        papers.join();
        attendance.join();
        collection.join();
        
        System.out.println("All activities finished. Final state - Collection: " + collection.getState());
    }
}
