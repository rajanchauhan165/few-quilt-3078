package DAO;

import BeanClasses.Courses;
import BeanClasses.Student;
import Exceptions.StudentException;

import java.util.List;

public interface SystemDAO {
    public String addCourse(int id, String cname, int fees) throws StudentException;
    public String updateCourseFees(int courseId, int newFees)throws StudentException;
    public String deleteCourse(int id) throws StudentException;
    public Courses getCourseInformation(int id)throws StudentException;
    public Student studentLogin(String email, String password)throws StudentException;
    public List<Courses> getCourseInfoStudent() throws StudentException;
    public String studentUpdateDetails(String email,String password)throws StudentException;
    public String adminCreateBatch(int batchId, String courseName)throws StudentException;
    public String adminAddStudentToBatch(int batchId, String courseName,int courseId, int studentRoll)throws StudentException;

    public List<Student> studentInfoFromBatch(int batchId)throws StudentException;
}
