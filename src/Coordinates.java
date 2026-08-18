package src;

public class Coordinates {
    int longitude;
    int latitute;
    int height;

    Coordinates(int p_longitude, int p_latitute, int p_height){
        this.longitude = p_longitude;
        this.latitute = p_latitute;
        this.height = p_height;
    }
    int getLongitude(){return this.longitude;}

    int getLatitute(){return this.latitute;}

    int getHeight(){return this.height;}

}

