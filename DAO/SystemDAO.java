package DAO;

import BeanClasses.Courses;

public interface SystemDAO {
    public String addCourse(int id, String cname, int fees);
    public String updateCourseFees(int courseId, int newFees);
    public String deleteCourse(int id);
    public Courses getCourseInformation(int id);
}
