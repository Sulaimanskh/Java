package ex1;

public class Accelerator {
    private int speed; // متغير لتخزين السرعة

    public Accelerator(int speed) {
        this.speed = speed; // مُنشئ يستقبل قيمة السرعة
    }

    public void setSpeed(int speed) {
        this.speed = speed; // تحديث السرعة
    }

    public int getSpeed() {
        return speed; // إرجاع قيمة السرعة الحالية
    }
}