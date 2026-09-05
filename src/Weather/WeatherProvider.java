package src.Weather;

import src.Coordinates;

public class WeatherProvider {

    private static String[] weather;
    private static WeatherProvider single_instance = null;

    private WeatherProvider(){
        weather = new String[]{"SUN","RAIN","FOG","SNOW"};
    }

    public static String getCurrentWeather(Coordinates p_Coordinates){
        if (single_instance == null)
            single_instance = new WeatherProvider();

        long v = (p_Coordinates.getLongitude() + p_Coordinates.getLatitute()
            + p_Coordinates.getHeight() + System.nanoTime()) 
            % weather.length;

        return new String(weather[(int)v]);
    }
}
