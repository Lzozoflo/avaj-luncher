package src;

public class Coordinates {
    private int longitude;
    private int latitute;
    private int height;

    Coordinates(int p_longitude, int p_latitute, int p_height){
        this.longitude = p_longitude;
        this.latitute = p_latitute;
        this.height = p_height;
    }
    
    public int getLongitude(){return this.longitude;}
    public int getLatitute(){return this.latitute;}
    public int getHeight(){return this.height;}

}

