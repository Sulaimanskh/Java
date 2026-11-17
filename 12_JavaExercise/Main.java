import java.io.*;

public class Main {
    public static void main(String[] args) {
        int c;

        // 1. مرحلة القراءة السريعة باستخدام BufferedInputStream
        try (InputStream inp = new FileInputStream("E:\\myfile.txt");
             InputStream input = new BufferedInputStream(inp)) {

            System.out.println("--- 1. File Content Before Writing ---");
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Can not open or read the file: " + e.getMessage());
        }

        // 2. مرحلة الكتابة السريعة مع الإضافة (Append Mode)
        int x = 97; // رمز ASCII للحرف 'a'
        try (OutputStream out = new FileOutputStream("E:\\myfile.txt", true);
             OutputStream ou = new BufferedOutputStream(out)) {

            while (x <= 100) { // إضافة الحروف a, b, c, d لنهاية الملف
                ou.write(x);
                x++;
            }
            ou.flush();
            System.out.println("--- 2. Appended 'abcd' successfully ---");

        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }

        // 3. مرحلة الكتابة من مصفوفة بايتات (Overwrite) والقراءة باستخدام available()
        byte[] bWrite = {65, 77, 120, 90}; // تمثل الحروف: A, M, x, Z

        try (OutputStream os = new FileOutputStream("E:\\myfile.txt, true")) {
            // استخدام i كعدّاد لتجنب التعارض مع المتغير x المعرف أعلاه
            for (int i = 0; i < bWrite.length; i++) {
                os.write(bWrite[i]);
            }
            System.out.println("--- 3. Overwrote file with byte array (A M x Z) ---");
        } catch (IOException e) {
            System.out.println("Error writing byte array: " + e.getMessage());
        }

        try (InputStream is = new FileInputStream("E:\\myfile.txt")) {
            int size = is.available(); // معرفة عدد البايتات المتاحة للقراءة في الملف
            System.out.print("Final File Content (" + size + " bytes): ");

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading final file: " + e.getMessage());
        }
    }
}