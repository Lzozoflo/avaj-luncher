package src.Flyable;

import src.Coordinates;

public class Balloon extends Aircraft {
    
    public Balloon(long p_id, String p_name, Coordinates p_coordinate){
        super(p_id, p_name, p_coordinate);
    }

    /*
        SUN - Longitude increases by 2, Height increases by 4
        RAIN - Height decreases by 5
        FOG - Height decreases by 3
        SNOW - Height decreases by 15
    */
    public void updateConditions(){
        Coordinates last_coordinates = this.coordinates;

        String weather = this.weatherTower.getWeather(last_coordinates);
        int longitude = last_coordinates.getLongitude();
        int latitude = last_coordinates.getLatitute();
        int height = last_coordinates.getHeight();
        switch (weather) {
            case "SUN":
                longitude += 2;
                height += 4;
                break;
        
            case "RAIN":
                height -= 5;
                break;

            case "FOG":
                height -= 3;
                break;

            case "SNOW":
                height -= 15;
                break;
            
            default:
                System.exit(42);
                break;
        }
        this.coordinates = new Coordinates(longitude, latitude, height);
    }

}
