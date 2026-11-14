package ecommerce_inner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== E-COMMERCE SMART CART SYSTEM ===");
        
        // طباعة سياسة المتجر باستخدام الـ Static Nested Class مباشرة بدون الحاجة لإنشاء كائن عربة
        ShoppingCart.CartConfig.printStorePolicy();
        System.out.println();

        // استقبال اسم العميل
        System.out.print("Enter your name (Customer): ");
        String customerName = input.nextLine();

        // إنشاء كائن عربة التسوق الخاصة بالعميل
        ShoppingCart myCart = new ShoppingCart(customerName);

        char continueShopping;
        // حلقة تكرار ديناميكية لإتاحة الفرصة للمستخدم لإضافة عدة منتجات
        do {
            System.out.print("\nEnter product name: ");
            String productName = input.next();

            System.out.print("Enter product price ($): ");
            double price = input.nextDouble();

            System.out.print("Enter product quantity: ");
            int quantity = input.nextInt();

            // إضافة المنتج للعربة باستخدام كلاس CartItem الداخلي
            myCart.addItem(productName, price, quantity);

            System.out.print("Do you want to add another product? (y/n): ");
            continueShopping = input.next().charAt(0);

        } while (continueShopping == 'y' || continueShopping == 'Y');

        // طلب كود الخصم من المستخدم
        System.out.print("\nEnter promo code (e.g., SAVE20, VIP10, or type NONE): ");
        String promoCode = input.next();

        // تنفيذ عملية إتمام الطلب وحساب الفاتورة الشاملة وتشغيل بوابات الدفع
        myCart.checkout(promoCode);

        // اختبار إضافي للوصول المباشر للمنتجات باستخدام الـ Member Inner Class بناءً على طلب الهندسة العكسية
        System.out.println("\n--- Developer Direct Access Test ---");
        ShoppingCart.CartItem sampleItem = myCart.new CartItem("Express Warranty", 9.99, 1);
        sampleItem.printItemDetails();

        input.close(); // إغلاق السيكانر
    }
}