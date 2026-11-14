package university;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please choose option number (1 for Employee, 2 for Student):");
        int choice = input.nextInt();

        // استخدام جملة Switch للتحكم في نوع المدخلات بناءً على اختيار المستخدم
        switch (choice) {
            case 1: {
                System.out.println("Enter your name:");
                String name = input.next();

                System.out.println("Enter your gender:");
                String gender = input.next();

                System.out.println("Enter your birthdate (year month day):");
 System.out.println("Enter your year:");
                int year = input.nextInt();
 System.out.println("Enter your month:");
                int month = input.nextInt();
 System.out.println("Enter your day:");
                int day = input.nextInt();

                System.out.println("Enter your salary:");
                float salary = input.nextFloat();

                System.out.println("Enter your start work date (year month day):");
                 System.out.println("Enter your year:");
                int startYear = input.nextInt();
 System.out.println("Enter your month:");
                int startMonth = input.nextInt();
 System.out.println("Enter your day:");
                int startDay = input.nextInt();

                // إنشاء كائن موظف وإرسال البيانات للمُنشئ
                Employee emp = new Employee(name, gender, year, month, day, salary, startYear, startMonth, startDay);
                
                System.out.println("\n--- Employee Information ---");
                emp.printInfo();
                break;
            }
            case 2: {
                System.out.println("Enter your name:");
                String name = input.next();

                System.out.println("Enter your gender:");
                String gender = input.next();

                   System.out.println("Enter your birthdate (year month day):");
 System.out.println("Enter your year:");
                int year = input.nextInt();
 System.out.println("Enter your month:");
                int month = input.nextInt();
 System.out.println("Enter your day:");
                int day = input.nextInt();

                System.out.println("Enter your university:");
                String university = input.next();

                System.out.println("Enter your collage:");
                String collage = input.next();

                System.out.println("Enter your department:");
                String department = input.next();

                // إنشاء كائن طالب وإرسال البيانات للمُنشئ
                Student std = new Student(name, gender, year, month, day, university, collage, department);
                
                System.out.println("\n--- Student Information ---");
                std.printInfo();
                break;
            }
            default:
                System.out.println("Invalid choice!");
        }

        input.close(); // إغلاق السيكانر لمنع تسريب الموارد
    }
}