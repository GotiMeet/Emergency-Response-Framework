/*
 * Formate of the file "helpingTeam.csv"
 * ID,PassWord,MobileNo,Address,Available members,members at site,Deaths,Injured
 */


import java.util.Scanner;

class HelpingTeam implements Department {

    
    public void edit_data(String ID){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter: ");
        System.out.println("1 for Available members ");
        System.out.println("2 for members at site");
        System.out.println("3 for Deaths ");
        System.out.println("4 for injured ");

        int choice=sc.nextInt();
        sc.nextLine() ; ///////////////// clear buffer
        filehandling fh = new filehandling();


        if (choice == 1) {
           System.out.println("Enter new Number of Available members   :");
           String replaceWord = sc.nextLine();
           fh.replaceWordInCSV("helpingTeam.csv","5",ID,replaceWord);
            
        }
        else if (choice == 2) {
            System.out.println("Enter new Number of members at site    :");
           String replaceWord = sc.nextLine();

           fh.replaceWordInCSV("helpingTeam.csv","6",ID,replaceWord);
            
        }
        else if (choice == 3) {
        System.out.println("Enter new Number of Deaths     :");
           String replaceWord = sc.nextLine();
           fh.replaceWordInCSV("helpingTeam.csv","7",ID,replaceWord);
            
        }
        else if (choice == 4) {
        System.out.println("Enter new Number of injured     :");
           String replaceWord = sc.nextLine();
           fh.replaceWordInCSV("helpingTeam.csv","8",ID,replaceWord);
            
        }
    }

    
    public void analyse_data(String ID){
        filehandling fh = new filehandling();

        System.out.println("Number of Available members    : " + fh.readData(5,"helpingTeam.csv",ID));
        System.out.println("Number of members at site      : " + fh.readData(6,"helpingTeam.csv",ID));
        System.out.println("Number of Deaths               : " + fh.readData(7,"helpingTeam.csv",ID));
        System.out.println("Number of injured              : " + fh.readData(8,"helpingTeam.csv",ID));

    }


    void showHelpingTeam(String ID){

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
            nearestEmergancy("helpingTeam.csv",ID);
        }
        else{
           
            System.out.println("Invalid Input");
            
        }

    }
    
    
}


