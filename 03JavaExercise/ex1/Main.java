package ex1;

public class Main {
    public static void main(String[] args) {
        Car ca = new Car(); // إنشاء كائن جديد من السيارة
        ca.setColor("blue"); // تحديد اللون أزرق
        ca.carSpeed(); // ضبط السرعة
        ca.setDoors(4); // تحديد عدد الأبواب 4
        ca.setStart(); // تشغيل السيارة
        ca.carfeatures(); // طباعة التفاصيل
    }
}