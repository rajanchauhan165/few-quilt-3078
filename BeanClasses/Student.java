package BeanClasses;

public class Student {
    private int roll;
    private String name;
    private String email;
    private String password;
    private int courseId;

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", courseId=" + courseId +
                '}';
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Student(int roll, String name, String email, String password, int courseId) {
        this.roll = roll;
        this.name = name;
        this.email = email;
        this.password = password;
        this.courseId = courseId;
    }

    public Student() {
    }
}
