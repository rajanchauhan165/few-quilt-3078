package BeanClasses;

public class Courses {
    private int id;
    private String name;
    private int fees;
    private int seats;

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                ", seats=" + seats +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Courses(int id, String name, int fees, int seats) {
        this.id = id;
        this.name = name;
        this.fees = fees;
        this.seats = seats;
    }

    public Courses() {
    }
}
