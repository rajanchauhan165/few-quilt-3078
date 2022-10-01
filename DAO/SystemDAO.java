package DAO;

import BeanClasses.Courses;
import BeanClasses.Student;
import Exceptions.StudentException;

public interface SystemDAO {
    public String addCourse(int id, String cname, int fees);
    public String updateCourseFees(int courseId, int newFees);
    public String deleteCourse(int id) throws StudentException;
    public Courses getCourseInformation(int id);
    public Student studentLogin(String email, String password)throws StudentException;
}
