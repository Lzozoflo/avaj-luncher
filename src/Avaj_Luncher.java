package src;
import java.io.File;
import java.util.Scanner;

// Signification des symboles UML :
// - (Moins) : private (accessible uniquement au sein de la classe Tower).
// + (Plus) : public (accessible depuis n'importe quelle autre classe).
// # (Dièse) : protected (accessible au sein de la classe, de ses sous-classes et du même package).
// ~ (Tilde, optionnel) : package-private / niveau par défaut sans mot-clé.

public class Avaj_Luncher {
    
    static boolean checkScenario(String tab[]){

        if (tab.length != 5)
            return false;

        String type = tab[0];
        String name = tab[1];
        String longitude = tab[2];
        String latitude = tab[3];
        String height = tab[4];

        if (!type.equals("Balloon") && !type.equals("JetPlane") && !type.equals("Helicopter"))
            return false;
        
        if (!name.matches("[a-zA-Z0-9]+"))
            return false;
        
        if (longitude.matches("[0-9]+") && latitude.matches("[0-9]+") && height.matches("[0-9]+")) {
            return true;
        }
        System.out.println(type);
        System.out.println(name);
        System.out.println(longitude);
        System.out.println(latitude);
        System.out.println(height);
        System.out.println("\n");
        return false;
    }
    /*
        The first line of the file contains a positive integer. This number represents how many
        times the simulation runs. In our case, this will be the number of times a weather change
        is triggered.

        Each subsequent line describes an aircraft that will be part of the simulation, using this
        format: TYPE NAME LONGITUDE LATITUDE HEIGHT.
    */
    public static void main(String[] args) {
        // System.exit(0);
        
        File myObj = new File(args[0]);
        try (Scanner myReader = new Scanner(myObj)) {

            int NbSimulation = 0;
            if (myReader.hasNextLine()){
                NbSimulation = Integer.parseInt(myReader.nextLine()); 
                System.out.println(NbSimulation);
            } else {
                return;
            }
            
            WeatherTower wt = new WeatherTower();
            
            int i = 2;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String tab[] = data.split("\\s+");
                
                if (!checkScenario(tab)){
                    System.err.println("Error scenario line " + i);
                    return;
                }
                i++;
                
                Coordinates coordinates = new Coordinates(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]));
                Flyable newAirCraft = AircraftFactory.newAircraft(tab[0], tab[1], coordinates);
                wt.register(newAirCraft);
                newAirCraft.registerTower(wt);
                
            }
            // System.out.println(listAircraft);



        } catch (Exception e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
