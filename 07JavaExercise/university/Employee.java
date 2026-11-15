package university;

public class Employee extends Person {
    private float salary;
    private int startYear, startMonth, startDay; // تاريخ بدء العمل
    private String workplace;
    public Employee() {}

    // المُنشئ الذي يستدعي بيانات الأب عبر super ويضيف بيانات الموظف
    public Employee(String name, String gender, int birthYear, int birthMonth, int birthDay, String satuescom, float salary, int startYear, int startMonth, int startDay, String workplace) {
        super(name, gender, birthYear, birthMonth, birthDay, satuescom);
        this.salary = salary;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
this.workplace=workplace;
    }

    @Override
    public void printInfo() {
      
        System.out.println("Name: " +  super.name + "\nGender: " +  super.gender + "\nBirth Date: " +  super.year + "/" +  super.month + "/" +  super.day+"community statues; "+ super.satuescom);
    
        System.out.println("Salary: " + salary + "\nStart Work Date: " + startYear + "/" + startMonth + "/" + startDay+"the work place is ; "+workplace);
    }
}