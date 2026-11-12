package ecoummerce;

public class Product {
    private String name;
    private double price;
    private int quantity;

    // المُنشئ (Constructor) لاستقبال بيانات المنتج
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // دالة لحساب السعر الإجمالي للمنتج الواحد (السعر × الكمية)
    public double compute() {
        return price * quantity;
    }

    // دالة لطباعة معلومات المنتج
    public void printInfo() {
        System.out.println("Product Name: " + name + " | Price: " + price + " | Quantity: " + quantity + " | Total = " + compute());
    }
}