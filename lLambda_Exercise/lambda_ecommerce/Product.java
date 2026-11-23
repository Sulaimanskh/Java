package lambda_ecommerce;

// يمثل منتجاً في المتجر مع حالة التوفر والسعر وتنسيق طباعة واضح
public class Product {
    private String name;
    private double price;
    private boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return name + " | السعر: $" + price + " | متوفر: " + (inStock ? "نعم" : "لا");
    }
}