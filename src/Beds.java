/**
 * Beds manager
 *
 * @author Daemon-Macklin
 *
 */

public class Beds extends MyList {

    /**
     * Constructor for beds
     * importing methods from mylist
     */
    public Beds() {

        super();

    }

    /**
     * generating unique ids for items in list
     * @return new id
     */
    public int idGen() {
        MyObject<Bed> current = tail;
        int id;
        if (tail == null) {
            id = 1;
        } else {
            id = current.getCurrent().getId() + 1;
        }
        return id;
    }

    /**
     * Method that sets a student to a bed
     * @param id Student id
     * @param bed Bed id
     */
    public void addStudentToBed(int id, MyObject bed) {
        int student = id;
        MyObject<Bed> takenBed = bed;
        if (takenBed.getCurrent().isStudent()) {
            System.out.println("Bed already taken");
        } else {
            takenBed.getCurrent().setStudent(student);
        }
    }

    /**
     * Method to remove student from bed
     * @param id Student id
     * @param bed Bed id
     */
    public void removeStudentFromBed(int id, MyObject bed) {
        int student = id;
        MyObject<Bed> bedToClear = bed;

        if (bedToClear.getCurrent().isStudent()) {
            bedToClear.getCurrent().setStudent(id);
        } else {
            System.out.println("No Student");
        }

    }

    /**
     * Method used to view beds
     * @return String of beds
     */
    public String viewBeds() {
        String str = "";
        MyObject<Bed> bed = head;
        if (isEmpty()) {
            str = "No Beds";
        } else {
            while (bed.getNext() != null) {
                str = str + " Taken: " + bed.getCurrent().isStudent() + ", Bed ID: " + bed.getCurrent().getId()
                        + ", Type: " + bed.getCurrent().getType() + ", Cost: " + bed.getCurrent().getCost() +
                        ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
                bed = bed.getNext();
            }
            str = str + " Taken: " + bed.getCurrent().isStudent() + " ,Bed ID: " + bed.getCurrent().getId()
                    + " ,Type: " + bed.getCurrent().getType() + " ,Cost: " + bed.getCurrent().getCost() +
                    ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
        }
        return str;
    }

    /**
     * Method to find bed by id
     * @param id Bed id
     * @return Found bed
     */
    public MyObject findBed(int id) {
        MyObject<Bed> bed = head;
        MyObject<Bed> foundbed = null;
        int option = id;

        while (bed.getNext() != null) {
            if (bed.getCurrent().getId() == id) {
                foundbed = bed;
            }
            bed = bed.getNext();
        }
        if (bed.getCurrent().getId() == id) {
            foundbed = bed;
        }
        return foundbed;
    }

    /**
     * Method that lists all avaliable beds
     * @return List of free beds (String)
     */
    public String listFreeBed() {
        MyObject<Bed> bed = head;
        String str = "";
        if (isEmpty()) {
            str = "No beds";
        } else {
            while (bed.getNext() != null) {
                if (!bed.getCurrent().isStudent()) {
                    str = str + " Taken: " + bed.getCurrent().isStudent() + " ,Bed ID: " + bed.getCurrent().getId()
                            + " ,Type: " + bed.getCurrent().getType() + " ,Cost: " + bed.getCurrent().getCost() +
                            ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
                }
                bed = bed.getNext();
            }
            if (!bed.getCurrent().isStudent()) {
                str = str + " Taken: " + bed.getCurrent().isStudent() + " ,Bed ID: " + bed.getCurrent().getId()
                        + " ,Type: " + bed.getCurrent().getType() + " ,Cost: " + bed.getCurrent().getCost() +
                        ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
            }
        }
        return str;
    }

    /**
     * Method to list beds under a certain cost
     * @param cost search option
     * @return list of beds
     */
    public String searchByCost(int cost){
        MyObject<Bed> bed = head;
        String str = "";
        if (isEmpty()) {
            str = "No beds";
        } else {
            while (bed.getNext() != null) {
                if (bed.getCurrent().getCost() <= cost) {
                    str = str + " Taken: " + bed.getCurrent().isStudent() + " ,Bed ID: " + bed.getCurrent().getId()
                            + " ,Type: " + bed.getCurrent().getType() + " ,Cost: " + bed.getCurrent().getCost() +
                            ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
                }
                bed = bed.getNext();
            }
            if (bed.getCurrent().getCost() <= cost) {
                str = str + " Taken: " + bed.getCurrent().isStudent() + " ,Bed ID: " + bed.getCurrent().getId()
                        + " ,Type: " + bed.getCurrent().getType() + " ,Cost: " + bed.getCurrent().getCost() +
                        ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
            }
        }
        return str;
    }

    /**
     * Method to list beds based on type
     * @param type option
     * @return List of free beds
     */
    public String searchByType(String type){
        MyObject<Bed> bed = head;
        String str = "";
        if (isEmpty()) {
            str = "No beds";
        } else {
            while (bed.getNext() != null) {
                if (bed.getCurrent().getType() == type) {
                    str = str + " Taken: " + bed.getCurrent().isStudent() + " ,Bed ID: " + bed.getCurrent().getId()
                            + " ,Type: " + bed.getCurrent().getType() + " ,Cost: " + bed.getCurrent().getCost() +
                            ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
                }
                bed = bed.getNext();
            }
            if (bed.getCurrent().getType() == type) {
                str = str + " Taken: " + bed.getCurrent().isStudent() + " ,Bed ID: " + bed.getCurrent().getId()
                        + " ,Type: " + bed.getCurrent().getType() + " ,Cost: " + bed.getCurrent().getCost() +
                        ", Room ID: " + bed.getCurrent().getRoomId() + "\n";
            }
        }
        return str;
    }

    /**
     * Method to find bed with bed with a certain room id
     * @param id room id
     */
    public void findBedWithRoomID(int id){
        MyObject<Bed> bed = head;
        int roomID = id;
        while(bed.getNext() != null){
            if(bed.getCurrent().getRoomId() == roomID) {
                System.out.println(" Taken: " + bed.getCurrent().isStudent() + ", Bed ID: " + bed.getCurrent().getId()
                        + ", Type: " + bed.getCurrent().getType() + ", Cost: " + bed.getCurrent().getCost() +
                        ", Room ID: " + bed.getCurrent().getRoomId() + "\n");
            }
            bed = bed.getNext();
        }
        if(bed.getCurrent().getRoomId() == roomID){
            System.out.println( " Taken: " + bed.getCurrent().isStudent() + ", Bed ID: " + bed.getCurrent().getId()
                    + ", Type: " + bed.getCurrent().getType() + ", Cost: " + bed.getCurrent().getCost() +
                    ", Room ID: " + bed.getCurrent().getRoomId() + "\n");
        }
    }

    /**
     * Method to count revenue from room
     * @param id room id
     * @return int of room revenue
     */
    public int getRoomRev(int id){
    MyObject<Bed> bed = head;
    int roomID= id;
    int rev = 0;
    while(bed.getNext() != null) {
        if (bed.getCurrent().getRoomId() == roomID) {
            rev = rev + bed.getCurrent().getCost();
        }
        bed = bed.getNext();
    }
        if(bed.getCurrent().getRoomId() == roomID) {
            rev = rev + bed.getCurrent().getCost();
        }
    return rev;
    }
}




