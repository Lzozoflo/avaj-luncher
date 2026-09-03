package src;

public class WeatherProvider {

    // private String[] weather;
    private static WeatherProvider single_instance = null;

    private WeatherProvider(){}

    String getCurrentWeather(Coordinates p_Coordinates){
        if (single_instance == null)
            single_instance = new WeatherProvider();
        
        return "sossu";
    }
}
