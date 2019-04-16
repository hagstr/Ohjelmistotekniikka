
package com.mycompany.pasianssi;

import Pakka.Kortit;

public class Sovelluslogiikka {
    int arvo;
    int luku = 1;
    Kortit pakka;

    public Sovelluslogiikka() {
        pakka = new Kortit();
    }
    
    public void aloitaPeli() {
        
    }
    
    public void setArvo(int nro) {
        arvo = nro;
    }
    
    public int getLuku() {
        return luku;
    }
    
    public Kortit getPakka() {
        return pakka;
    }
    
    public void paivitaLuku() {
        if(luku == arvo) {
            luku = 1;
        } else {
            luku++;
        }
    }
    
    public void lukuYkkoseksi() {
        luku = 1;
    }
    
    
}
