package multithreading_ecommerce;

// تطبيق الواجهة Runnable لتمثيل مهام العملاء الذين يتسوقون في نفس الوقت
public class CustomerTask implements Runnable {
    private String customerName;
    private Inventory inventory;
    private int requestedUnits;

    public CustomerTask(String customerName, Inventory inventory, int requestedUnits) {
        this.customerName = customerName;
        this.inventory = inventory;
        this.requestedUnits = requestedUnits;
    }

    @Override
    public void run() {
        System.out.println("[Thread Active] Customer thread started for: " + customerName);
        
        // محاكاة وقت تصفح العميل للمنتج واختيار الطلب
        try {
            Thread.sleep((long) (Math.random() * 200));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // تنفيذ طلب الشراء الآمن عبر المورد المشترك
        inventory.purchase(customerName, requestedUnits);
    }
}