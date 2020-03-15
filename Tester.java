/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIVA_1_FRIDAY;

/**
 *
 * @author Forge-15 1650
 */
public class Tester {
    public static void main(String[] args) {
        CourseRegistrationSystem z = new CourseRegistrationSystem(10,"Data Structure","WIX3003");
        Student[] a = new Student[15];
        a[0]=new Student("Ali",2);
        a[1]=new Student("Brandon",3);
        a[2]=new Student("Charles",3);
        a[3]=new Student("Ben",3);
        a[4]=new Student("Erick",1);
        a[5]=new Student("Jack",2);
        a[6]=new Student("Ram",3);
        a[7]=new Student("James",1);
        a[8]=new Student("Danish",2);
        a[9]=new Student("Tan",2);
        a[10]=new Student("Moon",3);
        a[11]=new Student("Yusof",3);
        a[12]=new Student("Zed",3);
        a[13]=new Student("Jun",2);
        a[14]=new Student("Yeoh",3);
        for(Student i:a){
            z.operator(i);
        }
        System.out.println(z.toString());;
        z.sorting();
        System.out.println(z.printComfirmedList());;
    }
}
