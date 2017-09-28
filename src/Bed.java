public class Bed {
    //Room
    // ID
    // Student
    //type
    //cost

        private int room;
        private int id;
        private int student;
        private int cost;
        private String type;


    public  Bed(int room, int id, int student, int cost, String type){
        this.setRoom(room);
        this.setId(id);
        this.setStudent(student);
        this.setCost(cost);
        this.setType(type);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(int student) {
        if(this.student == 0) {
            this.student = student;
        }
        else{
            System.out.println("Error Student already assigned to room");
        }
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getRoom() {
        return this.room;
    }

    public String getType(){
        return this.type;
    }

}

