/*
 * format of data in normalCitizen file
 * ID,,MobileNo.,Em. Address,Address,Emergancy,No. people in emergancy
 */

import java.util.*;

 class NormalCitizen {
    private String ID;
    private int choice;

    NormalCitizen(String ID) {
        this.ID = ID;
    }

     void showNormalCitizen() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter: ");
        System.out.println("1 for Emergancy");
        System.out.println("2 for Forcasting");
        System.out.println("3 for Goverment Notics");

        choice = sc.nextInt();
        sc.nextLine() ; ///////////////// clear buffer

        if (choice == 1) {
            System.out.println("Who is in emergancy?\nYou or Other person");
            System.out.println("Please enter 1 if you are in emergancy and 2 if other in emergancy");
            choice = sc.nextInt();
            System.out.println("How many are there in emergancy?");
            int noPeople = sc.nextInt();


            filehandling fh = new filehandling();
            fh.replaceWordInCSV("normalCitizen.csv","7",ID,Integer.toString(noPeople));
            



            sc.nextLine(); ///////////////// clear buffer
            String Address;
            if (choice == 1) {
                try {
                    filehandling fh1 = new filehandling();
                    Address = fh1.readData(5, "normalCitizen.csv", ID);
                    System.out.println(Address);
                    fh1.replaceWordInCSV("normalCitizen.csv","4",ID,Address);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println(e);
                }

            } else {
                System.out.println("Enter the address of emergancy spot");
                filehandling fh2 = new filehandling();
                Address = sc.nextLine();
                fh2.replaceWordInCSV("normalCitizen.csv","4",ID,Address);
            }

            System.out.println("Please enter: ");
            System.out.println("1 for Flood");
            System.out.println("2 for Fire");
            System.out.println("3 for Earthquake");
            System.out.println("4 for Pendemic");
            System.out.println("5 for riot");

            choice = sc.nextInt(); /////////////////// choice of emergancy
            sc.nextLine(); ///////////////// clear buffer
                                                         

            filehandling fh3 = new filehandling();
            
            switch (choice) {
                case 1:
                fh3.replaceWordInCSV("normalCitizen.csv","6",ID,"Flood");
                    break;
                case 2:
                fh3.replaceWordInCSV("normalCitizen.csv","6",ID,"Fire");
                    break;
                case 3:
                fh3.replaceWordInCSV("normalCitizen.csv","6",ID,"Earthquake");
                    break;
                case 4:
                fh3.replaceWordInCSV("normalCitizen.csv","6",ID,"Pendemic");
                    break;
                case 5:
                fh3.replaceWordInCSV("normalCitizen.csv","6",ID,"riot");
                    break;
            
            }


            System.out.println("Your emergancy reported succsessfuly ");
        }
        else if (choice == 2) {
            System.out.println("Welcome to forcast system");
            System.out.println("Please enter the address to check alerts");
            String Address = sc.nextLine();
            Random rand = new Random();
            int n = rand.nextInt(4);
            if (n==0) {
                System.out.println(Address + " is under Green Alert");
            }
            if (n==1) {
                System.out.println(Address + " is under Yellow Alert");
            }
            if (n==2) {
                System.out.println(Address + " is under Orange Alert");
            }
            if (n==3) {
                System.out.println(Address + " is under Red Alert");
            }
        }
        else{
            filehandling fh4 = new filehandling();
            if (fh4.readData(3,"goverment.csv","30001") == "0") {
                System.out.println(fh4.readData(4,"goverment.csv","30001"));
            }
            else{
                System.out.println("Sorry for inconvenience");
                System.out.println("Survey is going on!");
                System.out.println("Data will be provided soon..");
            }
        }
    }
}