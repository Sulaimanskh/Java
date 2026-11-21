package my_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListEcommerceDemo {

    public static void main(String[] args) {
        System.out.println("=== E-COMMERCE LIST COLLECTIONS ARCHITECTURE ===\n");

        // 1. ArrayList: الأنسب لكتالوج المنتجات (سريع جداً في القراءة والوصول عبر الفهرس)
        List<String> productCatalog = new ArrayList<>();
        productCatalog.add("Laptop Dell XPS");
        productCatalog.add("Wireless Mouse");
        productCatalog.add("Mechanical Keyboard");
        productCatalog.add("4K Monitor");
        productCatalog.add(1, "USB-C Hub"); // إدراج في موقع محدد

        System.out.println("--- 1. Product Catalog (ArrayList) ---");
        System.out.println("Initial Catalog: " + productCatalog);
        System.out.println("Featured Item (Index 2): " + productCatalog.get(2)); // وصول سريع O(1)
        System.out.println("Catalog Size: " + productCatalog.size());
        System.out.println("Is '4K Monitor' available? " + productCatalog.contains("4K Monitor"));

        // استخدام دوال مساعدة شائعة من كلاس Collections
        Collections.sort(productCatalog);
        System.out.println("Sorted Catalog: " + productCatalog);

        productCatalog.set(0, "Gaming Monitor 144Hz"); // تعديل عنصر موجود
        productCatalog.remove("Wireless Mouse"); // حذف عنصر بالاسم
        System.out.println("Updated Catalog: " + productCatalog + "\n");


        // 2. LinkedList: الأنسب لسجل التصفح وسلة التنقل (إضافة وحذف سريع من الأطراف)
        LinkedList<String> browsingHistory = new LinkedList<>();
        browsingHistory.add("Home Page");
        browsingHistory.add("Electronics Category");
        browsingHistory.addFirst("Login Screen"); // إضافة في بداية السلسلة O(1)
        browsingHistory.addLast("Laptop Dell XPS"); // إضافة في نهاية السلسلة O(1)
        browsingHistory.addLast("Checkout Page");

        System.out.println("--- 2. User Browsing History (LinkedList) ---");
        System.out.println("Full History: " + browsingHistory);
        System.out.println("First Visited Page: " + browsingHistory.getFirst());
        System.out.println("Last Visited Page: " + browsingHistory.getLast());

        // التراجع خطوة للخلف (حذف آخر صفحة تمت زيارتها)
        String removedPage = browsingHistory.removeLast();
        System.out.println("User clicked Back (Removed): " + removedPage);
        System.out.println("Current History: " + browsingHistory + "\n");


        // 3. Vector: الأنسب لسجل عمليات الدفع (Thread-Safe ومزامن تلقائياً للعمليات المتزامنة)
        Vector<String> transactionLog = new Vector<>(3, 2); // سعة أولية 3 وتزداد بمقدار 2 عند الامتلاء
        transactionLog.addElement("TXN-1001: $1200.00 [PAID]");
        transactionLog.addElement("TXN-1002: $45.50 [PAID]");
        transactionLog.addElement("TXN-1003: $310.00 [PENDING]");

        System.out.println("--- 3. Payment Transaction Log (Vector - Synchronized) ---");
        System.out.println("Capacity before overflow: " + transactionLog.capacity());
        
        // إضافة عنصر رابع يتجاوز السعة الأولية لاختبار التمدد الديناميكي
        transactionLog.addElement("TXN-1004: $89.99 [PAID]");
        System.out.println("Capacity after overflow: " + transactionLog.capacity());
        System.out.println("First Transaction: " + transactionLog.firstElement());
        System.out.println("Last Transaction: " + transactionLog.lastElement());
        
        // التحقق من حالة السجل وتنظيف الذاكرة المؤقتة
        System.out.println("Is Transaction Log empty? " + transactionLog.isEmpty());
        transactionLog.clear();
        System.out.println("Transactions count after archive/clear: " + transactionLog.size());
    }
}