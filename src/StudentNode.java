/**
 * StudentNode class- custom data structure
 *Unused code
 * @author Daemon-Macklin
 *
 *


public class StudentNode {

    private Student student;
    private StudentNode next;

    public  StudentNode(Student student, StudentNode next){
        this.setNext(next);
        this.setStudent(student);
    }

    public String toString() {

        return student.toString();

    }

    public void setStudent(Student student) {


        this.student = student;

    }

    public Student getStudent() {

        return student;
    }

    public void setNext(StudentNode next) {

        this.next = next;
    }

    public StudentNode getNext() {

        return next;
    }
}
*/