/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIVA_1_FRIDAY;

import java.util.ArrayList;

/**
 *
 * @author Forge-15 1650
 */
public class CourseRegistrationSystem {

    private MyArrayList<Student> confirmedList = new MyArrayList<>();
    private MyArrayList<Student> waitingList = new MyArrayList<>();
    private int max;
    private String course;
    private String code;

    public CourseRegistrationSystem(int max, String course, String code) {
        this.max = max;
        this.course = course;
        this.code = code;
        System.out.println("Course: " + course);
        System.out.println("Course Code: " + code);
        System.out.println("");
    }
    
    

    public void operator(Student obj) {
        if (confirmedList.size() < max) {
            confirmedList.add(obj);

        } else if (max == confirmedList.size() && obj.getYear() >= ((int) code.charAt(3) - '0')) {
            boolean ix = true;
            for (int i = confirmedList.size() - 1; i >= 0; i--) {
//                System.out.println(obj);
                if (obj.getYear() > confirmedList.get(i).getYear()) {
                    Student kick = confirmedList.get(i);
                    confirmedList.removeAt(i);
                    confirmedList.add(obj);
                    boolean jx = true;
                    for (int j = 0; j < waitingList.size(); j++) {
                        if (obj.getYear() >= waitingList.get(j).getYear()) {
                            waitingList.add(kick, j);
                            jx = false;
                            break;
                        }
                    }
                    if (jx) {
                        waitingList.add(kick, 0);
                    }
                    ix = false;
                    break;
                }

            }
            if (ix) {
                waitingList.add(obj);
            }

//            for (int i = confirmedList.size()-1; i >= 0; i--) {
//                if (obj.getYear() > confirmedList.get(i).getYear()) {
//                    Student kick = confirmedList.get(i);
//                    confirmedList.removeAt(i);
//                    waitingList.add(kick, 0);
//                    confirmedList.add(obj);
//                    x = true;
//                    break;
//                }
//            }
//            if (x) {
//                x = true;
//                for (int j = 0; j < waitingList.size(); j++) {
//                    if (obj.getYear() <= waitingList.get(j).getYear()) {
//                        waitingList.add(obj, j + 1);
//                        x = false;
//                        break;
//                    }
//                }
//                if (x) {
//                    waitingList.add(obj, 0);
//                }
//            }
        } else if (max == confirmedList.size() && obj.getYear() < code.charAt(3)) {
            waitingList.add(obj);
        }

    }
    
        public void sorting() {
        for (int i = 0; i < confirmedList.size(); i++) {
            for (int j = 0; j < confirmedList.size()-1; j++) {
                if (confirmedList.get(j).compareTo(confirmedList.get(j+1))>0) {
//                    System.out.println("switch");
                    Student temp = confirmedList.removeAt(j);
                    confirmedList.add(temp,j+1);
//                    System.out.println(printComfirmedList());
                }
            }
        }
    }
    public String printComfirmedList(){
        String a = "";
        for (int i = 0; i < confirmedList.size(); i++) {
            a += "Student : " + String.format("%-10s",confirmedList.get(i).getName());
            a += "Year of Study : " + String.format("%-2d ,\n",confirmedList.get(i).getYear());
        }
        return a;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < waitingList.size(); i++) {
            a.append(waitingList.get(i).toString() + "\n");
        }
        for (int j = 0; j < confirmedList.size(); j++) {
            b.append(confirmedList.get(j).toString() + "\n");
        }
        return "\n\nWaiting List: \n"
                + new String(a)
                + "\n\nConfirmed List: \n"
                + new String(b);
    }

}
