package Exception_Exercise;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please choose an option (1, 2, or 3):");
        int choice = input.nextInt();

        // استخدام جملة Switch للتحكم في السيناريوهات المختلفة
        switch (choice) {
            case 1: {
                System.out.println("Enter first number = ");
                int firstNum = input.nextInt();
                
                System.out.println("Enter second number = ");
                int secondNum = input.nextInt();
                
                // معالجة استثناء القسمة على الصفر
                try {
                    int result = firstNum / secondNum;
                    System.out.println("The Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: Division by zero is not allowed!");
                } finally {
                    System.out.println("Execution of division operation completed.");
                }
                break;
            }
            case 2: {
                System.out.println("Enter path of file:");
                String path = input.next();
                
                // معالجة استثناء عدم وجود الملف
                try {
                    File file = new File(path);
                    Scanner fileSc = new Scanner(file);
                    
                    while (fileSc.hasNextLine()) {
                        System.out.println(fileSc.nextLine());
                    }
                    fileSc.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error: The specified file was not found!");
                }
                break;
            }
            case 3: {
                System.out.println("How tall are you (cm) = ");
                int tall = input.nextInt();
                
                // معالجة الاستثناء المخصص (Custom Exception)
                try {
                    validateHeight(tall);
                } catch (TallException e) {
                    System.out.println("Caught Custom Exception -> " + e);
                }
                break;
            }
            default:
                System.out.println("Invalid choice number entered!");
                break;
        }

        input.close(); // إغلاق الموارد لمنع التسريب
    }

    // دالة مستقلة للتحقق من الطول ورمي الاستثناء عند تجاوز الحدود المسموحة
    public static void validateHeight(int t) throws TallException {
        if (t > 300 || t <= 110) {
            throw new TallException(t);
        } else {
            int idealWeight = t - 110;
            System.out.println("Estimated ideal weight mapping = " + idealWeight);
        }
    }
}