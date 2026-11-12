package ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // كائن لقراءة البيانات المدخلة من لوحة المفاتيح
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter how many books: ");
        int n = input.nextInt(); // استقبال عدد الكتب لتحديد كم دورة ستعمل اللوب
        
        // إنشاء ArrayList ديناميكية لتخزين كائنات من نوع Book (يمكنها زيادة أو نقص الحجم تلقائياً)
        List<Book> books = new ArrayList<>();
        
        // حلقة تكرار عادية لتكرار عملية إدخال بيانات الكتب بناءً على العدد (n)
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the data for book " + (i + 1));
            System.out.print("Enter title: ");
            String title = input.next();
            System.out.print("Enter author: ");
            String author = input.next();
            
            // إنشاء كائن كتاب جديد وإرسال العنوان والمؤلف للـ Constructor
            Book bk = new Book(title, author);
            
            // إضافة الكائن الحالي إلى داخل الـ ArrayList باستخدام الدالة add
            books.add(bk);
        }
        
        // إنشاء كائن من كلاس Library وتمرير قائمة الكتب إليه
        Library lib = new Library(books);
        
        System.out.println("The list of books:");
        // استرجاع قائمة الكتب المحفوظة باستخدام دالة getTotal
        List<Book> retrievedBooks = lib.getTotal();
        
        // حلقة تكرار محسنة (For-Each) للمرور على كل كتاب داخل القائمة وطباعة تفاصيله
        for (Book bk : retrievedBooks) {
            System.out.println("The author: " + bk.author + ", Title: " + bk.title);
        }
        
        input.close(); // إغلاق كائن الـ Scanner
    }
}