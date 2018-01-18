/**
 * Room Class
 *
 * @author Daemon-Macklin
 *
 */

public class Room {

    //Level
    //En suit
    // Property
    // id

        private int level;
        private int property;
        private int id;
        private boolean enSuit;

    /**
     * Constructor for rooms
     * @param level Floor room is on
     * @param enSuit if it has and enSuite or not
     * @param property Property id
     * @param id Room id
     */
    public Room(int level, boolean enSuit, int property, int id){
        this.setLevel(level);
        this.setEnSuit(enSuit);
        this.setProperty(property);
        this.setId(id);
    }

    /**
     * To String
     * @return
     */
    public String toString(){
       return "Room: " + this.getId() + ", Level: " + this.getLevel()
       + ", EnSuite: " + this.isEnSuit() + ", Property " + this.getProperty();
    }

    /*
    Getters and Setters
     */
    public void setId(int id) {

        this.id = id;

    }

    public void setEnSuit(boolean enSuit) {

        this.enSuit = enSuit;
    }

    public void setLevel(int level) {
        if(level < 4) {
            this.level = level;
        }
        else{
            this.level = 1;
        }
    }

    public void setProperty(int property) {

        this.property = property;
    }

    public int getId() {

        return id;
    }

    public boolean isEnSuit() {

        return enSuit;
    }

    public int getLevel() {

        return level;

    }

    public int getProperty() {

        return property;
    }
}
