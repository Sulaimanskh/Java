package ex1;

import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        Student st[] = new Student[3];

        for (int j = 0; j < st.length; j++) {
            int n;
            int mark[] = new int[n];
            System.out.println("Enter student " + (j + 1) + " info:");
            System.out.print("student name: ");
            name = input.next();
               System.out.println("Enter how many marks the student has: ");
            n = input.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter mark " + (i + 1) + ": ");
                mark[i] = input.nextInt();
            }
            
         
            st[j] = new Student(name, mark, n);
        }

        for (int j = 0; j < st.length; j++) {
            System.out.println("Student " + (j + 1) + " info:");
            st[j].PrintInfo();
            System.out.println("-------------------");
        }

     
        System.out.println("The max avg is: " + Student.maxavg(st));
        
        System.out.println("The max avg student info: ");
        Student.stumax(st).PrintInfo();

        input.close();
    }
}