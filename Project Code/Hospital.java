/*
 * format of data in hospital file
 * ID,PassWord,MobileNo.,Address,AvailableBed,OccupiedBed,No.Dead
 */

import java.util.Scanner;

public class Hospital implements Department {

    
    public void edit_data(String ID){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter: ");
        System.out.println("1 for Available bed ");
        System.out.println("2 for Admitted persion");
        System.out.println("3 for Deaths ");

        int choice=sc.nextInt();
        sc.nextLine() ; ///////////////// clear buffer
        filehandling fh = new filehandling();


        if (choice == 1) {
           System.out.println("Enter new Number of Available bed    :");
           String replaceWord = sc.nextLine();
           fh.replaceWordInCSV("hospital.csv","5",ID,replaceWord);
            
        }
        else if (choice == 2) {
            System.out.println("Enter new Number of Admitted persion    :");
           String replaceWord = sc.nextLine();

           fh.replaceWordInCSV("hospital.csv","6",ID,replaceWord);
            
        }
        else if (choice == 3) {
            System.out.println("Enter new Number of Deaths     :");
           String replaceWord = sc.nextLine();
           fh.replaceWordInCSV("hospital.csv","7",ID,replaceWord);
            
        }

        


    }

    
    public void analyse_data(String ID){
        filehandling fh = new filehandling();

        System.out.println("Number of Available bed    : " + fh.readData(5,"hospital.csv",ID));
        System.out.println("Number of Admitted persion : " + fh.readData(6,"hospital.csv",ID));
        System.out.println("Number of Deaths           : " + fh.readData(7,"hospital.csv",ID));

    }


     void showHospital(String ID){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter: ");
        System.out.println("1 for Edit Data");
        System.out.println("2 for Analyse Data");
        System.out.println("3 for Emergancy");

        int choice = sc.nextInt();
        sc.nextLine() ; ///////////////// clear buffer

        if (choice == 1) {
            edit_data(ID);
        }
        else if (choice == 2) {
            analyse_data(ID);
        }
        else if (choice == 3) {
            nearestEmergancy("hospital.csv",ID);
        }
        else{
           
            System.out.println("Invalid Input");
            
        }

    }
    
    
}
