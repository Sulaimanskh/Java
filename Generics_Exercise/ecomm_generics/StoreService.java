package ecomm_generics;

import java.util.List;

// كلاس خدمات يضم دالة عامة ودالة تستخدم Upper Bounded Wildcard
public class StoreService {

    // دالة عامة لطباعة عناصر أي قائمة مهما كان نوعها
    public static <E> void printList(List<E> list) {
        for (E element : list) {
            System.out.println("- " + element);
        }
    }

    // تقبل قائمة من Product أو أي نوع فرعي يرث منه لحساب الإجمالي بأمان
    public static double calculateTotal(List<? extends Product> products) {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}