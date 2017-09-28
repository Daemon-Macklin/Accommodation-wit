public class Property {

    //address
    //parking spaces
    //distance from wit
    //Number in structure

    private String address;
    private int parking;
    private double distanceWit;
    private int id;

    public Property(String address, int parking, double distanceWit, int id){
        this.setAddress(address);
        this.setParking(parking);
        this.setDistanceWit(distanceWit);
        this.setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public void setDistanceWit(double distanceWit) {
        this.distanceWit = distanceWit;
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
