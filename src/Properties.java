/**
 * Properties manager
 */

public class Properties extends MyList<Property> {

    /**
     * Constructor for properties
     * Imports methods from MyList
     */
    public Properties() {

        super();

    }

    /**
     * Method to create unique identifiers
     * @return new id
     */
    public int idGen(){
        MyObject<Property> current = tail;
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
     * Method to view properties
     * @return String of properties
     */
    public String viewProperties() {
        String str = "";
        if (isEmpty()) {
            str = "No properties";
        }

        else {
            MyObject<Property> property = head;

            while (property.getNext() != null) {
                str = str + "Address: " + property.getCurrent().getAddress() + ", Parking spaces: "
                        + property.getCurrent().getParking() + ", Distance from WIT: " + property.getCurrent().getDistanceWit()
                        + ", Property ID: " + property.getCurrent().getId() + "\n";

                property = property.getNext();
            }
            str = str + "Address: " + property.getCurrent().getAddress() + ", Parking spaces: "
                    + property.getCurrent().getParking() + ", Distance from WIT: " + property.getCurrent().getDistanceWit()
                    + ", Property ID: " + property.getCurrent().getId() + "\n";
        }
            return str;
    }

    /**
     * Method to find properties given id
     * @param id property id
     * @return found property
     */
    public MyObject findProperty(int id){
        MyObject<Property> property = head;
        MyObject<Property> foundProperty = null;
        int option = id;
        while(property.getNext() != null){
            if(property.getCurrent().getId() == id){
                foundProperty = property;
            }
            property = property.getNext();
        }
        if(property.getCurrent().getId() == id){
            foundProperty = property;
        }
        return foundProperty;
    }

    /**
     * Method to find properties with parking spaces
     * @param option number of parking spaces wanted
     * @return Array of properties with parking
     */
    public MyObject<Property>[] findPropertiesWithParking(int option){
        int level = option;
        MyObject<Property> property = head;
        MyObject<Property>[] properties = new MyObject[this.countThroughObject()+2];
        int count = 0;
        while(property.getNext() != null){
            if(property.getCurrent().getParking() >= option){
                properties[count] = property;
            }
            property = property.getNext();
            count ++;
        }
        if(property.getCurrent().getParking() >= option){
            properties[count] = property;
        }
        properties[this.countThroughObject()+1] = null;
        return properties;
    }

    /**
     * Method to find properties within distance to wit
     * @param option max distance
     * @return Array of properties
     */
    public MyObject<Property>[] findPropertiesWithinDistance(double option){
        double level = option;
        MyObject<Property> property = head;
        MyObject<Property>[] properties = new MyObject[this.countThroughObject()+2];
        int count = 0;
        while(property.getNext() != null){
            if(property.getCurrent().getDistanceWit() <= option){
                properties[count] = property;
            }
            property = property.getNext();
            count ++;
        }
        if(property.getCurrent().getDistanceWit() <= option){
            properties[count] = property;
        }
        properties[this.countThroughObject()+1] = null;
        return properties;
    }
}

