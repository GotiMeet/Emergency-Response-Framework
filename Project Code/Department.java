import java.io.File;
import java.util.Scanner;

interface Department {

    void edit_data(String ID);


    

    void analyse_data(String ID);

    

    // void emergancy(String filename, String ID);

     default void nearestEmergancy(String filename, String ID) {
        try{
        File citizenData = new File("normalCitizen.csv");
        File departmentData = new File(filename);
        filehandling fh = new filehandling();
        Scanner sCitizen = new Scanner(citizenData);
        
        int cCounter = 0;
        int dCounter = 0;
        int dminID=0;
        
        while (sCitizen.hasNextLine()) {
            dCounter = 0;
            String cline = sCitizen.nextLine();
            cCounter++;
            int k = 0, j = 0;
            while (k != 4 - 1) {
                if (cline.charAt(j) == ',') {
                    k++;
                }
                j++;
            }
            
            k = 0;
            while (cline.charAt(j + k) != ',') {
                k++;
            }
            
            
            String AddCitizen = cline.substring(j, j + k);
            
            int Xc = (AddCitizen.charAt(0)) - 64;
            int Yc =(AddCitizen.charAt(1)) - 48;
            
            
            double min = Integer.MAX_VALUE;  //////////  seting minimum value
            
            Scanner sDepartment = new Scanner(departmentData);

            while (sDepartment.hasNextLine()) {
                String dline = sDepartment.nextLine();
                dCounter++;
                int l = 0, m = 0;
                
                while (m != 4 - 1) {
                    if (dline.charAt(l) == ',') {
                        m++;
                    }
                    l++;
                }
    
                m = 0;
                while (dline.charAt(l + m) != ',') {
                    m++;
                }

    
                String AddDepartment = dline.substring(l, l + m);



                int Xd = (AddDepartment.charAt(0)) - 64;
                int Yd =(AddDepartment.charAt(1)) - 48;

                double distance = Math.sqrt((Xc-Xd)*(Xc-Xd) + (Yc-Yd)*(Yc-Yd));
                
                if (distance < min) {
                    min = distance;
                    dminID = dCounter;
                }
            }

            sDepartment.close();

            if (dminID ==Integer.parseInt(ID.substring(1, ID.length()))) {

                System.out.println("ID of citizen is "+fh.readData(1,"normalCitizen.csv","1"+Integer.toString(cCounter))+" and Address is "+fh.readData(4,"normalCitizen.csv","1"+Integer.toString(cCounter)) + " and estimeted people is " + fh.readData(7,"normalCitizen.csv","1"+Integer.toString(cCounter)) );

                
            }
            
        }
        sCitizen.close();
    }catch(Exception e){
        System.err.println(e);
    }

    }

    
    
}
