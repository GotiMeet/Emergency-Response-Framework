import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Signup {

    private String genId(int n) {

        String ID = (char) (n + 48) + "0001"; //////////////////////////// generate ID According to user
        int temp = Integer.parseInt(ID);
        int counter = 0;
        File dataFile = null;
        try {
            switch (n) {
                case 1:
                    dataFile = new File("normalCitizen.csv");
                    break;
                case 2:
                    dataFile = new File("hospital.csv");
                    break;
                case 3:
                    dataFile = new File("police.csv");
                    break;
                case 4:
                    dataFile = new File("goverment.csv");
                    break;
                case 5:
                    dataFile = new File("helpingTeam.csv");
                    break;
            }
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                counter++;
            }
            temp += counter;
            ID = Integer.toString(temp);
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.err.println(e);
        }
        return ID;
    }

    // Funtion which will be called for SignUp

    void signup() {

        Scanner s = new Scanner(System.in);

        System.out.println("Please enter: ");
        System.out.println("1 for Signup as a normal citizen");
        System.out.println("2 for Signup as a member of Hospital department");
        System.out.println("3 for Signup as a member of Goverment department");
        System.out.println("4 for Signup as a member of Helping Team");
        int choice = s.nextInt();

        while (choice < 1 || choice > 4) { /////////////////////////// validate choice
            System.out.println("Please enter valid choice");
            choice = s.nextInt();
        }

        System.out.println("Please enter your name"); ///////////////////////////// name
        s.nextLine(); // To flush buffer
        String name = s.nextLine();
        while (name == null) {
            System.out.println("Please enter your name");
            name = s.nextLine();
        }

        System.out.println("Please enter your email"); ///////////////////////////// email
        String email = s.nextLine();

        System.out.println("Please enter your Address\n(Note : As a special department member please enter your department's address.)"); ///////////////////////////// Address
        System.out.println("(Note : Address format [A-Z][0-9], ie. A1 )");
        String Address = s.nextLine();

        System.out.println("Please enter your Mobile Number"); ///////////////////////////// Mobile number
        String MobileNo = s.nextLine();
        boolean flag = false;
        while (flag == false) {
            if (MobileNo.length() == 10) {
                flag = true;
                for (int i = 0; i < 10; i++) {
                    if ((MobileNo.charAt(i) - '0') < 0 || (MobileNo.charAt(i) - '0') > 9) {
                        flag = false;
                        break;
                    }
                }
            } else if (flag) {
                System.out.println("Please enter valid Mobile Number");
                MobileNo = s.nextLine();
            }
        }

        File dataFile = null; /////////////////////////////// cheking wether mobile number is repeating or not
        try {
            switch (choice) {
                case 1:
                    dataFile = new File("normalCitizen.csv");
                    break;
                case 2:
                    dataFile = new File("hospital.csv");
                    break;
                
                case 3:
                    dataFile = new File("goverment.csv");
                    break;
                case 4:
                    dataFile = new File("helpingTeam.csv");
                    break;
            }
            Scanner sc = new Scanner(dataFile);
            flag = false;
            while (sc.hasNextLine()) {
                flag = true;
                String mobile = sc.nextLine();
                int j = 0, k = 0;
                while (k != 2) {
                    if (mobile.charAt(j) == ',') {
                        k++;
                    }
                    j++;
                }
                for (int i = 0; i < 10; i++, j++) {
                    if ((MobileNo.charAt(i) - '0') != (mobile.charAt(j) - '0')) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.err.println(e);
        }
        if (flag) {
            System.out.println("You have already made an account");
            return;
        }

        String password = "";
        if (choice > 1 && choice < 5) { //////////////////////////// password for special person
            System.out.println("Please set a password");
            password = s.nextLine();
        }

        String ID = genId(choice); ///////////////////////////// Showing ID to user 
        System.out.println("Please remember your ID");
        System.out.println("Your ID is:" + ID);

        //////////////////////////////////////////////////// storing all data in to files

        filehandling saveData = new filehandling(choice, Address, MobileNo, ID, password);
        saveData.saveSignUpData();

        return;

    }

}
