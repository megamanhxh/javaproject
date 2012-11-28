/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Mahdi Isa
 */
public class JavaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //create objects
        Scanner console = new Scanner(System.in);
        Scanner inFile = null;
        //create storage arrays
        String make[] = new String[100];
        String model[] = new String[100];
        String type[] = new String[100];
        int price[] = new int[100];
        int quantity[] = new int[100];
        int reorderPoint[] = new int[100];
        int computerID[] = new int[100];

        //create variables
        int counter = 0;
        String tmpString = null;
        int tmpInt = 0;
        int chosenMenu = 0;
        String pathFile = null;
        String userName = null;
        String password = null;

        /* ====================== WARNING ======================
         * ======= This is very high security warrning =========
         * ====================== WARNING ======================
         */

        // ============ creating default username ==============
        String adminUserName = "admin";
        String adminPassword = "admin123";
        String regularUserName = "user";
        String regularPassword = "user123";

        /* ====================== WARNING ======================
         * ======= This is very high security warrning =========
         * ====================== WARNING ======================
         */

        // -=-=-=-=-=-=-=-=- Start Application -=-=-=-=-=-=-=-=-
        //welcome screen
        System.out.println("======================================================\n"
                + "==  Welcome to Poly Software Solutions Application  ==\n"
                + "==  This application is used to convert paper data  ==\n"
                + "==  base system to software data base system.       ==\n"
                + "======================================================\n");


        //start loading the DSV file
        //prompt to user to enter the path of DSV file
        System.out.println("Please enter the path of the DSV data to import it into the application:");
        //store it into pathFile String
        pathFile = console.nextLine();

        //creatign File object from the pathFile
        File f = new File(pathFile);
        //checking if the file is exists or not
        if (!f.exists()) {
            error(1);
        } else if (!f.canRead()) {
            error(2);
        } else if (!f.isFile()) {
            error(3);
        } else {
            inFile = new Scanner(f).useDelimiter("\"*\"");
            System.out.print("\nFile has been founded!\n"
                    + "Loading the file .");
            //skiping then first line
            inFile.nextLine();

            while (inFile.hasNext()) {

                //make
                tmpString = inFile.next();
                make[counter] = tmpString;

                //skip tab
                inFile.next();

                //model
                tmpString = inFile.next();
                model[counter] = tmpString;

                //skip tab
                inFile.next();

                //type
                tmpString = inFile.next();
                type[counter] = tmpString;

                //skip tab
                inFile.next();

                //price
                tmpInt = inFile.nextInt();
                price[counter] = tmpInt;

                //skip tab
                inFile.next();

                //quantity
                tmpInt = inFile.nextInt();
                quantity[counter] = tmpInt;

                //skip tab
                inFile.next();

                //reorderPoint
                tmpInt = inFile.nextInt();
                reorderPoint[counter] = tmpInt;

                //skip tab
                inFile.next();

                //computerID
                tmpInt = inFile.nextInt();
                computerID[counter] = tmpInt;

                //skip tab and newline
                inFile.next();

                //loading progress
                System.out.print(".");

                //counter for the number of lines
                counter++;
            }
            //loading progress completed
            System.out.print(" done!");

            //print the number of Data that has been loaded from DSV file sucessfully
            System.out.println("\n\nThe application has loaded " + counter + " computer data.\n");
        }

        //prompt to user to enter his username
        System.out.println("Please enter your username ID:");

        //store it into username string
        userName = console.nextLine();

        //prompt to user to enter his password
        System.out.println("\nPlease enter your username Password:");

        //store it into username string
        password = console.nextLine();


        //start checking the username ID and password
        if (userName.equals(adminUserName)) {
            if (password.equals(adminPassword)) {
                //showing admin menu
                //creating variables
                boolean exit = false;

                menu(1);
                chosenMenu = console.nextInt();

                switch (chosenMenu) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        break;
                }
            } else {
                error(5);
            }
        } else if (userName.equals(regularUserName)) {
            if (password.equals(regularPassword)) {
                //showing user menu
                menu(0);
                chosenMenu = console.nextInt();
                switch (chosenMenu) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }

            } else {
                error(5);
            }
        } else {
            error(4);
        }


        // -=-=-=-=-=-=-=-=-= End Application =-=-=-=-=-=-=-=-=-

    }

    public static void menu(int arg) {

        switch (arg) {
            case 0:
                System.out.println("\nChoose one of the menu:\n"
                        + "1. Insert Data\n"
                        + "2. Modify Data\n"
                        + "3. Exit");
                break;
            case 1:
                System.out.println("\nChoose one of the menu:\n"
                        + "1. Insert Data\n"
                        + "2. View Data\n"
                        + "3. Modify Data\n"
                        + "4. Export Data\n"
                        + "5. Exit");
                break;
            default:
                break;
        }
    }

    public static void error(int arg) {
        switch (arg) {
            case 0:
                System.out.println("");
                break;
            case 1:
                System.out.println("Error (1): The application can’t found the file");
                System.out.println("Skiping loading DSV file");
                break;
            case 2:
                System.out.println("Error (2): The application can’t read the file, It is a readable?");
                System.out.println("Skiping loading DSV file");
                break;
            case 3:
                System.out.println("Error (3): The application can’t read the file, It is a directory?");
                System.out.println("Skiping loading DSV file");
                break;
            case 4:
                System.out.println("Error (4): username is incorrect.");
                break;
            case 5:
                System.out.println("Error (5): password is incorrect.");
                break;
            default:
                System.out.println("Error (X): There is unknown error, please contact with administrator.");
                break;
        }
    }
}
