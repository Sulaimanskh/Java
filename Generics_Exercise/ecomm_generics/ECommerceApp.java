package ecomm_generics;

public class ECommerceApp {
    public static void main(String[] args) {
        // سلة مخصصة لمنتجات الإلكترونيات فقط
        ShoppingCart<Electronics> techCart = new ShoppingCart<>();
        techCart.addItem(new Electronics("لابتوب", 1200.0));
        techCart.addItem(new Electronics("سماعات", 150.0));

        // سلة مخصصة للكتب فقط
        ShoppingCart<Book> bookCart = new ShoppingCart<>();
        bookCart.addItem(new Book("تعلم البرمجة", 45.0));

        System.out.println("\n--- محتويات سلة الإلكترونيات ---");
        StoreService.printList(techCart.getItems());

        System.out.println("\n--- محتويات سلة الكتب ---");
        StoreService.printList(bookCart.getItems());

        // حساب الإجمالي باستخدام Wildcard مقيد
        double techTotal = StoreService.calculateTotal(techCart.getItems());
        double bookTotal = StoreService.calculateTotal(bookCart.getItems());

        System.out.println("\nإجمالي الإلكترونيات: $" + techTotal);
        System.out.println("إجمالي الكتب: $" + bookTotal);

        // تجربة مستودع المنتجات العام (Generic Repository)
        System.out.println("\n--- مستودع المنتجات ---");
        Repository<Integer, Product> productRepo = new ProductStorage();
        productRepo.save(101, new Electronics("شاشة 4K", 400.0));
        productRepo.save(102, new Book("هندسة البرمجيات", 60.0));

        Product fetched = productRepo.findById(101);
        System.out.println("المنتج المسترجع برقم 101: " + fetched);
    }
}