package Methods;

import BeanClasses.Student;
import DAO.SDImplementation;
import DAO.SystemDAO;
import Exceptions.StudentException;

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
    }
}
