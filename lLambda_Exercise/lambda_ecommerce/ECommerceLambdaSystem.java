package lambda_ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// واجهة وظيفية مخصصة لحساب تكلفة الشحن بناءً على قيمة الطلب

public class ECommerceLambdaSystem {

    public static void main(String[] args) {
        // تجهيز كتالوج المنتجات
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("شاشة ألعاب", 450.0, true));
        catalog.add(new Product("لوحة مفاتيح", 80.0, false));
        catalog.add(new Product("لابتوب برو", 1500.0, true));
        catalog.add(new Product("سماعة بلوتوث", 120.0, true));

        // 1. Supplier<T>: توليد رقم فاتورة عشوائي دون استقبال أي مدخلات
        Random random = new Random();
        Supplier<String> invoiceGenerator = () -> "INV-" + (1000 + random.nextInt(9000));
        System.out.println("رقم الفاتورة الجديدة: " + invoiceGenerator.get());
        System.out.println("--------------------------------------------------");

        // 2. Predicate<T>: فحص شروط المنتجات ودمجها عبر .and()
        Predicate<Product> isAvailable = Product::isInStock;
        Predicate<Product> isAbove100 = product -> product.getPrice() > 100.0;
        Predicate<Product> eligibleForPromo = isAvailable.and(isAbove100);

        // 3. Function<T, R>: تحويل بيانات المنتج إلى السعر النهائي شامل الضريبة
        // المتغير taxRate يُعامل كـ Effectively Final لأنه لا يتغير بعد تهيئته
        final double taxRate = 0.15;
        Function<Product, Double> priceWithTax = product -> {
            double taxAmount = product.getPrice() * taxRate;
            return product.getPrice() + taxAmount;
        };

        // 4. Consumer<T> مع Method Reference: استهلاك العنصر لطباعته مباشرة
        Consumer<Product> printProductDetails = System.out::println;

        System.out.println("المنتجات المتوفرة والمؤهلة للعرض (أكثر من 100$):");
        double subtotal = 0.0;

        for (Product p : catalog) {
            if (eligibleForPromo.test(p)) {
                printProductDetails.accept(p);

                double finalPrice = priceWithTax.apply(p);
                System.out.println("   -> السعر بعد الضريبة (15%): $" + finalPrice);
                subtotal += finalPrice;
            }
        }

        // 5. Lambda متعددة الأسطر مع واجهة وظيفية مخصصة لحساب الشحن
        ShippingCalculator shippingRule = amount -> {
            if (amount >= 1000.0) {
                return 0.0;
            } else {
                return 25.0;
            }
        };

        double shippingCost = shippingRule.calculate(subtotal);
        System.out.println("--------------------------------------------------");
        System.out.println("المجموع الفرعي: $" + subtotal);
        System.out.println("تكلفة الشحن: $" + shippingCost);
        System.out.println("الإجمالي النهائي للدفع: $" + (subtotal + shippingCost));
    }
}