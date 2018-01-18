/**
 * Bed Class
 *
 * @author Daemon-Macklin
 *
 */


public class Bed {

        private int id;
        private int student;
        private int cost;
        private int roomId;
        private String type;


    /**
     * Constructor for bed class/object
     */
    public  Bed(int id, int student, int cost, String type, int roomId){
        this.setId(id);
        this.setStudent(student);
        this.setCost(cost);
        this.setType(type);
        this.setRoom(roomId);
    }

    /**
     * Check to see if there is a student assigned to bed
     * @return boolean true when student false when no student
     */
    public boolean isStudent(){
        boolean isStudent;
        if(this.getStudent() == 0){
            isStudent = false;
        }
        else {
            isStudent = true;
        }
        return isStudent;
    }

    /**
     * To String
     * @return to String
     */
    public String toString(){
        return "ID; " + this.getId() + ", Cost: " + this.getCost() +
                " Type: " + this.getType() + " Room: " + this.getRoomId()
                + " Student " + this.getStudent();
    }

    /*
    Getters and setters
     */

    public void setRoom(int roomId){

        this.roomId = roomId;

    }

    public void setId(int id) {

        this.id = id;
    }

    public void setStudent(int student) {
        if(this.student == 0 || student == 0) {
            this.student = student;
        }
        else{
            System.out.println("Error Student already assigned to bed");
        }
    }

    public void setCost(int cost) {
        if(cost > 999){
         this.cost = 999;
        }
        else {
            this.cost = cost;
        }
    }

    public void setType(String type) {
        if(type.equals("single")){
            type = "Single";
        }
        else if(type.equals("double")){
            type = "Double";
        }
        else if(type.equals("bunkbed")){
            type = "Bunkbed";
        }
        if(type.equals("Bunkbed") || type.equals("Double") || type.equals("Single")) {
            this.type = type;
        }
        else{
            System.out.println("Invalid bed type");
            this.type = "Unspecified";
        }
    }

    public int getId() {

        return this.id;
    }

    public int getStudent() {

        return this.student;
    }

    public int getCost() {

        return this.cost;
    }

    public String getType(){

        return this.type;
    }

    public int getRoomId(){

        return this.roomId;
    }

}

