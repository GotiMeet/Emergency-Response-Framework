import java.util.*;

class Login {
    void login() {
        try {
            filehandling fileData = new filehandling();

            String ID, password = "", filename = null;
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID : ");

            ID = sc.nextLine();

            ////////////////////////////////////////////////////////// selcting file

            switch (Integer.parseInt(ID.substring(0, 1))) 
            {
                case 1:
                    filename = "normalCitizen.csv";
                    break;

                case 2:
                    filename = "hospital.csv";
                    break;
                
                case 3:
                    filename = "goverment.csv";
                    break;

                case 4:
                    filename = "helpingTeam.csv";
                    break;
            }

            // Password request for member of special department

            if (Integer.parseInt(ID.substring(0, 1)) != 1) {

                System.out.print("\nPassword   : ");
                password = sc.nextLine();

            }

            // Password and ID confirmation for user

            if (ID.equals(fileData.readData(1, filename, ID)) && password.equals(fileData.readData(2, filename, ID))) {

                

                switch (Integer.parseInt(ID.substring(0, 1)))/////////////////////////////////////// selcting class
                {
                    case 1:
                        NormalCitizen nc = new NormalCitizen(ID);
                        nc.showNormalCitizen();
                        break;

                    case 2:

                        Hospital hp = new Hospital();
                         hp.showHospital(ID);
                        break;
                    
                    case 3:
                        Goverment gov = new Goverment();
                        gov.showGoverment();
                        break;

                    case 4:
                        HelpingTeam hpt = new HelpingTeam();
                        hpt.showHelpingTeam(ID);
                        break;
                }

            } else {  // ID or Password incorrect

                System.out.println(" ID or Password is incorrect");
                System.out.println(" Or you have not any account");
                login();

                return;

            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }
}