package src;

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

        int longitude = last_coordinates.getLongitude();
        int latitude = last_coordinates.getLatitute();
        int height = last_coordinates.getHeight();
        String weather = this.weatherTower.getWeather(last_coordinates);
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
        if (height <= 0)
            this.weatherTower.unregister(this);
        else if (height > 100)
            height = 100;
        this.coordinates = new Coordinates(longitude, latitude, height);
    }

}
