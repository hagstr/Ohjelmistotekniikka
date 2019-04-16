
package Pakka;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Kortit {
    ArrayList<String> kortit;
    final ArrayList<String> kopio;
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
        kopio = new ArrayList<>(kortit);
    }
    
    public ArrayList<String> getKortit() {
        return kortit;
    }
    
    public String nostaKortti() {   
        int korttiIndex = r.nextInt(indeksi);
        indeksi--;
        String kortti = kortit.get(korttiIndex);        
        kortit.remove(kortti);
        String tiedosto = "/PNG/" + kortti + ".png";
        return tiedosto;
    }
    
    public boolean onkoKorttejaJaljella() {
        if(kortit.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public void uusiPakka() {
        kortit = new ArrayList<>(kopio);
    }
        
}
