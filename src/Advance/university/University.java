package Advance.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName) ) {
                return student;
            }
        }
        return null;
    }

    public String dismissStudent(Student student){
        for (int i = 0; i < getStudentCount(); i++) {
            if (student.getFirstName().equals(students.get(i).getFirstName()) &&
                    student.getLastName().equals(students.get(i).getLastName())){
               students.remove(student);
                return String.format("Removed student %s %s",student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found";
    }

    public String registerStudent(Student student){
        if(capacity > students.size()){
            for (Student student1 : students) {
                if (student.getFirstName().equals(student1.getFirstName()) &&
                student.getLastName().equals(student1.getLastName())){
                    return "Student is already in the Advance.Advance.university";
                }
            }
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(),student.getLastName());
        } else {
            return "No seats in the Advance.Advance.university";
        }
    }

    public int getStudentCount(){
        return students.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();

        for(Student student:students){
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()));
        }

        return sb.toString();
    }
}
