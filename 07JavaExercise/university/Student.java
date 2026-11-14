package university;

public class Student extends Person {
    private String university;
    private String collage;
    private String department;

    public Student() {}

    // المُنشئ لتهيئة بيانات الطالب وتمرير البيانات الشخصية للكلاس الأب
    public Student(String name, String gender, int year, int month, int day, 
                   String university, String collage, String department) {
        super(name, gender, year, month, day);
        this.university = university;
        this.collage = collage;
        this.department = department;
    }

    @Override
    public void printInfo() {
        super.printInfo(); // طباعة البيانات الشخصية أولاً
        System.out.println("University: " + university + "\nCollage: " + collage + "\nDepartment: " + department);
    }
}