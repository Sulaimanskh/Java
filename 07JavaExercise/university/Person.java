package university;

public abstract class Person {
    // استخدام protected للسماح للكلاسات الابنة بالوصول للخصائص مباشرة
    protected String name;
    protected String gender;
    protected int year, month, day;
    protected String satuescom;


    public Person() {}

    // المُنشئ الأساسي لتهيئة البيانات الشخصية المشتركة
    public Person(String name, String gender, int year, int month, int day,String satuescom) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.month = month;
        this.day = day;
        this.satuescom=satuescom;
    }

    // دالة لطباعة البيانات الشخصية
    public abstract void printInfo(); 
}