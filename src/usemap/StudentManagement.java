package usemap;

import java.util.HashMap;
import java.util.Map;

public class StudentManagement {
    private Map<String, Student> studentMap = new HashMap<>();

    protected Map<String, Student> getStudentMap() {
        return studentMap;
    }

    protected void setStudentMap(Map<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    protected void displayStudentInMap() {
        for (Map.Entry<String, Student> student : studentMap.entrySet()) {
            System.out.println(student.getValue());
        }
    }

    protected void addStudentInMap(Student student) {
        this.studentMap.put(student.getId(), student);
    }

    protected void editStudentInMap(String id, Student student) {
        this.studentMap.replace(id, student);
    }

    protected void deleteStudentInMap(String id) {
        this.studentMap.remove(id);
    }

    protected boolean findIndex(String id) {
        return studentMap.containsKey(id);
    }
}
