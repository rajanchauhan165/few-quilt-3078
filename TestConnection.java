import BeanClasses.Courses;
import DAO.SDImplementation;
import DAO.SystemDAO;
import DatabaseUtility.DatabaseConnection;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
//        Connection c = DatabaseConnection.provideConnection();
//        System.out.println(c);

        SystemDAO s = new SDImplementation();
//        String res= s.addCourse(1200,"Python",3000);
//        System.out.println(res);

//        String res2 = s.updateCourseFees(1000,6000);
//        System.out.println(res2);


//        String res3 = s.deleteCourse(1200);
//        System.out.println(res3);

        Courses c = s.getCourseInformation(1000);
        System.out.println(c);
    }
}
