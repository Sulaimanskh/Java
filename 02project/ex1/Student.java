package ex1;
import java.util.Scanner;
 public class Student {
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
static double maxavg(Student st[])
 {
 double max=st[0].Avg();
 for (int i = 1; i <st.length ; i++) {
 if(max<st[i].Avg())
 max=st[i].Avg();
 }
 return max;
 }
 static Student stumax(Student st[])
 {
 double max=st[0].Avg();
 Student s=st[0];
 for (int i = 1; i <st.length ; i++) {
 if (max < st[i].Avg()) {
 max = st[i].Avg();
 s = st[i];
 }
 }
 return s;
 }
 }
 