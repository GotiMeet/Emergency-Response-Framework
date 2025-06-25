import java.io.*;
import java.util.Scanner;

class filehandling {
    private int choice;
    private String filename, Address, MobileNo, ID, password;

    /////////////////////// cunstructor which will use in sign up
    
     filehandling(int choice, String Address, String MobileNo, String ID, String password) { 

        this.choice = choice;
        this.Address = Address;
        this.MobileNo = MobileNo;
        this.ID = ID;
        this.password = password;

        switch (choice) ///////////////////////////////////////////// selcting file
        {
            case 1:
                filename = "normalCitizen.csv";
                break;
            case 2:
                filename = "hospital.csv";
                break;
            case 3:
                filename = "police.csv";
                break;
            case 4:
                filename = "goverment.csv";
                break;
            case 5:
                filename = "helpingTeam.csv";
                break;
        }
    }

    filehandling() {       ///////////////////// default cunstructor to avoide error while making an obj without any parameter

    }

     void saveSignUpData() { ////////////////////////////////// save SignUp data in file
        try {

            BufferedWriter out = new BufferedWriter(
                    new FileWriter(filename, true));

            // Writing on output stream or data of user

            if(choice==1){         //////////  data of normal citizen
            out.write(ID + "," + password + "," + MobileNo + ",," + Address + ",,,,,,,,,,,,,,,@" + "\n");
            }
            else{      ///////// data of member of special department
                out.write(ID + "," + password + "," + MobileNo + "," + Address + ",,,,,,,,,,,,,,,@" + "\n");
            }
            // Closing the connection or file
            out.close();

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

    // function for reading perticular column of file

     String readData(int column, String filename, String ID) {
        try {
            File readFile = new File(filename);
            Scanner sc = new Scanner(readFile);
            ID = ID.substring(1, ID.length());
            int tempID = Integer.parseInt(ID);
            while (tempID != 1) {               /////////////////// move SC to the row which we want to read
                sc.nextLine();
                tempID--;
            }
            String line = sc.nextLine();
            int k = 0, j = 0;
            while (k != column - 1) {          //////////////////  geting desiered column indx
                if (line.charAt(j) == ',') {
                    k++;
                }
                j++;
            }

            k = 0;
            while (line.charAt(j + k) != ',') {       //////////////////   calculating column length
                k++;
            }
            sc.close();          ///////  close file

            return line.substring(j, j + k);      ///////////////////  returning the data written in the column

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

        return null;
    }

    // Function to edit data of perticular column

     void replaceWordInCSV(String fileName, String column, String ID, String replacement) {
        try {

            int columnNumber =  Integer.parseInt(column); 

            int rowNumber =  Integer.parseInt(ID.substring(1, ID.length()));  //////  get row number according to ID

            // Read the CSV file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder sb = new StringBuilder();
            int currentRow = 1;                       //////////// Start from the first row
            while ((line = reader.readLine()) != null) {

                if (currentRow == rowNumber) {

                    String[] parts = line.split(",");  ///////// spliting all columns in line
                    if (columnNumber <= parts.length) {      ////////////// Check if column number is within bounds to avoid indxOutOfBound Exception

                        parts[columnNumber - 1] = replacement;   /////// replace the data
                        line = String.join(",", parts)+",";

                    } else {

                        System.err.println("Column number out of range.");
                        reader.close();
                        return;
                    }
                }
                sb.append(line).append("\n");
                currentRow++;
            }
            reader.close();       ///////// closig file

            // Write the updated data back to the CSV file(Re-write whole file)
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(sb.toString());
            writer.close();

           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
