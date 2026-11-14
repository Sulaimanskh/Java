package ecommerce_inner;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String customerName; // اسم العميل صاحب العربة
    private List<CartItem> items; // قائمة المنتجات داخل العربة (تستخدم الـ Member Inner Class)

    // المُنشئ لتهيئة العربة باسم العميل
    public ShoppingCart(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    // 1. Static Nested Class: كلاس داخلي ثابت لإعدادات المتجر العامة والضرائب
    public static class CartConfig {
        public static final double TAX_RATE = 0.05; // نسبة الضريبة 5%
        public static final double SHIPPING_FEE = 15.0; // رسوم الشحن الثابتة

        public static void printStorePolicy() {
            System.out.println("[Store Policy] All items are subject to a 5% VAT and a flat shipping fee of $15.");
        }
    }

    // 2. Member Inner Class: كلاس داخلي يمثل المنتج الفرد داخل عربة التسوق
    public class CartItem {
        private String productName;
        private double price;
        private int quantity;

        public CartItem(String productName, double price, int quantity) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        // حساب إجمالي سعر المنتج الواحد (السعر × الكمية)
        public double getItemTotal() {
            return price * quantity;
        }

        public void printItemDetails() {
            System.out.println("- " + productName + " | Unit Price: $" + price + " | Qty: " + quantity + " | Subtotal: $" + getItemTotal());
        }
    }

    // دالة لإضافة منتج جديد إلى العربة
    public void addItem(String productName, double price, int quantity) {
        CartItem newItem = new CartItem(productName, price, quantity);
        items.add(newItem);
        System.out.println("[Cart] Added successfully: " + productName);
    }

    // واجهة برمجية لبوابة الدفع (تُستخدم مع الـ Anonymous Class لاحقاً)
    public interface PaymentProcessor {
        void processPayment(double finalAmount);
    }

    // دالة إتمام الطلب الشاملة (Checkout)
    public void checkout(String promoCode) {
        System.out.println("\n========================================");
        System.out.println("      CHECKOUT RECEIPT FOR: " + customerName);
        System.out.println("========================================");
        
        if (items.isEmpty()) {
            System.out.println("Your cart is empty! Add products first.");
            return;
        }

        // حساب المجموع الفرعي لكل المنتجات في العربة
        double subtotal = 0;
        for (CartItem item : items) {
            item.printItemDetails();
            subtotal += item.getItemTotal();
        }
        System.out.println("----------------------------------------");
        System.out.println("Subtotal: $" + subtotal);

        // 3. Method-local Inner Class: كلاس داخلي مُعرف داخل دالة للتحقق من كود الخصم مؤقتاً
        class DiscountValidator {
            double applyDiscount(double currentTotal) {
                if (promoCode.equalsIgnoreCase("SAVE20")) {
                    System.out.println("[Promo] Coupon 'SAVE20' applied! 20% off.");
                    return currentTotal * 0.80; // خصم 20%
                } else if (promoCode.equalsIgnoreCase("VIP10")) {
                    System.out.println("[Promo] Coupon 'VIP10' applied! 10% off.");
                    return currentTotal * 0.90; // خصم 10%
                } else {
                    System.out.println("[Promo] Invalid or empty promo code. No discount applied.");
                    return currentTotal;
                }
            }
        }

        // استخدام كلاس التحقق من الخصم
        DiscountValidator validator = new DiscountValidator();
        double discountedTotal = validator.applyDiscount(subtotal);

        // حساب الضريبة ورسوم الشحن الثابتة المأخوذة من الـ Static Nested Class
        double tax = discountedTotal * CartConfig.TAX_RATE;
        double finalAmount = discountedTotal + tax + CartConfig.SHIPPING_FEE;

        System.out.println("VAT (5%): $" + tax);
        System.out.println("Shipping Fee: $" + CartConfig.SHIPPING_FEE);
        System.out.println("----------------------------------------");
        System.out.println("FINAL TOTAL TO PAY: $" + finalAmount);
        System.out.println("========================================");

        // 4. Anonymous Inner Class: كلاس مجهول الاسم ينفذ واجهة الدفع لحظياً عند إتمام الطلب
        PaymentProcessor creditCardPayment = new PaymentProcessor() {
            @Override
            public void processPayment(double amount) {
                System.out.println("[Payment Gateway] Processing secure credit card transaction for $" + amount + "...");
                System.out.println("[Payment Gateway] Transaction Approved! Thank you for shopping with us.");
            }
        };
        
        // استدعاء عملية الدفع الفوري
        creditCardPayment.processPayment(finalAmount);
    }
}