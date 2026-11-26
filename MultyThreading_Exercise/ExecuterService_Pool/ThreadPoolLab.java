import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 1. Order Processing Task (Takes 1 second per order)
class OrderProcessor implements Runnable {
    private int orderId;

    public OrderProcessor(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        String workerName = Thread.currentThread().getName();
        System.out.println("[PROCESSING] Order #" + orderId + " started by -> " + workerName);
        
        try {
            // Simulate processing time (1 second)
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("[COMPLETED]  Order #" + orderId + " finished by -> " + workerName);
    }
}

public class ThreadPoolLab {
    public static void main(String[] args) throws InterruptedException {
        
        // Experiment 1: Single Worker (SingleThreadExecutor)
        System.out.println("--- 1. Starting Experiment with 1 Worker (Single) ---");
        runExperiment(Executors.newSingleThreadExecutor(), 10);

        // Experiment 2: Fixed Team of 3 Workers (FixedThreadPool)
        System.out.println("\n--- 2. Starting Experiment with Fixed Team of 3 Workers (Fixed = 3) ---");
        runExperiment(Executors.newFixedThreadPool(3), 10);

        // Experiment 3: Flexible Team on Demand (CachedThreadPool)
        System.out.println("\n--- 3. Starting Experiment with Flexible Team (Cached) ---");
        runExperiment(Executors.newCachedThreadPool(), 10);
    }

    private static void runExperiment(ExecutorService executor, int totalOrders) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= totalOrders; i++) {
            executor.execute(new OrderProcessor(i));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endTime = System.currentTimeMillis();
        double durationInSeconds = (endTime - startTime) / 1000.0;
        
        System.out.println("==> Total Time to complete 10 orders: " + durationInSeconds + " seconds.");
    }
}
