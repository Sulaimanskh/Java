package my_collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEcommerceDemo {

    public static void main(String[] args) {
        System.out.println("=== E-COMMERCE SET COLLECTIONS ARCHITECTURE ===\n");

        // 1. HashSet: الأنسب للتحقق السريع O(1) من رموز الخصم النشطة دون الاهتمام بالترتيب
        Set<String> activePromoCodes = new HashSet<>();
        activePromoCodes.add("WELCOME10");
        activePromoCodes.add("BLACKFRIDAY");
        activePromoCodes.add("VIP50");
        activePromoCodes.add("WELCOME10"); // محاولة إضافة مكررة سيتم تجاهلها تلقائياً

        System.out.println("--- 1. Active Promo Codes (HashSet - O(1) Lookup) ---");
        System.out.println("Unique Promo Codes: " + activePromoCodes);
        System.out.println("Total Active Codes: " + activePromoCodes.size());
        System.out.println("Is 'VIP50' valid? " + activePromoCodes.contains("VIP50"));

        // عمليات المجموعات القياسية (Set Operations: Intersection & Difference)
        Set<String> userAppliedCodes = new HashSet<>(Arrays.asList("VIP50", "EXPIRED20"));
        
        // التقاطع (retainAll): معرفة الكوبونات الصالحة التي أدخلها المستخدم
        Set<String> validUserCodes = new HashSet<>(userAppliedCodes);
        validUserCodes.retainAll(activePromoCodes);
        System.out.println("Valid Codes Applied by User (Intersection): " + validUserCodes);

        // الفرق (removeAll): معرفة الكوبونات غير الصالحة أو المنتهية
        Set<String> invalidUserCodes = new HashSet<>(userAppliedCodes);
        invalidUserCodes.removeAll(activePromoCodes);
        System.out.println("Invalid Codes Applied by User (Difference): " + invalidUserCodes + "\n");


        // 2. LinkedHashSet: الأنسب لقائمة "شوهد مؤخراً" (منع التكرار مع الحفاظ على ترتيب الزيارة)
        Set<String> recentlyViewed = new LinkedHashSet<>();
        recentlyViewed.add("MacBook Pro M3");
        recentlyViewed.add("Sony WH-1000XM5");
        recentlyViewed.add("iPad Air");
        recentlyViewed.add("MacBook Pro M3"); // لن يتكرر وسيبقى في موقعه الأصلي

        System.out.println("--- 2. Recently Viewed Items (LinkedHashSet - Insertion Order) ---");
        System.out.println("Viewed Sequence: " + recentlyViewed);

        recentlyViewed.remove("Sony WH-1000XM5");
        recentlyViewed.add("Logitech MX Master 3S"); // يُضاف في نهاية السلسلة
        System.out.println("Updated Sequence: " + recentlyViewed + "\n");


        // 3. TreeSet: الأنسب لجدول الأسعار أو التقييمات الفريدة المرتبة تصاعدياً مع البحث النطاقي
        TreeSet<Double> productPriceTiers = new TreeSet<>();
        productPriceTiers.add(299.99);
        productPriceTiers.add(49.50);
        productPriceTiers.add(1299.00);
        productPriceTiers.add(150.00);
        productPriceTiers.add(750.00);
        productPriceTiers.add(150.00); // قيمة مكررة تُحذف تلقائياً

        System.out.println("--- 3. Store Price Tiers (TreeSet - Auto-Sorted & Navigable) ---");
        System.out.println("Sorted Price Tiers: " + productPriceTiers);
        System.out.println("Lowest Price (first): $" + productPriceTiers.first());
        System.out.println("Highest Price (last): $" + productPriceTiers.last());

        // دوال التنقل والبحث النطاقي (NavigableSet Methods)
        System.out.println("Prices strictly under $300 (headSet): " + productPriceTiers.headSet(300.00));
        System.out.println("Prices $300 and above (tailSet): " + productPriceTiers.tailSet(300.00));
        System.out.println("Next price tier above $200 (higher): $" + productPriceTiers.higher(200.00));
        System.out.println("Closest price tier below $200 (lower): $" + productPriceTiers.lower(200.00));

        // سحب وحذف أقل وأعلى سعر من المجموعة
        Double removedLowest = productPriceTiers.pollFirst();
        System.out.println("Removed Lowest Tier (pollFirst): $" + removedLowest);
        System.out.println("Remaining Price Tiers: " + productPriceTiers);
    }
}