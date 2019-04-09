
package com.mycompany.pasianssi;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Kortit {
    ArrayList<String> kortit;
    Random r;    
    int indeksi = 52;

    public Kortit() {
        r = new Random();
        kortit = new ArrayList<>();
        for (int i = 2; i <= 14; i++) {
            kortit.add(i + "H");
            kortit.add(i + "D");
            kortit.add(i + "C");
            kortit.add(i + "S");
        }
    }
    
    public ArrayList<String> getKortit() {
        return kortit;
    }
    
    public ImageView nostaKortti() throws FileNotFoundException {   
        int korttiIndex = r.nextInt(indeksi);
        indeksi--;
        String kortti = kortit.get(korttiIndex);
        kortit.remove(kortti);
        String tiedosto = "/PNG/" + kortti + ".png";
        return new ImageView(new Image(getClass().getResourceAsStream(tiedosto)));
    }
    
    public boolean onkoKorttejaJaljella() {
        if(kortit.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    
}
