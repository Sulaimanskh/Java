 import java.util.Scanner;
 public class EX1 {
 public static class Student {
 String name ;
 int n;
 int marks [];
 public Student (){}
 public Student (String name , int arr[],int n)
 {
 this.name = name ;
 this.n=n;
 marks=arr;
 //System.arraycopy(arr, 0, marks, 0, n);
 }
 double Avg ()
 {
 double sum = 0.0 ;
 for (int x = 0 ; x < n ; x++)
 {
 sum = sum + marks[x] ;
 }
 return sum/n ;
 }
 void PrintInfo ()
 {
 System.out.println ("name : " + name) ;
 for (int i = 0 ; i < n ; i++)
 {
 System.out.println("Mark " + (i+1) + " = " + marks[i] );
 }
 System.out .println("Avg = " + Avg()) ;
 }
 }
 public static void main(String[] args) {
 String name ;
 int n;
 Scanner input = new Scanner(System.in) ;
 System.out.print
("Enter The name of the student: ");
 name= input.next();
 System.out.print
("Enter how many subjects he/she has: ");
 n=input.nextInt();
 int arr [] = new int[n] ;
 for (int i = 0 ; i < n ; i++)
 {
 System.out.print("Enter Mark " + (i+1) + ": " );
 arr[i] = input.nextInt() ;
 }
 Student st = new Student(name, arr,n);
 System.out.println("Student Info: " );
 st.PrintInfo(); }
}