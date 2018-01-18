/**
 * StudentList class- custom data structure manger for StudentNode Objects
 * Unused code
 *
 * @author Daemon-Macklin
 *


public class StudentList {

    private StudentNode head;
    private StudentNode tail;


    public void StudentList(){
        this.head = null;
        this.tail = null;
    }

    public void addStudent(Student student){
        StudentNode newStudent = new StudentNode(student, null);
        if(isEmpty()){
            head = newStudent;
            tail = newStudent;
        }
        else{
            tail.setNext(newStudent);
            tail = newStudent;
        }
        System.out.println("The student: " + newStudent.getStudent().getName()
                + " Has been added");
    }

    public void removeStudent(StudentNode student){
        StudentNode studentBefore = head;
        while(studentBefore.getNext() != null){
            if(studentBefore.getNext() == student){
                studentBefore.setNext(student.getNext());
            }
            else {
                studentBefore = studentBefore.getNext();
            }
        }
            if(studentBefore.getNext() == null && studentBefore == student){
                head = studentBefore.getNext();
            }
    }

    public int countStudent(){
        int count = 0;
        if(isEmpty()){
            count = 0;
        }
        else {
            StudentNode student = head;
            while (student.getNext() != null) {
                count++;
                student = student.getNext();
            }
        }
        return count;
    }

    public int idGen(){
        StudentNode student = tail;
        int id;
        if(tail == null){
            id = 1;
        }
        else {
            id = student.getStudent().getId() + 1;
        }
        return id;
    }

    public String viewStudents() {
        String students = "";
        if (isEmpty()) {
            students = "No Students";
        } else {
            StudentNode student = head;
            while (student.getNext() != null) {
                students = students + " Name: " + student.getStudent().getName()
                        + " ID: " + student.getStudent().getId() + ",";
                student = student.getNext();
            }
            students = students + " Name: " + student.getStudent().getName()
                    + " ID: " + student.getStudent().getId() + ",";
           }
            return students;
        }

    public StudentNode findStudent(int id){
        StudentNode foundStudent = null;
        StudentNode student = head;
        while(student.getNext() != null){
            if(student.getStudent().getId() == id){
                foundStudent = student;
            }
            student = student.getNext();
        }
        if(student.getStudent().getId() == id){
            foundStudent = student;
        }
        return foundStudent;
    }

    public boolean isEmpty(){
        if(head == null){
          return true;
        }
        else{
            return false;
        }
    }
}
*/