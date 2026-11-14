package university;

public class Person {
    // استخدام protected للسماح للكلاسات الابنة بالوصول للخصائص مباشرة
    protected String name;
    protected String gender;
    protected int year, month, day;

    public Person() {}

    // المُنشئ الأساسي لتهيئة البيانات الشخصية المشتركة
    public Person(String name, String gender, int year, int month, int day) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // دالة لطباعة البيانات الشخصية
    public void printInfo() {
        System.out.println("Name: " + name + "\nGender: " + gender + "\nBirth Date: " + year + "/" + month + "/" + day);
    }
}