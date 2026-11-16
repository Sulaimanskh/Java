package multithreading_ecommerce;

// مثال على إنشاء ثريد عبر توريث كلاس Thread مباشرة لإدارة تحديثات المخزون الخلفية
public class RestockerThread extends Thread {
    private Inventory inventory;
    private int restockAmount;

    public RestockerThread(Inventory inventory, int restockAmount) {
        super("Background-Restocker-Worker");
        this.inventory = inventory;
        this.restockAmount = restockAmount;
    }

    @Override
    public void run() {
        try {
            // انتظار قصير لتمكين بعض طلبات العملاء من البدء أولاً
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // ضخ كمية جديدة من المنتجات في المخزون
        inventory.restock(restockAmount);
    }
}