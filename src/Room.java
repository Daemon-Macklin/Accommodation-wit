public class Room {

    //Level
    //En suit
    // Property
    // id

        private int level;
        private int property;
        private int id;
        private boolean enSuit;

    public Room(int level, boolean enSuit, int property, int id){
        this.setLevel(level);
        this.setEnSuit(enSuit);
        this.setProperty(property);
        this.setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnSuit(boolean enSuit) {
        this.enSuit = enSuit;
    }

    public void setLevel(int level) {
        this.level = level;
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
