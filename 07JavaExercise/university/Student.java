package university;

public class Student extends Person {
    private String university;
    private String collage;
    private String department;

    public Student() {};

    // المُنشئ لتهيئة بيانات الطالب وتمرير البيانات الشخصية للكلاس الأب
    public Student(String name, String gender, int year, int month, int day, String satuescom, 
                   String university, String collage, String department) {
        super(name, gender, year, month, day, satuescom);
        this.university = university;
        this.collage = collage;
        this.department = department;
    }

    @Override
    public void printInfo() {
        
        System.out.println("Name: " +  super.name + "\nGender: " +  super.gender + "\nBirth Date: " +  super.year + "/" +  super.month + "/" +  super.day+"community statues; "+ super.satuescom);
   
        System.out.println("University: " + university + "\nCollage: " + collage + "\nDepartment: " + department);
    }
}