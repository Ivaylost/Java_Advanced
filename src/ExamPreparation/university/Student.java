package ExamPreparation.university;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s", firstName, lastName, bestSubject);
    }

    @Override
    public int compareTo(Student other) {
        int result = -1;
        if(this.firstName.equals(other.getFirstName()) && this.lastName.equals(other.getLastName())) {
            result = 0;
        }
        return result;
    }
}
