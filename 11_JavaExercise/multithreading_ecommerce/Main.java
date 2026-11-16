package multithreading_ecommerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== E-COMMERCE MULTITHREADING SIMULATION ===");
        System.out.print("Enter initial warehouse stock quantity: ");
        int initialStock = input.nextInt();

        // إنشاء المورد المشترك (المخزون)
        Inventory sharedInventory = new Inventory(initialStock);

        // 1. إنشاء ثريد الخلفية لإعادة تعبئة المخزون (يرث Thread)
        RestockerThread restocker = new RestockerThread(sharedInventory, 15);

        // 2. إنشاء ثريدات العملاء باستخدام Runnable وتمريرها لكلاس Thread
        Thread customer1 = new Thread(new CustomerTask("Ahmed", sharedInventory, 6), "Thread-Customer-1");
        Thread customer2 = new Thread(new CustomerTask("Khaled", sharedInventory, 10), "Thread-Customer-2");
        Thread customer3 = new Thread(new CustomerTask("Suleiman", sharedInventory, 5), "Thread-Customer-3");

        System.out.println("\n--- Starting Concurrent Store Operations ---");

        // تشغيل المسارات (Threads) باستخدام دالة start()
        restocker.start();
        customer1.start();
        customer2.start();
        customer3.start();

        // استخدام دالة join() لضمان أن البرنامج الرئيسي (Main) ينتظر حتى تنتهي كافة الثريدات تماماً
        try {
            restocker.join();
            customer1.join();
            customer2.join();
            customer3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("\n========================================");
        System.out.println("All concurrent transactions finished.");
        System.out.println("Final Warehouse Stock Level: " + sharedInventory.getStockCount());
        System.out.println("========================================");

        input.close();
    }
}