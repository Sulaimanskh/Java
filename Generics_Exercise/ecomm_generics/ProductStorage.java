package ecomm_generics;

import java.util.HashMap;
import java.util.Map;

// تطبيق فعلي للواجهة Repository بحيث يكون المعرف Integer والعنصر Product
public class ProductStorage implements Repository<Integer, Product> {
    private Map<Integer, Product> database = new HashMap<>();

    @Override
    public void save(Integer id, Product item) {
        database.put(id, item);
        System.out.println("تم حفظ المنتج [" + item.getName() + "] برقم: " + id);
    }

    @Override
    public Product findById(Integer id) {
        return database.get(id);
    }
}