package my_collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapEcommerceDemo {

    public static void main(String[] args) {
        System.out.println("=== E-COMMERCE MAP COLLECTIONS ARCHITECTURE ===\n");

        // 1. HashMap: الأنسب لفهرسة المخزون والوصول السريع O(1) عبر رمز المنتج (SKU)
        Map<String, Integer> productStock = new HashMap<>();
        productStock.put("SKU-101", 25); // Laptop
        productStock.put("SKU-102", 80); // Wireless Mouse
        productStock.put("SKU-103", 12); // 4K Monitor

        System.out.println("--- 1. Real-Time Inventory Lookup (HashMap - O(1)) ---");
        
        // putIfAbsent: إضافة منتج جديد فقط إذا لم يكن مسجلاً مسبقاً لتجنب مسح الرصيد الحالي
        productStock.putIfAbsent("SKU-101", 100); // سيتم تجاهله لأن SKU-101 موجود
        productStock.putIfAbsent("SKU-104", 45);  // سيتم إضافته بنجاح

        // getOrDefault: قراءة آمنة تمنع NullPointerException إذا كان المنتج غير موجود
        int webcamStock = productStock.getOrDefault("SKU-999", 0);
        System.out.println("Stock for unregistered SKU-999: " + webcamStock);

        // computeIfPresent: تحديث ذكي للمخزون عند إتمام عملية بيع (خصم 3 وحدات)
        productStock.computeIfPresent("SKU-101", (sku, currentQty) -> currentQty - 3);
        System.out.println("Updated SKU-101 stock after sale: " + productStock.get("SKU-101"));

        // التحقق من وجود مفتاح أو قيمة معينة
        System.out.println("Contains SKU-103? " + productStock.containsKey("SKU-103"));
        System.out.println("Any product with exact 80 units? " + productStock.containsValue(80));

        // المرور الاحترافي على عناصر الخريطة باستخدام entrySet()
        System.out.println("Current Warehouse Stock:");
        for (Map.Entry<String, Integer> entry : productStock.entrySet()) {
            System.out.println("  -> " + entry.getKey() + " : " + entry.getValue() + " units");
        }
        System.out.println();


        // 2. LinkedHashMap: الأنسب لتتبع مراحل الطلب بالتسلسل الزمني الدقيق (Insertion Order)
        Map<String, String> orderTrackingSteps = new LinkedHashMap<>();
        orderTrackingSteps.put("STEP-1", "Order Placed by Customer [10:00 AM]");
        orderTrackingSteps.put("STEP-2", "Payment Verified via Gateway [10:02 AM]");
        orderTrackingSteps.put("STEP-3", "Packed in Warehouse [11:30 AM]");
        orderTrackingSteps.put("STEP-4", "Handed to Courier [02:15 PM]");

        System.out.println("--- 2. Order Tracking Timeline (LinkedHashMap - Insertion Order) ---");
        // replace: تحديث وصف مرحلة موجودة دون تغيير موقعها في التسلسل الزمني
        orderTrackingSteps.replace("STEP-3", "Packed & Quality Checked in Warehouse [11:45 AM]");

        orderTrackingSteps.forEach((step, status) -> 
            System.out.println("  " + step + " => " + status)
        );
        System.out.println();


        // 3. TreeMap: الأنسب لتقارير الإيرادات اليومية المرتبة زمنياً حسب التاريخ (Sorted Keys)
        TreeMap<String, Double> dailyRevenueLedger = new TreeMap<>();
        dailyRevenueLedger.put("2026-11-21", 4350.75);
        dailyRevenueLedger.put("2026-11-18", 2100.00);
        dailyRevenueLedger.put("2026-11-20", 3890.50);
        dailyRevenueLedger.put("2026-11-19", 1750.25);

        System.out.println("--- 3. Daily Revenue Ledger (TreeMap - Auto-Sorted Keys) ---");
        System.out.println("Chronological Revenue Report: " + dailyRevenueLedger);
        System.out.println("First Recorded Day (firstKey): " + dailyRevenueLedger.firstKey());
        System.out.println("Latest Recorded Day (lastKey): " + dailyRevenueLedger.lastKey());

        // استخراج تقرير مالي لنطاق زمني محدد (Range Queries)
        Map<String, Double> midWeekReport = dailyRevenueLedger.subMap("2026-11-19", true, "2026-11-21", true);
        System.out.println("Revenue between Nov 19 and Nov 21 (subMap): " + midWeekReport);

        // حذف سجل يوم محدد والتأكد من حجم السجل
        dailyRevenueLedger.remove("2026-11-18");
        System.out.println("Total Days in Ledger after cleanup: " + dailyRevenueLedger.size());
    }
}