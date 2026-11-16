package bankexercise;

public class Audi implements Bank {
    @Override
    public float rateOfInterest() {
        return 2.25f; // تحديد القيمة كـ float بإضافة حرف f
    }
}