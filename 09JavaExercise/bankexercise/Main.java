package bankexercise;

import java.util.Scanner; // تصحيح اسم الحزمة واستدعاء Scanner بحرف كبيير

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter one option 1 or 2:");
        int choice = input.nextInt(); // تصحيح الإملاء
        
        switch (choice) {
            case 1: // تصحيح Case إلى case بحرف صغير
                Bsf bank1 = new Bsf();
                System.out.println("BSF: " + bank1.rateOfInterest());
                break;
            case 2: // تصحيح Case إلى case بحرف صغير
                Audi bank2 = new Audi();
                System.out.println("AUDI: " + bank2.rateOfInterest());
                break;
            default:
                System.out.println("You entered a wrong choice number");
        }
        
        input.close();
    }
}