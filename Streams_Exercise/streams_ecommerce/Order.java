package streams_ecommerce;

import java.util.List;

// يمثل طلباً يحتوي على رقم تعريفي وقائمة من المنتجات
public class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }
}