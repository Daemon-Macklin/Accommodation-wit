/**
 * Property Class
 *
 * @author Daemon-Macklin
 *
 */

public class Property {

    //address
    //parking spaces
    //distance from wit
    //id

    private String address;
    private int parking;
    private double distanceWit;
    private int id;

    /**
     * Constructor for property class
     * @param address address
     * @param parking parking spaces
     * @param distanceWit distance from wit
     * @param id property id
     */
    public Property(String address, int parking, double distanceWit, int id){
        this.setAddress(address);
        this.setParking(parking);
        this.setDistanceWit(distanceWit);
        this.setId(id);
    }

    /**
     * To String
     * @return to string
     */
    public String toString() {
        return "Address: " + this.getAddress() + " ID:" + this.getId()
                + " Parking: " + this.getParking() + "Distance: " + this.distanceWit;
    }

    /*
    Getters and setters
     */

    public void setId(int id) {

        this.id = id;

    }

    public void setAddress(String address) {
        if(this.address == null){
            int maxLength = (address.length() < 40)?address.length():40;
            address = address.substring(0, maxLength);
            this.address = address;
        }
        else{
            if(address.length() < 30){
                this.address = address;
            }
        }
    }

    public void setParking(int parking) {

        this.parking = parking;
    }

    public void setDistanceWit(double distanceWit) {
        if(distanceWit > 99){
         this.distanceWit = 99;
        }
        else {
            this.distanceWit = distanceWit;
        }
    }

    public int getId() {

        return id;
    }

    public String getAddress() {

        return address;
    }

    public double getDistanceWit() {

        return distanceWit;
    }

    public int getParking() {

        return parking;
    }
}
