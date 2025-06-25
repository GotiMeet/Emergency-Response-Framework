import java.util.*;
import java.io.*;

public class emergancyResponseFramwork {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Signup signupPersion = new Signup();
        Login loginPersion = new Login();

        System.out.println();
        System.out.println("Welcome to Emergancy service.");
        int choice ;
       

        ///////////////////////////////////////////////////////////////////////////////// login || Sign Up

        do {
            System.out.println("Please enter 0 for Login, 1 for Sign Up and any other number to logout");
            choice = s.nextInt();

            //////////////////////////////////////////////////////////////////////////////// login

            if (choice == 0) {
                loginPersion.login();
            }

            //////////////////////////////////////////////////////////////////////////////// Sign Up

            else if (choice == 1) {
                signupPersion.signup();
                System.out.println("Your Sign Up proccess is successfully completed");
            }

        } while (choice == 0 || choice == 1);

        //////////////////////////////////////////////////////////////////////////////// logout (end of code)

        System.out.println("You are logged out");

    }
}
