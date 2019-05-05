
package pasianssi.domain;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Luokka joka vastaa pelin käytössä olevasta korttipakasta
 * @author sarahagstrom
 */
public class Kortit {
    ArrayList<String> kortit;
    final ArrayList<String> kopio;
    Random r;    
    int indeksi = 52;

    public Kortit() {
        r = new Random();
        kortit = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
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
    
    
    /**
     * Poistaa (eli nostaa) ylimmän kortin pakasta
     * @return seuraavan kortin tiedostonimi
     */
    public String nostaKortti() {   
        int korttiIndex = r.nextInt(indeksi);
        indeksi--;
        String kortti = kortit.get(korttiIndex);        
        kortit.remove(kortti);
        String tiedosto = "/PNG/" + kortti + ".png";
        return tiedosto;
    }
    
    
   /**
    * Tarkistaa jos pakka on tyhjä
    * @return true jos kortteja on vielä jäljellä, muulloin false
    */
    public boolean onkoKorttejaJaljella() {
        if(kortit.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
    Nollaa pakan, eli kokoaa uuden 52 kortin pakan
    */
    public void uusiPakka() {
        kortit = new ArrayList<>(kopio);
    }
    
    public void setIndeksi() {
        indeksi = 52;
    }
        
}
