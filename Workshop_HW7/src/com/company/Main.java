package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    showMainMenu();
    }
    public static void showMainMenu(){
        Scanner input =new Scanner(System.in);
        System.out.println("--- Menu ---\n1- Students List\n2- Add Student\n3- Edit Student\n4- Delete Student\n5- Class Total Average");
        switch (input.nextLine()){
            case"1":
                DBManager.getInstance().printStudents();
                showMainMenu();
                break;
            case"2":
                addStudent();
                showMainMenu();
                break;
            case"3":
                editStudent();
                showMainMenu();
                break;
            case"4":
                deleteStudent();
                showMainMenu();
                break;
            case"5":
                System.out.println("Total Average is : "+DBManager.getInstance().totalaverage());
                showMainMenu();
                break;
        }
    }
    public static void addStudent(){
        Scanner input=new Scanner(System.in);
        Student student =new Student();
        System.out.println("--- New Student ---\nID : ");
        student.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Name : ");
        student.setName(input.nextLine());
        System.out.println("Family : ");
        student.setFamily(input.nextLine());
        System.out.println("Average : ");
        student.setAverage(Float.parseFloat(input.nextLine()));
        DBManager.getInstance().insert(student);
        System.out.println("Student Added Successfully !");
    }
    public static void editStudent(){
        Scanner input=new Scanner(System.in);
        Student student =new Student();
        System.out.println("--- Edit Student ---\nID : ");
        student.setId(Integer.parseInt(input.nextLine()));
        System.out.println("Name : ");
        student.setName(input.nextLine());
        System.out.println("Family : ");
        student.setFamily(input.nextLine());
        System.out.println("Average : ");
        student.setAverage(Float.parseFloat(input.nextLine()));
        DBManager.getInstance().edit(student);
        System.out.println("Student Edited Successfully !");
    }
    public static void deleteStudent(){
        Scanner input=new Scanner(System.in);
        int id =0;
        System.out.println("--- Delete Student ---\nID : ");
        id =Integer.parseInt(input.nextLine());
        DBManager.getInstance().delete(id);
        System.out.println("Student Deleted Successfully !");
    }

}
