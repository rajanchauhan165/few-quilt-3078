package Methods;

import java.util.Scanner;

public class Main {
    public static void start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("|--------------------------------------------------|");
        System.out.println("| Welcome to Automated Student Registration System |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("Press 1 if you are an Admin or press 2 if you are a Student.");
        int option1 = sc.nextInt();

        if(option1==1){
            System.out.println("Admin options:");
            System.out.println("Enter 1 to add new course.");
            System.out.println("Enter 2 to update course fees.");
            System.out.println("Enter 3 to delete a course.");
            System.out.println("Enter 4 to get course information.");
            System.out.println("Enter 5 to add new batch");
            System.out.println("Enter 6 to add student to batch");
            System.out.println("Enter 7 to view all students from any batch");
            System.out.println("Enter 9 to exit to main menu");
            int adminInput = sc.nextInt();
            if(adminInput==1){
                Demo.adminAddCourse();
            }
            else if (adminInput==2){
                Demo.adminUpdateCourseFees();
            } else if (adminInput==3) {
                Demo.adminDeleteCourse();
            } else if (adminInput==4) {
                Demo.adminCourseInfo();
            } else if (adminInput==9) {
                Main.start();
            } else if (adminInput==5) {
                Demo.addBatch();
            }
            else if (adminInput==6) {
                Demo.addStudentToBatch();
            }else if (adminInput==7) {
                Demo.getStudentInfoFromBatch();
            }
            else System.out.println("Invalid Input");
        }

        if(option1==2){
            System.out.println("Student options:");
            System.out.println("Enter 1 to login.");
            System.out.println("Enter 2 to see all courses details");
            System.out.println("Enter 3 to update email password");
            System.out.println("Enter 9 to exit to main menu");
            int studentInput = sc.nextInt();
            if(studentInput==1){
                Demo.studentLogin();
            } else if (studentInput==9) {
                Main.start();
            } else if (studentInput==2) {
                Demo.studentCourseInfo();
            } else if (studentInput==3) {
                Demo.updateEmailPassword();
            } else System.out.println("Invalid Input");
        }
    }
    public static void main(String[] args) {
        start();
    }
}
