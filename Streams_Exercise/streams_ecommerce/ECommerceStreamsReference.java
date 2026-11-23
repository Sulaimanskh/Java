package streams_ecommerce;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ECommerceStreamsReference {

    public static void main(String[] args) {
        // تجهيز بيانات المنتجات المتوفرة والمنتهية في المتجر
        Product p1 = new Product("لابتوب برو", "إلكترونيات", 1500.0, true);
        Product p2 = new Product("هاتف ذكي", "إلكترونيات", 800.0, true);
        Product p3 = new Product("سماعة رأس", "إلكترونيات", 150.0, false);
        Product p4 = new Product("رواية الخيميائي", "كتب", 25.0, true);
        Product p5 = new Product("كتاب تعلم جافا", "كتب", 50.0, true);
        Product p6 = new Product("قميص قطني", "ملابس", 35.0, false);

        List<Product> catalog = Arrays.asList(p1, p2, p3, p4, p5, p6);

        // تجهيز قائمة الطلبات لاختبار تسطيح القوائم والمنتجات المكررة
        List<Order> orders = Arrays.asList(
            new Order("ORD-01", Arrays.asList(p1, p4)),
            new Order("ORD-02", Arrays.asList(p2, p5, p1))
        );

        System.out.println("=== 1. filter + sorted + limit + map + toList ===");
        // استخراج أسماء أرخص منتجين متوفرين في المخزون
        List<String> cheapestAvailable = catalog.stream()
                .filter(Product::isInStock)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .limit(2)
                .map(Product::getName)
                .toList();
        System.out.println("أرخص منتجين متوفرين: " + cheapestAvailable);

        System.out.println("\n=== 2. flatMap + distinct ===");
        // دمج منتجات جميع الطلبات في Stream واحد ثم إزالة التكرار
        List<Product> uniqueSoldProducts = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();
        System.out.println("المنتجات المباعة بدون تكرار: " + uniqueSoldProducts);

        System.out.println("\n=== 3. Collectors.groupingBy ===");
        // تجميع المنتجات حسب اسم الفئة
        Map<String, List<Product>> productsByCategory = catalog.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        productsByCategory.forEach((category, list) ->
            System.out.println("قسم [" + category + "] يحتوي على: " + list)
        );

        System.out.println("\n=== 4. Collectors.partitioningBy ===");
        // تقسيم المنتجات إلى مجموعتين بناءً على شرط منطقي (متوفر أو غير متوفر)
        Map<Boolean, List<Product>> stockPartition = catalog.stream()
                .collect(Collectors.partitioningBy(Product::isInStock));

        System.out.println("المنتجات المتوفرة: " + stockPartition.get(true).size());
        System.out.println("المنتجات المنتهية: " + stockPartition.get(false).size());

        System.out.println("\n=== 5. reduce ===");
        // جمع أسعار المنتجات المتوفرة في قيمة واحدة
        double totalStockValue = catalog.stream()
                .filter(Product::isInStock)
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
        System.out.println("إجمالي قيمة المخزون المتوفر: $" + totalStockValue);

        System.out.println("\n=== 6. Optional + findFirst ===");
        // البحث عن أول منتج يتجاوز سعره 2000$ وتوفير قيمة بديلة عند عدم العثور عليه
        Optional<Product> ultraExpensive = catalog.stream()
                .filter(p -> p.getPrice() > 2000.0)
                .findFirst();

        Product foundOrDefault = ultraExpensive.orElse(
                new Product("لا يوجد منتج بهذا السعر", "عام", 0.0, false)
        );
        System.out.println("نتيجة البحث: " + foundOrDefault.getName());

        System.out.println("\n=== 7. anyMatch / count ===");
        // فحص وجود كتب أقل من 30$ وحساب عدد منتجات الإلكترونيات
        boolean hasCheapBooks = catalog.stream()
                .anyMatch(p -> p.getCategory().equals("كتب") && p.getPrice() < 30.0);
        long electronicsCount = catalog.stream()
                .filter(p -> p.getCategory().equals("إلكترونيات"))
                .count();

        System.out.println("هل يوجد كتب رخيصة أقل من 30$؟ " + hasCheapBooks);
        System.out.println("عدد منتجات الإلكترونيات: " + electronicsCount);

        System.out.println("\n=== 8. parallelStream ===");
        // حساب مجموع الأسعار باستخدام المعالجة المتوازية
        double parallelTotal = catalog.parallelStream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("المجموع بالمعالجة المتوازية: $" + parallelTotal);
    }
}