package ex1;

public class Car {
    private String color; // لون السيارة
    private int doors; // عدد الأبواب
    private int speed = 100; // السرعة الافتراضية

    public Car() {} // المُنشئ الافتراضي

    public void setColor(String color) {
        this.color = color; // تعيين لون السيارة
    }

    public String getColor() {
        return color; // إرجاع لون السيارة
    }

    public void setDoors(int doors) {
        this.doors = doors; // تعيين عدد الأبواب
    }

    public int getDoors() {
        return doors; // إرجاع عدد الأبواب
    }

    public void setStart() {
        Engine engine = new Engine(); // إنشاء كائن من المحرك
        engine.start(); // تشغيل المحرك
    }

    public void carSpeed() {
        Accelerator accelerator = new Accelerator(speed); // تمرير السرعة لمُسرع السيارة
        accelerator.setSpeed(speed);
    }

    void carfeatures() {
        System.out.println("the car features: " + color + " " + doors + " " + speed); // طباعة خصائص السيارة
    }
}