/*
 * format of data in goverment file
 * ID,PassWord,Authentication permission,Advisory
 */

import java.io.File;
import java.util.Scanner;

 class Goverment {
    private void AnalyseData() {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter: ");
        System.out.println("1 for Hospital");
        System.out.println("2 for Hepling Team");
        System.out.println("3 for Emergancy");

        int choice = s.nextInt();
        s.nextLine();

        filehandling fh = new filehandling();

        try {

            if (choice == 1) {

                File f = new File("Hospital.csv");
                Scanner sc = new Scanner(f);
                int tempID = 0;
                while (sc.hasNextLine()) {
                    tempID++;
                }
                while (tempID != 0) {
                    String ID = "2" + Integer.toString(tempID);
                    System.out.println("Data of Hospital with ID   : " + fh.readData(1, "Hospital.csv", ID));
                    System.out.println("Number of Available bed    : " + fh.readData(5, "hospital.csv", ID));
                    System.out.println("Number of Admitted persion : " + fh.readData(6, "hospital.csv", ID));
                    System.out.println("Number of Deaths           : " + fh.readData(7, "hospital.csv", ID));
                    System.out.println("\n");
                }
                sc.close();

            } else if (choice == 2) {
                File f = new File("helpingTeam.csv");
                Scanner sc = new Scanner(f);
                int tempID = 0;
                while (sc.hasNextLine()) {
                    tempID++;
                }
                while (tempID != 0) {
                    String ID = "5" + Integer.toString(tempID);
                    System.out.println("Data of Helping Team with ID   : " + fh.readData(1, "helpingTeam.csv", ID));
                    System.out.println("Number of Available members    : " + fh.readData(5, "helpingTeam.csv", ID));
                    System.out.println("Number of members at site      : " + fh.readData(6, "helpingTeam.csv", ID));
                    System.out.println("Number of Deaths               : " + fh.readData(7, "helpingTeam.csv", ID));
                    System.out.println("Number of injured              : " + fh.readData(8, "helpingTeam.csv", ID));
                    System.out.println("\n");
                }
                sc.close();
            } else if (choice == 3) {
                File f = new File("Hospital.csv");
                Scanner sc = new Scanner(f);
                int tempID = 0;
                while (sc.hasNextLine()) {
                    tempID++;
                }
                while (tempID != 0) {
                    String ID = "1" + Integer.toString(tempID);
                    System.out.println("Persion's ID      : " + fh.readData(4, "normalCitizen.csv", ID));
                    System.out.println("Persion's Address : " + fh.readData(1, "normalCitizen.csv", ID));
                    System.out.println("Emergancy         :  " + fh.readData(6, "normalCitizen.csv", ID));

                    System.out.println("\n");
                }
                sc.close();
            } else {

                System.out.println("Invalid Input");

            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    private void AuthoriseData() {
        Scanner sc = new Scanner(System.in);

        filehandling fh = new filehandling();

        System.out.println("Please enter: ");
        System.out.println("1 for Authorise Data ");
        System.out.println("2 for Not Authorised Data");

        int choice = sc.nextInt();
        //sc.nextLine(); ///////////////// clear buffer
    

        if (choice == 1) {
           // System.out.println("Enter new Number of Available bed    :");
            //String replaceWord= choice;
            fh.replaceWordInCSV("goverment.csv","3","30001",Integer.toString(choice-1));
             
         }
         else if (choice == 2) {
            // System.out.println("Enter new Number of Admitted persion    :");
            //String replaceWord = choice;
 
            fh.replaceWordInCSV("goverment.csv","3","30001",Integer.toString(choice-1));
             
         }
    }

    private void ReleaseAdvisory() {
        Scanner sc = new Scanner(System.in);

        filehandling fh = new filehandling();

        System.out.println("Please enter Advisory: ");
        

        String choice = sc.nextLine();
       // sc.nextLine(); ///////////////// clear buffer
        fh.replaceWordInCSV("goverment.csv","4","30001",choice);
    

        
    }

    void showGoverment() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter: ");
        System.out.println("1 for Analyse Data");
        System.out.println("2 for Authorise Data");
        System.out.println("3 for Release Advisory");

        int choice = sc.nextInt();
        sc.nextLine(); ///////////////// clear buffer

        if (choice == 1) {
            AnalyseData();
        } else if (choice == 2) {
            AuthoriseData();
        } else if (choice == 3) {
            ReleaseAdvisory();
        } else {

            System.out.println("Invalid Input");

        }
        sc.close();
    }
}
