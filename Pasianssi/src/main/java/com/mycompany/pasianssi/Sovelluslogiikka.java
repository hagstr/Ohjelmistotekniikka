
package com.mycompany.pasianssi;

import com.mycompany.pasianssi.pakka.Kortit;

public class Sovelluslogiikka {
    int valittuArvo;
    int luku = 1;
    Kortit pakka;

    public Sovelluslogiikka() {
        pakka = new Kortit();
    }    
    
    public void setArvo(int arvo) {
        valittuArvo = arvo;
    }
    
    public int getLuku() {
        return luku;
    }
    
    public Kortit getPakka() {
        return pakka;
    }
    
    /**
     * Korottaa lueteltavaa lukua yhdellä, tai jos luku ylittäisi valitun arvon luku saa arvoksi 1 
     */
    public void paivitaLuku() {
        if(luku == valittuArvo) {
            luku = 1;
        } else {
            luku++;
        }
    }
    
    
    /**
     * Metodi muuttaa lueteltavan luvun ykköseksi, käytetään kun aloitetaan uusi peli
     */
    public void lukuYkkoseksi() {
        luku = 1;
    }
    
    
    /**
     * 
     * @param luku = valittu arvo johon asti luetellaan
     * @return true jos luku on epäkelpo, ja false jos luku kelpaa (eli luvut 1-13)
     */
    public boolean epaKelpoLuku(int luku) {
        if(luku < 1 || luku > 13) {
            return true;
        } 
        return false;
    }
    
}
