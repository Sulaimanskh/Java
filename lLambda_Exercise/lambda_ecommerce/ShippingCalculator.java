package lambda_ecommerce;

// واجهة وظيفية مخصصة لحساب تكلفة الشحن بناءً على قيمة الطلب
@FunctionalInterface
public interface ShippingCalculator {
    double calculate(double orderAmount);
}