/**
 * Driver Class
 *
 * @author Daemon-Macklin
 *
 */

import java.util.Scanner;
import java.io.*;

public class Driver {

    public Scanner input;

    public Properties myListP = new Properties();
    public Rooms myListR = new Rooms();
    public Beds myListB = new Beds();
    public Students myListS = new Students();

    /**
     * Main method, program sarts here
     * @param args
     */
    public static void main(String[] args){
        Driver accom = new Driver();
        accom.load();
    }

    /**
     * Driver constructor
     */
    public Driver(){
        input = new Scanner(System.in);
    }

    public void load(){
        //CSV LOADING
        this.runStart();
    }

    /**
     * Main menu
     * @return option for main menu
     */
    public int start(){
        int option;
        System.out.println("----Welcome to WIT accommodation service----");
        System.out.println("----Please select an option----");
        System.out.println(" 1) Add Student");
        System.out.println(" 2) Add Property");
        System.out.println(" 3) Add Room");
        System.out.println(" 4) Add Bed");
        System.out.println(" 5) View");
        System.out.println(" 6) Remove");
        System.out.println(" 7) Add Student to bed");
        System.out.println(" 8) Remove Student from bed");
        System.out.println(" 9) Search Menu");
        System.out.println(" 0) Other");
        option = -1;

        while(option < 0 || option > 9){
            option = getIntOption();
            if(option < 0 || option > 9){
                this.optionError();
            }
        }
        return option;

    }

    /**
     * Runs main menu
     *
     */
    public void runStart(){
        int option = this.start();

        switch(option){
            case 1:
                this.addStudent();
                break;

            case 2:
                this.addProperty();
                this.runStart();
                break;

            case 3:
                this.addRoom();
                this.runStart();
                break;

            case 4:
                this.addBed();
                this.runStart();
                break;

            case 5:
                this.runViewMenu();
                break;

            case 6:
                this.runRemoveMenu();
                break;

            case 7:
                this.addStudentToBed();
                break;

            case 8:
                this.removeStudentFromBed();
                break;

            case 9:
                this.runSearchMenu();
                break;

            case 0:
                this.runOther();
                break;
            default:
                this.optionError();
                break;
        }
    }

    /**
     * Takes in data on student to make new students then sends student data to
     * mylist to make new node
     */

    public void addStudent(){
        getStringOption();
        System.out.println("Name");
            String name = getStringOption();

        System.out.println("Gender");
            String gender = getStringOption();

        boolean hasCar = runCar();

        int id = myListS.idGen();
        myListS.addObject(new Student(name, gender, hasCar, id));
        this.runStart();
    }

    /**
     * Takes in bed id checks if valid then calls remove method in
     * mylist
     */
    public void removeStudentFromBed(){
        getStringOption();
        boolean isBed = true;

        System.out.println("Which Bed would you like to clear(id)");
        int bedId= getIntOption();
        if(myListB.findBed(bedId) != null){
            isBed = true;
            System.out.println("Found Bed");
        }
        else{
            System.out.println("Bed not Found");
            isBed =false;
        }

        if(isBed){
            MyObject bed = myListB.findBed(bedId);
            myListB.removeStudentFromBed(0, bed);
        }
        this.runStart();
    }

    /**
     * Takes in bed id and student id checks if valid then calls add student to bed method in
     * mylist
     */
    public void addStudentToBed(){
        getStringOption();
        boolean isStudent = false;
        boolean isBed = true;
        System.out.println("Which Student would you like to add to bed(id)");
        int studentId = getIntOption();
            if (myListS.findStudent(studentId) != null) {
                isStudent = true;
                System.out.println("Found Student");
            }
            else {
                System.out.println("Student not Found");
                this.runStart();
            }

        System.out.println("Which Bed would you like to add them to(id)");
            int bedId= getIntOption();
              if(myListB.findBed(bedId) != null){
                  isBed = true;
                  System.out.println("Found Bed");
              }
              else{
                  System.out.println("Bed not Found");
                  this.runStart();
              }


         if(isStudent == true && isBed == true){
                MyObject bed = myListB.findBed(bedId);
                myListB.addStudentToBed(studentId, bed);
        }
        this.runStart();
    }

    /**
     * runs the menu to choose if student has car
     * @return boolean hasCar
     */
    public boolean runCar(){
        int option = car();
        boolean hasCar = false;
        if(option == 1){
            hasCar = true;
        }
        else if(option == 2){
           hasCar = false;
        }
        else{
           this.optionError();
        }
        return hasCar;
    }

    /**
     * Menu to choose if student has car
     * @return int option for has car
     */
    public int car(){
       int option;
       System.out.println("Does the student have a car?");
       System.out.println(" 1) Yes");
       System.out.println(" 2) No");
       option = 0;
        while(option < 1 || option > 2){
            option = getIntOption();
            if(option < 1 || option > 2){
                this.optionError();
            }
        }
        return option;
    }

    /**
     * Runs menu to view properties, students, rooms, beds, etc.
     */
    public void runViewMenu(){
        int option = viewMenu();
        switch(option) {
            case 1:
                System.out.println(myListS.viewStudents());
                getStringOption();
                this.runStart();
                break;

            case 2:
                System.out.println(myListP.viewProperties());
                getStringOption();
                this.runStart();
                break;
            case 3:
                System.out.println(myListR.viewRooms());
                getStringOption();
                this.runStart();
                break;
            case 4:
                System.out.println(myListB.viewBeds());
                getStringOption();
                this.runStart();
                break;
            case 5:
                this.getPropertyRevenue();
                getStringOption();
                this.runStart();
            default:
                this.optionError();
                break;
        }
    }

    /**
     * Menu used to veiw students, properties, etc.
     * @return option selected
     */
    public int viewMenu(){
        int option;
        System.out.println("What would you like to view?");
        System.out.println(" 1) Students");
        System.out.println(" 2) Properties");
        System.out.println(" 3) Rooms");
        System.out.println(" 4) Beds");
        System.out.println(" 5) Property Revenue");

        option = 0;
        while(option < 1 || option > 5){
            option = getIntOption();
            if(option < 1 || option > 5){
                this.optionError();
            }
        }
        return option;
    }

    /**
     * Method takes in data to add bed individually
     */
    public void addBed(){
        System.out.println("Which room would you like to add a bed to?");
        int option = getIntOption();

        if(myListR.findRoom(option) != null){
            this.addBeds(option);
        }
        else{
            optionError();
        }
    }

    /**
     * Method that gets property id, then gets the revenue for it
     */
    public void getPropertyRevenue(){
        System.out.println("Which property would you like to see the revenue on?");
        int option = getIntOption();
        int revenue = 0;
        if(myListP.findProperty(option) != null){
            MyObject<Room> [] rooms = myListR.roomsInproperty(option);
            for (int j = 0; j < rooms.length; j++) {
                if (rooms[j] != null) {
                    revenue = revenue + myListB.getRoomRev(rooms[j].getCurrent().getId());
                }
            }
        }
        System.out.println("The revenue for property " + option + " is: " + revenue);
    }

    /**
     * Method to add rooms indvidually
     */
    public void addRoom(){
        System.out.println("Which property would you like to add room to?");
        int option = getIntOption();

        if(myListP.findProperty(option) != null) {
            this.addRooms(option);
        }
        else{
            optionError();
        }
    }

    /**
     * Method to run menu to remove things
     */
    public void runRemoveMenu(){
        int option = removeMenu();
        switch(option){
            case 1:
                this.removeStudent();
                this.runStart();
                break;

            case 2:
                this.removeProperty();
                this.runStart();
                break;

            case 3:
                this.removeRoom();
                this.runStart();
                break;

            case 4:
                this.removeBed();
                this.runStart();
                break;

            default:
                optionError();
                break;
        }
    }

    /**
     * Menu used to select things to move
     * @return option selected
     */
    public int removeMenu(){

        int option;
        System.out.println("What would you like to remove");
        System.out.println(" 1) Remove Student");
        System.out.println(" 2) Remove Property");
        System.out.println(" 3) Remove Room");
        System.out.println(" 4) Remove Bed");

        option = 0;
        while(option < 1 || option > 4){
            option = getIntOption();
            if(option < 1 || option > 4){
                this.optionError();
            }
        }
        return option;
    }

    /**
     * Method which gets id of bed, checks if valid and sends id to be removed in mylist
     */
    public void removeBed(){
        int id;
        MyObject<Bed> bed;
        System.out.println("Please give ID of the bed you wish to remove");
        id = getIntOption();
        bed = myListB.findBed(id);
        if(bed == null){
            System.out.println("Sorry no ID match");
        }
        else{
            myListB.removeObject(bed);
            System.out.println("The bed has been removed");
            System.out.println(myListB.viewBeds());
        }
    }

    /**
     * Method which gets id of students, checks if valid and sends id to be removed
     */
    public void removeStudent() {
        int id;
        MyObject<Student> student;
        System.out.println("Please give ID of student you wish to remove");
        id = getIntOption();
        student = myListS.findStudent(id);
        if (student == null) {
            System.out.println("Sorry no ID match");
        } else {
            myListS.removeObject(student);
            System.out.println("The student has been removed");
            System.out.println(myListS.viewStudents());
        }
    }

    /**
     * Method which gets id of rooms, checks if valid and sends id to be removed
     */
    public void removeRoom(){
        int id;
        MyObject<Room> room;
        System.out.println("Please give ID of room you Wish to remove");
        id = getIntOption();
        room = myListR.findRoom(id);
        if(room == null){
            System.out.println("Sorry no ID match");
        }
        else{
            myListR.removeObject(room);
            System.out.println("The room has been removed");
            System.out.println(myListR.viewRooms());
        }
    }

    /**
     * Method that used to take in data for property then sends to mylist
     * to be added
     */
    public void addProperty(){
        getStringOption();
        System.out.println("Please insert address");
        String address = getStringOption();

        System.out.println("How far is it from WIT");
        double distance = getDoubleOption();

        System.out.println("How many parking spaces?");
        int parking = getIntOption();


        int id = myListP.idGen();
        this.addRooms(id);
        myListP.addObject(new Property(address, parking, distance, id));

    }


    /**
     * Method that used to take in data for room then sends to mylist
     * to be added
     */
    public void addRooms(int propertyId) {
        System.out.println("How many rooms would you like to add?");
        int option = getIntOption();
        for (int i = 0; i < option; i++) {
            int property = propertyId;
            int level = runFloor();
            int id = myListR.idGen();
            boolean enSuit = runisEnSuit();
            this.addBeds(id);
            myListR.addObject(new Room(level, enSuit, property, id));
        }

    }

    /**
     * runs isensuit method
     * @return boolean for the enSuite variable
     */
    public boolean runisEnSuit(){
        int option = isEnSuit();
        boolean isEnSuit = false;

        switch (option){
            case 1:
                isEnSuit = true;
                break;
            case 2:
                isEnSuit = false;
                break;
            default:
                optionError();
                break;
        }
        return  isEnSuit;
    }

    /**
     * menu for ensuit
     * @return Int of the option selected
     */
    public int isEnSuit(){
        System.out.println("Is there an En Suit?");
        System.out.println(" 1) Yes");
        System.out.println(" 2) No");
        int option = 0;
        while(option < 1 || option > 2){
            option = getIntOption();
            if(option < 1 || option > 2){
                this.optionError();
            }
        }
        return option;
    }


    /**
     * adding bed to a certin room
     * @param roomId
     */
    public void addBeds(int roomId){
            System.out.println("How many bed in this room?");
            int option = getIntOption();
            int bed = 1;
            for(int i = 0; i < option; i++){
            int room = roomId;
            String type = this.runType();
            if(type == "Bunkbed"){
                bed = 2;
            }
            int student = 0;
            System.out.println("What is the cost per week?");
            int cost = getIntOption();
            for(int j = 0; j < bed; j++) {
                int id = myListB.idGen();
                myListB.addObject(new Bed(id, student, cost, type, room));
            }
        }
    }

    /**
     * runs menu for floor select
     * @return int option selected
     */
    public int runFloor(){
        int floor = 0;
        int option = floorMenu();
        switch (option){
            case 1:
                floor = 0;
                break;
            case 2:
                floor = 1;
                break;
            case 3:
                floor = 2;
                break;
            default:
                optionError();
        }
        return floor;
    }

    /**
     * menu to select floor
     * @return option selected
     */
    public int floorMenu(){
        System.out.println("What floor is the room on?");
        System.out.println(" 1) Ground floor");
        System.out.println(" 2) First floor");
        System.out.println(" 3) Second floor");
        int option = 0;
        while(option < 1 || option > 3){
            option = getIntOption();
            if(option < 1 || option > 3){
                this.optionError();
            }
        }
        return option;
    }

    /**
     * runs menu to select bed type
     * @return type of bed
     */
    public String runType(){
        int option = typeMenu();
        String str;
        switch (option){
            case 1:
                str = "Single";
                break;
            case 2:
                str = "Double";
                break;
            case 3:
                str = "Bunkbed";
                break;
            default:
                this.optionError();
                str = "Undefined";
                break;
        }
        return str;
    }

    /**
     * menu to select type
     * @return int option
     */
    public int typeMenu(){
        System.out.println("What kind of bed is it?");
        System.out.println(" 1) Single");
        System.out.println(" 2) Double");
        System.out.println(" 3) Bunkbed");
        int option = 0;
        while(option < 1 || option > 3){
            option = getIntOption();
            if(option < 1 || option > 3){
                this.optionError();
            }
        }
        return option;
    }

    /**
     * Method used to remove property
     */
    public void removeProperty(){
        getStringOption();
        System.out.println("Please give the id of the property you would like to remove");
        int option = getIntOption();
        MyObject<Property> property = myListP.findProperty(option);
        if(property == null){
            System.out.println("There is no Property with that id");
        }
        else{
            this.checkBeds(property.getCurrent().getId());
            myListP.removeObject(property);
            myListR.removeRoomsInProperty(property.getCurrent().getId());
        }
    }

    /**
     * removes rooms in property
     * @param id
     */
    public void checkBeds(int id){
        int property = id;
        MyObject<Bed> bed = myListB.head;
        MyObject<Room> room = myListR.head;
        while(room.getNext() != null){
            if(room.getCurrent().getProperty() == property){
            while(bed.getNext() !=null) {
                if(bed.getCurrent().getRoomId() == room.getCurrent().getId()) {
                    myListB.removeObject(bed);
                    }
                bed = bed.getNext();
                }
            }
            room = room.getNext();
        }

    }

    /**
     * Runs menu used for search methods
     */
    public void runSearchMenu(){
        int option = seachMenu();

        switch (option){
            case 1:
                System.out.println(myListB.listFreeBed());
                getStringOption();
                this.runStart();
                break;

            case 2:
                System.out.println("Max price");
                int cost = getIntOption();
                System.out.println(myListB.searchByCost(cost));
                getStringOption();
                this.runStart();
                break;

            case 3:
                this.searchByType();
                getStringOption();
                this.runStart();
                break;

            case 4:
                this.searchByFloor();
                this.runStart();
                break;

            case 5:
                this.searchByEnSuite();
                this.runStart();
                break;

            case 6:
                this.searchByParking();
                this.runStart();
                break;

            case 7:
                this.searchByDistance();
                this.runStart();
                break;

            default:
                optionError();
                break;
        }
    }

    /**
     * menu for search methods
     * @return optoin selected
     */
    public int seachMenu(){
        int option;
    System.out.println("Please select an option");
    System.out.println(" 1) All free beds");
    System.out.println(" 2) Search by cost");
    System.out.println(" 3) Search by bed type");
    System.out.println(" 4) Search by Floor");
    System.out.println(" 5) Search by enSuite");
    System.out.println(" 6) Search by parking spaces");
    System.out.println(" 7) Seacth by distance from WIT");

        option = 0;
        while(option < 1 || option > 7){
            option = getIntOption();
            if(option < 1 || option > 7){
                this.optionError();
            }
        }
        return option;
    }

    /**
     * Searches beds based on type
     */
    public void searchByType(){
        int option = getBedType();
        String type = "Single";

        if(option == 1){
            type = "Single";
        }
        else if(option == 2){
            type = "Double";
        }
        else if(option == 3){
            type = "Bunkbed";
        }
        else{
            optionError();
        }

        System.out.println(myListB.searchByType(type));
    }

    /**
     * menu to select bed type wanted
     * @return option selsected
     */
    public int getBedType(){
        int option;
        System.out.println("Which bed type do you want?");
        System.out.println(" 1) Single");
        System.out.println(" 2) Double");
        System.out.println(" 3) Bunkbed");
        option = 0;
        while(option < 1 || option > 3){
            option = getIntOption();
            if(option < 1 || option > 3){
                this.optionError();
            }
        }
        return option;
    }

    /**
     * Searches for beds based on what floor they are on
     */
    public void searchByFloor(){
        int option;
        System.out.println("Which floor would you like? (1-3)");
        option = 0;
        while(option < 1 || option > 3){
            option = getIntOption();
            if(option < 1 || option > 3){
                this.optionError();
            }
        }
        if(option == 1){
            option = 0;
        }
        else if(option == 2){
            option = 1;
        }
        else{
            option = 2;
        }
        MyObject<Room>[] rooms = myListR.findRoomsOnLevel(option);
        for(int k = 0; k < rooms.length; k++) {
            if(rooms[k] != null) {
                int option2 = rooms[k].getCurrent().getId();
                myListB.findBedWithRoomID(option2);
            }
        }
    }

    /**
     * Searches beds that have or don't have ensuites
     */
    public void searchByEnSuite(){
        boolean option = runWantEnSuite();
        MyObject<Room>[] rooms = myListR.findEnSuites(option);
        for(int k = 0; k < rooms.length; k++) {
            if(rooms[k] != null) {
                int option2 = rooms[k].getCurrent().getId();
                myListB.findBedWithRoomID(option2);
            }
        }
    }

    /**
     * runs menu to select if you want to search beds with or without ensuites
     * @return boolean to select if you want an ensuite
     */
    public boolean runWantEnSuite(){
        int option = wantEnSuite();
        boolean wantEnSuite = false;

        if(option == 1){
            wantEnSuite = true;
        }
        else if(option == 2){
            wantEnSuite = false;
        }
        else{
            optionError();
        }
        return wantEnSuite;
    }

    /**
     * menu to select if you want to search beds with or without ensuites
     * @return option selected
     */
    public int wantEnSuite(){
        int option;
        System.out.println("Do you want an En Suite");
        System.out.println(" 1) Yes");
        System.out.println(" 2) No");
        option = 0;
        while(option < 1 || option > 2){
            option = getIntOption();
            if(option < 1 || option > 2){
                optionError();
            }
        }
        return option;
    }

    /**
     * Searches for beds based on parking needed
     */
    public void searchByParking() {
        System.out.println("How much parking do you need?");
        int option = getIntOption();

        MyObject<Property>[] properties = myListP.findPropertiesWithParking(option);
        for (int k = 0; k < properties.length; k++) {
            if (properties[k] != null) {
                MyObject<Room>[] rooms = myListR.roomsInproperty(properties[k].getCurrent().getId());
                for (int j = 0; j < rooms.length; j++) {
                    if (rooms[j] != null) {
                        int option2 = rooms[j].getCurrent().getId();
                        myListB.findBedWithRoomID(option2);
                    }
                }
            }
        }
    }

    /**
     * Searches bed based on distance to wit
     */
    public void searchByDistance(){
        System.out.println("Max distance from College");
        double option = getDoubleOption();
       MyObject<Property>[] properties = myListP.findPropertiesWithinDistance(option);
        for (int k = 0; k < properties.length; k++) {
            if (properties[k] != null) {
                MyObject<Room>[] rooms = myListR.roomsInproperty(properties[k].getCurrent().getId());
                for (int j = 0; j < rooms.length; j++) {
                    if (rooms[j] != null) {
                        int option2 = rooms[j].getCurrent().getId();
                        myListB.findBedWithRoomID(option2);
                    }
                }
            }
        }
    }

    /**
     * runs other meun
     */
    public void runOther(){
        int option = this.other();

        switch (option){
            case 1:
                String fileName = "src/properties.csv";
                loadCSV(fileName);
                this.runStart();
                break;

            case 2:
                this.exit();
                break;

            default:
                optionError();
                break;
        }
    }

    /**
     * Other meun
     * @return option selected
     */
    public int other(){
        int option;
        System.out.println(" 1) Load CSV");
        System.out.println(" 2) Exit");
        option = 0;
         while(option < 1 || option > 2){
            option = getIntOption();
             if(option < 1 || option > 2){
                 optionError();
             }
         }
         return option;
    }

    /**
     * Exits program
     */
    public void exit(){

        return;

    }

    //utility funcions
    /**
     * Method to get a String with scanner
     * @return returns The String that was inputed
     */
    private String getStringOption() {
        System.out.print("> ");
        String text = input.nextLine();
        return text;
    }

    /**
     * Method to get double with scanner
     * @return returns The Double that was inputed
     */
    private double getDoubleOption(){
        System.out.println("> ");
        double option = input.nextDouble();
        return option;
    }

    /**
     * Method to get int with scanner
     * @return returns The intager that was inputed
     */
    private int getIntOption(){
        System.out.println("> ");
        int option = input.nextInt();
        return option;
    }


    /**
     * Method that prints error message when invalid option is selected
     */
    public void optionError(){

        System.out.println("Invalid option selected");
    }


    /**
     * Method to load csv files
     * @param file
     */
    public void loadCSV(String file){
        File f=new File(file);

        try {
            FileInputStream fis = new FileInputStream  (f);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            String str;

            do {
                str = br.readLine();
                if(str!=null) {
                    System.out.println(str);

                    String[] tokens = str.split(",");
                    System.out.println(tokens.length);
                    String address = tokens[0];
                    int parking = Integer.parseInt(tokens[1]);
                    double distance = Double.parseDouble(tokens[2]);
                    int propertyUID = myListP.idGen();
                    myListP.addObject(new Property(address, parking, distance, propertyUID));
                    System.out.println("Property added");
                    int i = 3;
                    int roomCount = 0;
                    int roomUID = myListR.idGen();
                    while(i  < tokens.length){
                        if(tokens[i].equals("RoomES") || tokens[i].equals("RoomNES")) {
                            int level = Integer.parseInt(tokens[i+1]);
                            boolean enSuite;
                            if(tokens[i].equals("RoomES")) {
                                enSuite = true;
                            }
                            else {
                             enSuite = false;
                            }
                            myListR.addObject(new Room(level, enSuite, propertyUID, roomUID + roomCount));
                             i+=2;
                            roomCount +=1;
                        }
                        else if((tokens[i].equals("single")) || (tokens[i].equals("double")) || (tokens[i].equals("bunkbed"))){
                            String type = tokens[i];
                            int cost = Integer.parseInt(tokens[i+1]);
                            int bedType = 1;
                            if(tokens[i].equals("bunkbed")){
                                bedType = 2;
                            }
                            for(int j = 0; j < bedType; j +=1) {
                                int bedUID = myListB.idGen();
                                myListB.addObject(new Bed(bedUID, 0, cost, type, roomUID + (roomCount - 1)));
                            }
                            i+=2;
                        }
                    }
                }

            }while(str!=null);

            br.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

