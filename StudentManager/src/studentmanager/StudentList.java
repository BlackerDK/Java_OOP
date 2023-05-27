/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DuyKhanh
 */
public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    public Student search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equals(code)) {
                return this.get(i);
            }
        }

        return null;
    }

    private boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addStudent() {
        String newCode, newName;
        int newMark;
        boolean codeDupplicated = false;
        do {
            newCode = Inputter.inputPattern("St.code s000:", "[sS]\\d{3}");
            newCode = newCode.trim().toUpperCase();
            codeDupplicated = isCodeDupplicated(newCode);
            if (codeDupplicated) {
                System.out.println("Code is duplicated !");
            }
        } while (codeDupplicated == true);
        newName = Inputter.inputNonBlankStr("Name of new student :");
        newName = newName.toUpperCase();
        newMark = Inputter.inputInt("Mark:", 0, 10);
        Student st = new Student(newCode, newName, newMark);
        this.add(st);
        System.out.println("Student " + newCode + "has been added .");
    }

    public void searchStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list . No search can be performed !");
        } else {
            String sCode = Inputter.inputStr("Input student code for search :");
            Student st = this.search(sCode);
            if (st == null) {
                System.out.println("Student " + sCode + "Doesn't existed !");
            } else {
                System.out.println("Found" + st);
            }
        }
    }
public void sreachName(){
String names;
Scanner sc= new Scanner(System.in);
System.out.println("Enter the name: ");
names=sc.nextLine().trim().toUpperCase();
    for(int i = 0; i < this.size(); i++) {
if(this.get(i).getName().toUpperCase().contains(names))
        System.out.println(get(i).toString());
    }
} 


    public void updateStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed !");
        } else {
            String uCode = Inputter.inputStr("Input code of update student");
            Student st = this.search(uCode);
            if (st == null) {
                System.out.println("Student " + uCode + "Doesn't existed !");
            } else {
                String oldName = st.getName();
                String msg = "Old Name:" + oldName + ", new Name:";
                String newName = Inputter.inputNonBlankStr(msg);
                st.setName(newName);
                int oldMark = st.getMark();
                msg = "Old Mark" + oldMark + ", New Mark: 0 -> 10";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Student " + uCode + " has been update .");
            }
        }
    }

    public void removeStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed !");
        } else {
            String rCode = Inputter.inputStr("Input code of removed student: ");
            Student st = this.search(rCode);
            if (st == null) {
                System.out.println("Student " + rCode + " Doesn't existed!");
            } else {
                this.remove(st);
                System.out.println("Student " + rCode + " has been removed.");
            }
        }
    }

    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("Empty list !");
        } else {
            System.out.println("Student list:");
            for (Student st : this) {
                System.out.println(st);
            }
            System.out.println("Total: " + this.size() + "Student(s).");
        }
    }
}
