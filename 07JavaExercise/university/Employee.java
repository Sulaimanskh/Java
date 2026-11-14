package university;

public class Employee extends Person {
    private float salary;
    private int startYear, startMonth, startDay; // تاريخ بدء العمل

    public Employee() {}

    // المُنشئ الذي يستدعي بيانات الأب عبر super ويضيف بيانات الموظف
    public Employee(String name, String gender, int birthYear, int birthMonth, int birthDay, 
                    float salary, int startYear, int startMonth, int startDay) {
        super(name, gender, birthYear, birthMonth, birthDay);
        this.salary = salary;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
    }

    @Override
    public void printInfo() {
        super.printInfo(); // طباعة البيانات الشخصية أولاً
        System.out.println("Salary: " + salary + "\nStart Work Date: " + startYear + "/" + startMonth + "/" + startDay);
    }
}