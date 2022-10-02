package Methods;

import BeanClasses.Courses;
import BeanClasses.Student;
import DAO.SDImplementation;
import DAO.SystemDAO;
import Exceptions.StudentException;

import java.util.List;
import java.util.Scanner;


public class Demo {
    public static void studentLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username/email:");
        String username = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();

        SystemDAO dao = new SDImplementation();
        try {
            Student s = dao.studentLogin(username,password);
            System.out.println("Welcome "+s.getName());
            System.out.println("Your details are as follows:");
            System.out.println("***************");
            System.out.println("Name: "+s.getName());
            System.out.println("Roll Number: "+s.getRoll());
            System.out.println("Email ID: "+s.getEmail());
            System.out.println("Password: "+s.getPassword());
            System.out.println("***************");
            System.out.println("Type 'Q' to exit to main menu.");
        } catch (StudentException e) {
            System.out.println(e.getMessage());
            Demo.studentLogin();
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void studentCourseInfo(){
        SystemDAO sd = new SDImplementation();
        try {
            List<Courses> list =sd.getCourseInfoStudent();
            list.forEach(s->{
                System.out.println("----------");
                System.out.println("Course id: "+s.getId());
                System.out.println("Course name: "+s.getName());
                System.out.println("Course fees: "+s.getFees());
                System.out.println("Course seats: "+s.getSeats());
                System.out.println("----------");
            });
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void updateEmailPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("To update email password, Login first.");
        System.out.println("Enter current email:");
        String e = sc.next();
        System.out.println("Enter current password:");
        String p = sc.next();
        SystemDAO sd = new SDImplementation();
        try {
            String s =sd.studentUpdateDetails(e,p);
            System.out.println(s);
        } catch (StudentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void adminAddCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Course ID:");
        int cid = sc.nextInt();
        System.out.println("Enter Course Name:");
        String cname = sc.next();
        System.out.println("Enter Course Fees:");
        int fees = sc.nextInt();

        SystemDAO sd = new SDImplementation();
        try {
            String res=sd.addCourse(cid,cname,fees);
            System.out.println(res);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void adminUpdateCourseFees(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Course ID:");
        int cid = sc.nextInt();
        System.out.println("Enter New Course Fees:");
        int fees = sc.nextInt();

        SystemDAO sd = new SDImplementation();
        try {
            String res= sd.updateCourseFees(cid,fees);
            System.out.println(res);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void adminDeleteCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Course Id To Delete:");
        int cid = sc.nextInt();

        SystemDAO sd = new SDImplementation();
        try {
            String res= sd.deleteCourse(cid);
            System.out.println(res);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void adminCourseInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Course ID:");
        int cid = sc.nextInt();

        SystemDAO sd = new SDImplementation();
        try {
            Courses courses=sd.getCourseInformation(cid);
            System.out.println("Course Id: "+courses.getId());
            System.out.println("Course Name: "+courses.getName());
            System.out.println("Course Fees: "+courses.getFees());
            System.out.println("Course seats:"+courses.getSeats());
            System.out.println("----------------------------");
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void addBatch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new batch id:");
        int bid = sc.nextInt();
        System.out.println("Enter course for the batch id "+bid);
        String cname = sc.next();

        SystemDAO sd = new SDImplementation();
        try {
            String res = sd.adminCreateBatch(bid,cname);
            System.out.println(res);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void addStudentToBatch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new batch id:");
        int bid = sc.nextInt();
        System.out.println("Enter course");
        String cname = sc.next();
        System.out.println("Enter course id");
        int cid = sc.nextInt();
        System.out.println("Enter student roll");
        int roll = sc.nextInt();

        SystemDAO sd = new SDImplementation();
        try {
            String res = sd.adminAddStudentToBatch(bid,cname,cid,roll);
            System.out.println(res);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }

    public static void getStudentInfoFromBatch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter batch ID to see student details in it.");
        int id = sc.nextInt();

        SystemDAO sd = new SDImplementation();
        try {
            List<Student> list = sd.studentInfoFromBatch(id);
            list.forEach(s->{
                System.out.println("----------");
                System.out.println("Student Name: "+s.getName());
                System.out.println("Student Email: "+s.getEmail());
                System.out.println("Student Roll: "+s.getRoll());
                System.out.println("----------");
            });
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Enter 9 to exit to main menu.");
        int h = sc.nextInt();
        if(h==9){
            Main.start();
        }
    }
}
