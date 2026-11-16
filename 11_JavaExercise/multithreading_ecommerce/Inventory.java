package multithreading_ecommerce;

public class Inventory {
    private int stockCount;

    public Inventory(int initialStock) {
        this.stockCount = initialStock;
    }

    // دالة مزامنة (Synchronized) لضمان عدم حدوث تضارب في المخزون عند الشراء المتزامن
    public synchronized boolean purchase(String customerName, int amount) {
        System.out.println("[Transaction] " + customerName + " is attempting to buy " + amount + " units.");
        
        // محاكاة تأخير شبكي بسيط أثناء عملية الدفع
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (stockCount >= amount) {
            stockCount -= amount;
            System.out.println("[Success] " + customerName + " purchased " + amount + " units. Remaining stock: " + stockCount);
            return true;
        } else {
            System.out.println("[Failed] " + customerName + " order rejected. Not enough stock (Available: " + stockCount + ")");
            return false;
        }
    }

    // دالة مزامنة لإعادة تعبئة المخزون من قِبل نظام الخلفية
    public synchronized void restock(int amount) {
        System.out.println("\n[Restock System] Restocking warehouse with " + amount + " new units...");
        stockCount += amount;
        System.out.println("[Restock Complete] Current stock level: " + stockCount + "\n");
    }

    public int getStockCount() {
        return stockCount;
    }
}