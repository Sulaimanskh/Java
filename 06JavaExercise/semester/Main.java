package semester;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter semester number:");
        int semnum = input.nextInt(); // استقبال رقم الفصل الدراسي
        
        // إنشاء قائمة ديناميكية لتخزين مواد الفصل
        List<Subject> subjects = new ArrayList<>();
        String choice;
        
        // حلقة تكرار لإدخال بيانات المواد بشكل مرن حسب رغبة المستخدم
        do {
            System.out.println("Enter subject name:");
            String subname = input.next();
            
            System.out.println("Enter subject hours number:");
            int subnumb = input.nextInt();
            
            System.out.println("Enter subject mark:");
            float mark = input.nextFloat();
            
            // إنشاء كائن مادة جديدة وإضافته للقائمة
            Subject subjj = new Subject(subname, subnumb, mark);
            subjects.add(subjj);
            
            System.out.println("Do you want to add another subject? (y/Y):");
            choice = input.next();
            
        } while (choice.equalsIgnoreCase("y")); // الاستمرار طالما أدخل المستخدم y أو Y
        
        // إنشاء كائن الفصل الدراسي وتمرير رقمه وقائمة المواد إليه
        Semester semester = new Semester(semnum, subjects);
        
        System.out.println("\n--- The Semester All Data ---");
        semester.printInfo(); // استدعاء دالة الطباعة الشاملة وعرض المعدل
        
        input.close(); // إغلاق الـ Scanner
    }
}