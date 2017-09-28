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
        System.out.println(" 5) Veiw");
        option = 0;

        while(option < 1 || option > 5){
            option = getIntOption();
            if(option < 1 || option > 5){
                this.optionError();
            }
        }
        return option;

    }

    public void runStart(){
        int option = this.start();

        switch(option){
            case 1:
                //add student
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
                //view
                break;
        }
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
