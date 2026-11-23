package ecomm_generics;

import java.util.ArrayList;
import java.util.List;

// كلاس عام مقيد بأنواع ترث من Product فقط لضمان سلامة النوع
public class ShoppingCart<T extends Product> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println("تمت إضافة: " + item.getName());
    }

    public List<T> getItems() {
        return items;
    }
}