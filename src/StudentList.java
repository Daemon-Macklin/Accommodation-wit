/**
 * StudentNode class- custom data structure manger
 *
 * @author Daemon-Macklin
 *
 */

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
        System.out.println("The student :" + newStudent.getStudent().toString() + " Has been added");
    }

    public void removeStudent(StudentNode student){

    }

    public int countStudent(){
        int count = 0;
        if(isEmpty()){
            count =0;
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

    public boolean isEmpty(){
        if(head == null){
          return true;
        }
        else{
            return false;
        }
    }
}
