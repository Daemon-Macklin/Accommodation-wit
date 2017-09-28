
public class StudentNode {

    public Student student;
    public StudentNode next;

    public void StudentNode(Student student, StudentNode next){
        this.setNext(next);
        this.setStudent(student);
    }

    public String toString(){
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
