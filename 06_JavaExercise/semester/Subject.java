package semester;

public class Subject // أو Subject
{
    private String subname; // اسم المادة الدراسية
    private int subnumb;    // عدد ساعات المادة
    private float mark;     // درجة المادة

    // المُنشئ الافتراضي
    public Subject() {}

    // مُنشئ لاستقبال بيانات المادة وإسنادها
    public Subject(String subname, int subnumb, float mark) {
        this.subname = subname;
        this.subnumb = subnumb;
        this.mark = mark;
    }

    // دوال الاسترجاع (Getters) للحصول على القيم
    public String getSubname() {
        return subname;
    }

    public int getSubnumb() {
        return subnumb;
    }

    public float getMark() {
        return mark;
    }

    // دالة لطباعة تفاصيل المادة الحالية
    public void printInfo() {
        System.out.println("Subject Name: " + subname + " | Subject Hours: " + subnumb + " | Subject Mark: " + mark);
    }
}