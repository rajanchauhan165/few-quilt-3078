package DAO;

import BeanClasses.Courses;
import DatabaseUtility.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SDImplementation implements SystemDAO{
    @Override
    public String addCourse(int id, String cname, int fees) {
        String output = null;

        try(Connection conn = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,cname);
            ps.setInt(3,fees);
            int x = ps.executeUpdate();
            if(x>0){
                output = "New Course Added Successfully";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

    @Override
    public String updateCourseFees(int courseId, int newFees) {
        String output = null;

        try(Connection conn = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("update course set fees=? where id=?");
            ps.setInt(1,newFees);
            ps.setInt(2,courseId);
            int x = ps.executeUpdate();
            if(x>0){
                output = "Course Fee Updated Successfully Of Course id "+courseId;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

    @Override
    public String deleteCourse(int id) {
        String output = null;

        try(Connection conn = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("delete from course where id=?");
            ps.setInt(1,id);
            int x = ps.executeUpdate();
            if(x>0){
                output = "Course deleted Successfully Of Id "+id;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

    @Override
    public Courses getCourseInformation(int id) {
        Courses res = null;

        try (Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from course where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int cid = rs.getInt("id");
                String name = rs.getString("name");
                int fees = rs.getInt("fees");
                res = new Courses(cid,name,fees);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }
}
