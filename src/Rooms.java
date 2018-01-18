/**
 * Class that manages rooms
 */

public class Rooms extends MyList{

    /**
     * Constructor
     * Importing methods from MyList
     */
    public Rooms() {

        super();

    }

    /**
     * Method to generte unique identifiers
     * @return new id
     */
    public int idGen(){
        MyObject<Room> current = tail;
        int id;
        if(tail == null){
            id = 1;
        }
        else {
            id = current.getCurrent().getId() + 1;
        }
        return id;
    }

    /**
     * Method to view all rooms
     * @return String of all rooms
     */
    public String viewRooms(){
        String str = "";
        if(isEmpty()){
            str = "No Rooms";
        }
        else{
            MyObject<Room> room = head;

            while(room.getNext() != null){
                str = str + " Property: " + room.getCurrent().getProperty() + ", EnSuite: " + room.getCurrent().isEnSuit()
                + ", Floor: " + room.getCurrent().getLevel() + ", Room ID: " + room.getCurrent().getId() + "\n";
                room = room.getNext();
            }
            str = str + " Property: " + room.getCurrent().getProperty() + ", EnSuite? " + room.getCurrent().isEnSuit()
                    + ", Floor: " + room.getCurrent().getLevel() + ", Room ID: " + room.getCurrent().getId() + "\n";

        }
        return str;
    }

    /**
     * Method to find room
     * @param id wanted room id
     * @return wanted room object
     */
    public MyObject findRoom(int id){
        MyObject <Room> room = head;
        MyObject <Room> foundRoom = null;
        int option = id;
        while (room.getNext() != null){
            if(room.getCurrent().getId() == id){
                foundRoom = room;
            }
            room = room.getNext();
        }
        if(room.getCurrent().getId() == id){
           foundRoom = room;
        }
        return foundRoom;
    }

    /**
     * Method to find rooms in property
     * @param id property id
     * @return Array of rooms
     */
    public MyObject<Room>[] roomsInproperty(int id){
        int propertyId = id;
        MyObject <Room> room = head;
        MyObject<Room> [] rooms = new MyObject[this.countThroughObject()+2];
        int count = 0;
        while(room.getNext() != null){
            if(room.getCurrent().getProperty() == propertyId){
                rooms[count] = room;
            }
            room = room.getNext();
            count += 1;
        }
        if(room.getCurrent().getProperty() == propertyId) {
            rooms[count] = room;
        }
        return rooms;
    }

    /**
     * Method to remove all rooms in property
     * @param id
     */
    public void removeRoomsInProperty(int id){
        int propertyId = id;
        MyObject <Room> room = head;

        while(room.getNext() != null){
            if(room.getCurrent().getProperty() == propertyId){
                this.removeObject(room);
            }
            room = room.getNext();
        }
        if(room.getCurrent().getProperty() == propertyId){
            this.removeObject(room);
        }
    }

    /**
     * Method to find room on one floor
     * @param option floor wanted
     * @return Array of rooms
     */
    public MyObject<Room>[] findRoomsOnLevel(int option){
        int level = option;
        MyObject<Room> room = head;
        MyObject<Room>[] rooms = new MyObject[this.countThroughObject()+2];
        int count = 0;
        while(room.getNext() != null){
            if(room.getCurrent().getLevel() == level){
                rooms[count] = room;
            }
            room = room.getNext();
            count ++;
        }
        if(room.getCurrent().getLevel() == level){
            rooms[count] = room;
        }
        return rooms;
    }

    /**
     * Method to find rooms with EnSuites
     * @param option true/false if want EnSuites
     * @return Array of rooms
     */
    public MyObject<Room>[] findEnSuites(boolean option){
        boolean wantEnSuite = option;
        MyObject<Room> room = head;
        MyObject<Room>[] rooms = new MyObject[this.countThroughObject()+2];
        int count = 0;
        while(room.getNext() != null){
            if(room.getCurrent().isEnSuit() == option){
                rooms[count] = room;
            }
            room = room.getNext();
            count ++;
        }
        if(room.getCurrent().isEnSuit() == option){
            rooms[count] = room;
        }
        return rooms;
    }
}
