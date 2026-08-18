package src;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Avaj_Luncher {
    
    public static void main(String[] args) {
        
        File myObj = new File(args[0]);
        // System.exit(0);
        try (Scanner myReader = new Scanner(myObj)) {
          /*
              The first line of the file contains a positive integer. This number represents how many
              times the simulation runs. In our case, this will be the number of times a weather change
              is triggered.

              Each subsequent line describes an aircraft that will be part of the simulation, using this
              format: TYPE NAME LONGITUDE LATITUDE HEIGHT.
          */
            int simulation = 0;
            if (myReader.hasNextLine()){
                simulation = Integer.parseInt(myReader.nextLine()); 
                System.out.println(simulation);
            }else {
                return;
            }
            ArrayList<String> listAircraft = new ArrayList<String>();
            // int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data.split("\\s+")

                // listAircraft.add(new String(data));
                // i++;
            }
            System.out.println(listAircraft);



        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
