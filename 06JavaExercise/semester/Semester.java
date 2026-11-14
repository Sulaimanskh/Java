package semester;

import java.util.List;
import java.util.ArrayList;

public class Semester {
    private int semnum; // رقم الفصل الدراسي
    private List<Subject> subjects = new ArrayList<>(); // قائمة ديناميكية لتخزين المواد التابعة للفصل

    public Semester() {}

    // مُنشئ لاستقبال رقم الفصل وقائمة المواد
    public Semester(int semnum, List<Subject> subjects) {
        this.semnum = semnum;
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    // دالة لطباعة بيانات الفصل والمواد وحساب المعدل العام
    public void printInfo() {
        System.out.println("The semester number: " + semnum);
        System.out.println("Subjects:");
        
        float total = 0;
        // حلقة تكرار للمرور على جميع المواد وطباعة معلوماتها وتجميع الدرجات
        for (Subject subs : subjects) {
            subs.printInfo();
            total += subs.getMark();
        }
        
        // التحقق من أن القائمة ليست فارغة لتجنب خطأ القسمة على صفر
        if (!subjects.isEmpty()) {
            float average = total / subjects.size(); // حساب المعدل
            System.out.println("Average Mark: " + average);
        }
    }
}