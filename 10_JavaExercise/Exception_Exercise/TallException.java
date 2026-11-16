package Exception_Exercise;

public class TallException extends Exception {
    private int tall;

    // المُنشئ لاستقبال قيمة الطول وتخزينها
    public TallException(int tall) {
        this.tall = tall;
    }

    public int getTall() {
        return tall;
    }

    // تجاوز دالة toString لطباعة تفاصيل الاستثناء بوضوح
    @Override
    public String toString() {
        return "TallException: Height (" + tall + ") is out of valid biological range (110cm - 300cm).";
    }
}