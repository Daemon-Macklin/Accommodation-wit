/**
 * Driver Class
 *
 * @author Daemon-Macklin
 *
 */

import java.util.Scanner;

public class Driver {

    public Scanner input;

    public AccomApi accomApi;
    public StudentList studentList;

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
        this.accomApi = new AccomApi();
        this.studentList = new StudentList();
    }

    public void load(){
        //CSV LOADING
        this.runStart();
    }

    public int start(){
        int option;
        System.out.println("----Welcome to WIT accommodation service----");
        System.out.println("----Please select and option----");
        System.out.println(" 1) Add Student");
        System.out.println(" 2) Add Property");
        System.out.println(" 3) Add Room");
        System.out.println(" 4) Add Bed");
        System.out.println(" 5) View");
        System.out.println(" 6) Remove");
        option = 0;

        while(option < 1 || option > 6){
            option = getIntOption();
            if(option < 1 || option > 6){
                this.optionError();
            }
        }
        return option;

    }

    public void runStart(){
        int option = this.start();

        switch(option){
            case 1:
                this.addStudent();
                break;

            case 2:
                //add property
                break;

            case 3:
                // add room
                break;

            case 4:
                //add bed
                break;

            case 5:
                this.runViewMenu();
                break;

            case 6:
                this.runRemoveMenu();
                break;

            default:
                this.optionError();
                break;
        }
    }

    public void addStudent(){
        getStringOption();
        System.out.println("Name");
            String name = getStringOption();

        System.out.println("Gender");
            String gender = getStringOption();

        boolean hasCar = runCar();

        int id = studentList.idGen();
        studentList.addStudent(new Student(name, gender, hasCar, id));
        this.runStart();
    }

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

    public void runViewMenu(){
        int option = viewMenu();
        switch(option) {
            case 1:
                System.out.println(studentList.viewStudents());
                getStringOption();
                this.runStart();
                break;
            default:
                this.optionError();
                break;
        }
    }

    public int viewMenu(){
        int option;
        System.out.println("What would you like to view?");
        System.out.println(" 1) Students");

        option =0;
        while(option < 1 || option > 2){
            option = getIntOption();
            if(option < 1 || option > 2){
                this.optionError();
            }
        }
        return option;
    }

    public void runRemoveMenu(){
        int option = removeMenu();
        switch(option){
            case 1:
                this.removeStudent();
                break;

            case 2:
                //remove property
                break;

            case 3:
                //remove room
                break;

            case 4:
                //remove bed
                break;

            case 5:
                //remove student from bed
                break;

            default:
                optionError();
                break;
        }
    }

    public int removeMenu(){

        int option;
        System.out.println("What would you like to remove");
        System.out.println(" 1) Remove Student");
        System.out.println(" 2) Remove Property");
        System.out.println(" 3) Remove Room");
        System.out.println(" 4) Remove Bed");
        System.out.println(" 5) Remove Student from Bed");
        option = 0;
        while(option < 1 || option > 5){
            option = getIntOption();
            if(option < 1 || option > 5){
                this.optionError();
            }
        }
        return option;
    }

    public void removeStudent() {
        int id;
        StudentNode student;
        System.out.println("Please give ID of student you wish to remove");
        id = getIntOption();
        student = studentList.findStudent(id);
        if (student == null) {
            System.out.println("Sorry no ID match");
        } else {
            studentList.removeStudent(student);
            System.out.println("The student has been removed");
            System.out.println(studentList.viewStudents());
        }
        this.runStart();
    }

    //utility funcions
    /**
     * Method to get a String with scanner
     * @return
     */
    private String getStringOption() {
        System.out.print("> ");
        String text = input.nextLine();
        return text;
    }

    /**
     * Method to get double with scanner
     * @return
     */
    private double getDoubleOption(){
        System.out.println("> ");
        double option = input.nextDouble();
        return option;
    }

    /**
     * Method to get int with scanner
     * @return
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
}

