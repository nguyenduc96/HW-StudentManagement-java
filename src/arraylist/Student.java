package arraylist;

public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private String country;
    private String className;
    private double point;

    protected Student() {
    }

    protected Student(String id, String name, String country, String className, double point) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.className = className;
        this.point = point;
    }

    protected String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getCountry() {
        return country;
    }

    protected void setCountry(String country) {
        this.country = country;
    }

    protected String getClassName() {
        return className;
    }

    protected void setClassName(String className) {
        this.className = className;
    }

    protected double getPoint() {
        return point;
    }

    protected void setPoint(double point) {
        this.point = point;
    }

    @Override
    public int compareTo(Student student) {
        return this.getId().compareTo(student.getId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "Mã Sinh viên = '" + id + '\'' +
                ", Họ và tên ='" + name + '\'' +
                ", Quê quán ='" + country + '\'' +
                ", Lớp ='" + className + '\'' +
                ", Điểm =" + point +
                '}';
    }
}
