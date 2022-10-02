package DAO;

import BeanClasses.Courses;
import BeanClasses.Student;
import DatabaseUtility.DatabaseConnection;
import Exceptions.StudentException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SDImplementation implements SystemDAO{
    @Override
    public String addCourse(int id, String cname, int fees)throws StudentException {
        String output = null;

        try(Connection conn = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,cname);
            ps.setInt(3,fees);
            int x = ps.executeUpdate();
            if(x>0){
                output = "New Course Added Successfully";
            }else throw new StudentException("Course ID already Exist.");
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }

        return output;
    }

    @Override
    public String updateCourseFees(int courseId, int newFees)throws StudentException {
        String output = null;

        try(Connection conn = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("update course set fees=? where id=?");
            ps.setInt(1,newFees);
            ps.setInt(2,courseId);
            int x = ps.executeUpdate();
            if(x>0){
                output = "Course Fee Updated Successfully Of Course id "+courseId;
            }else throw new StudentException("Invalid Course ID");
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }

        return output;
    }

    @Override
    public String deleteCourse(int id)throws StudentException {
        String output = null;

        try(Connection conn = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("delete from course where id=?");
            ps.setInt(1,id);
            int x = ps.executeUpdate();
            if(x>0){
                output = "Course deleted Successfully Of Id "+id;
            }else {
                throw new StudentException("Course not fount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

    @Override
    public Courses getCourseInformation(int id)throws StudentException {
        Courses res = null;

        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from course where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int cid = rs.getInt("id");
                String name = rs.getString("name");
                int fees = rs.getInt("fees");
                int seats = rs.getInt("seats");
                res = new Courses(cid,name,fees,seats);
            }else throw new StudentException("Invalid Course Id.");
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }

        return res;
    }

    @Override
    public Student studentLogin(String email, String password) throws StudentException {
        Student student = null;

        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from student where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int getroll = rs.getInt("roll");
                String getName = rs.getString("name");
                String getEmail = rs.getString("email");
                String getPassword = rs.getString("password");
                int getcid = rs.getInt("courseid");
                student = new Student(getroll,getName,getEmail,getPassword,getcid);
            }
            else throw new StudentException("Invalid Username or Password.");
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }

        return student;
    }

    @Override
    public List<Courses> getCourseInfoStudent() throws StudentException{
        List<Courses> courses = new ArrayList<>();

        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from course");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int cid = rs.getInt("id");
                String name = rs.getString("name");
                int fees = rs.getInt("fees");
                int seats = rs.getInt("seats");
                courses.add(new Courses(cid,name,fees,seats));
            }
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }

        return courses;
    }

    @Override
    public String studentUpdateDetails(String email, String password) throws StudentException {
        String output = null;
        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from student where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Login successful.");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new email:");
                String nemail = sc.next();
                System.out.println("Enter new password:");
                String npass = sc.next();
                PreparedStatement ps2 = conn.prepareStatement("update student set email=?,password=? where email=? and password=? ");
                ps2.setString(1,nemail);
                ps2.setString(2,npass);
                ps2.setString(3,email);
                ps2.setString(4,password);
                int x =ps2.executeUpdate();
                if(x>0){
                    output="Record updated successfully";
                }
            }
            else throw new StudentException("Invalid Username or Password.");
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }
        return output;
    }

    @Override
    public String adminCreateBatch(int batchId, String courseName) throws StudentException {
        String output = null;
        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into batch(batch.id,batch.cname) values(?,?)");
            ps.setInt(1,batchId);
            ps.setString(2,courseName);
            int x=ps.executeUpdate();
            if(x>0){
                output="Batch created successfully";
            }else throw new StudentException("Batch Id already exist.");
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }
        return output;
    }

    @Override
    public String adminAddStudentToBatch(int batchId, String courseName, int courseId, int studentRoll) throws StudentException {
        String output = null;
        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into batch values(?,?,?,?)");
            ps.setInt(1,batchId);
            ps.setString(2,courseName);
            ps.setInt(3,courseId);
            ps.setInt(4,studentRoll);
            int x=ps.executeUpdate();
            if(x>0){
                output="Student added to batch successfully";
            }else throw new StudentException("Batch Id already exist.");
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }
        return output;
    }

    @Override
    public List<Student> studentInfoFromBatch(int batchId) throws StudentException {
        List<Student> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select s.name,s.email,s.roll from student s,course c,batch b where b.cid=c.id and b.sid=s.roll and b.id=?");
            ps.setInt(1,batchId);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                String n = rs.getString("name");
                String e = rs.getString("email");
                int r = rs.getInt("roll");
                Student s = new Student();
                s.setName(n);
                s.setEmail(e);
                s.setRoll(r);
                list.add(s);
            }
        } catch (SQLException e) {
            throw new StudentException(e.getMessage());
        }

        return list;
    }
}
