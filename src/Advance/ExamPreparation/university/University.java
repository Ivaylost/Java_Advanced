package Advance.ExamPreparation.university;

import java.util.*;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if(capacity > getCapacity()) {
            students.stream().anyMatch(x -> x.compareTo(student) == 0);
        } else {
            return "No seats in the Advance.university";
        }
        return "";
    }
}
