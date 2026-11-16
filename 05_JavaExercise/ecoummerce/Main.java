package ecoummerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // إنشاء قائمة ديناميكية (ArrayList) لتخزين المنتجات
        List<Product> products = new ArrayList<>();
        
        char choice;
        // استخدام حلقة do-while لإدخال المنتجات بشكل ديناميكي حسب رغبة المستخدم
        do {
            System.out.println("Enter product name: ");
            String name = input.next();
            
            System.out.println("Enter product price: ");
            double price = input.nextDouble();
            
            System.out.println("Enter product quantity: ");
            int quantity = input.nextInt();
            
            // إنشاء كائن المنتج وإضافته مباشرة إلى القائمة الديناميكية
            Product p = new Product(name, price, quantity);
            products.add(p);
            
            System.out.print("Do you want to add another product? (y/n): ");
            choice = input.next().charAt(0);
            
        } while (choice == 'y' || choice == 'Y');
        
        System.out.println("\n--- All Products Info ---");
        double totalInvoice = 0.0; // متغير لتجميع قيمة الفاتورة الكلية
        
        // حلقة تكرار (For-Each) للمرور على جميع المنتجات وطباعة معلوماتها وحساب الإجمالي
        for (Product pr : products) {
            pr.printInfo();
            totalInvoice += pr.compute(); // إضافة إجمالي كل منتج إلى الفاتورة الكلية
        }
        
        System.out.println("---------------------------------");
        System.out.println("Total Invoice Amount = " + totalInvoice); // طباعة إجمالي الفاتورة الكلية
        
        input.close(); // إغلاق السيكانر
    }
}