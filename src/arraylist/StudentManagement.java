package arraylist;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();

    protected StudentManagement() {
    }

    protected StudentManagement(List<Student> students) {
        this.students = students;
    }

    protected void displayStudent() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    protected List<Student> getStudents() {
        return students;
    }

    protected void setStudents(List<Student> students) {
        this.students = students;
    }

    protected Student editStudent(int index, Student student) {
       return students.set(index, student);
    }

    protected void deleteStudent(int index) {
        students.remove(index);
    }

    protected void addStudent(Student student) {
        students.add(student);
    }
}
