package shyam.ram.advance.logic;

import java.util.ArrayList;
import java.util.List;

public class NewLatLong {


    public static void main(String[] args) {
        float longt = Float.parseFloat("77.0528");
        float latt = Float.parseFloat("28.4379");
        float longi = Float.parseFloat("77.0528");
        float lat = Float.parseFloat("28.4379");
        List<Locat> locats = new ArrayList<>();

//        System.out.println(i);
        for (int j = 1; j < 5; j++) {
            lat = latt + .01f*j;
            locats.add(new Locat(lat, longt));
            lat = latt - .01f*j;
            locats.add(new Locat(lat, longt));
        }
        for (int j = 1; j < 5; j++) {
            longi = longt + .01f*j;
            locats.add(new Locat(latt, longi));
            longi = longt + .01f*j;
            locats.add(new Locat(latt, longi));
        }
    }
}

class Locat {
    double lati, longi, name, fame;

    public Locat(double lati, double longi) {
        this.lati = lati;
        this.longi = longi;
    }
}
