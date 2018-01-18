/**
 * Students managed
 */

public class Students extends MyList{

    /**
     * Constructor for students
     * Importing methods from MyList
     */
    public Students() {

        super();

    }

    /**
     * Method to generate unique identifiers
     * @return
     */
    public int idGen(){
        MyObject<Student> current = tail;
        int id;
        if(tail == null){
            id = 1;
        }
        else {
            id = current.getCurrent().getId() + 1;
        }
        return id;
    }

    /*
    Unused method to count students(Method in MyList)
    public int countStudent(){
        int count = 0;
        if(isEmpty()){
            count = 0;
        }
        else {
            MyObject<Student> student = head;
            while (student.getNext() != null) {
                count++;
                student = student.getNext();
            }
        }
        return count;
    }
    */

    /**
     * Method to view all students
     * @return String of all students
     */
    public String viewStudents() {
        String students = "";
        if (isEmpty()) {
            students = "No Students";
        } else {
            MyObject<Student> student = head;
            while (student.getNext() != null) {
                students = students + " Name: " + student.getCurrent().getName()
                        + " ID: " + student.getCurrent().getId() + "\n";
                student = student.getNext();
            }
            students = students + " Name: " + student.getCurrent().getName()
                    + " ID: " + student.getCurrent().getId() + "\n";
        }
        return students;
    }

    /**
     * Method to find student
     * @param id student id
     * @return MyObject containing student
     */
    public MyObject findStudent(int id){
        MyObject<Student> foundStudent = null;
        MyObject<Student> student = head;
        while(student.getNext() != null){
            if(student.getCurrent().getId() == id){
                foundStudent = student;
            }
            student = student.getNext();
        }
        if(student.getCurrent().getId() == id){
            foundStudent = student;
        }
        return foundStudent;
    }
}
