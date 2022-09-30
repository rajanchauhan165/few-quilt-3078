package BeanClasses;

public class Courses {
    private int id;
    private String name;
    private int fees;

    public Courses() {
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                '}';
    }

    public Courses(int id, String name, int fees) {
        this.id = id;
        this.name = name;
        this.fees = fees;
    }
}
