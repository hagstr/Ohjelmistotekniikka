
import pasianssi.domain.Sovelluslogiikka;
import pasianssi.domain.Kortit;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SovelluslogiikkaTest {
    
    /**
        Testaa että lueteltu luku kasvaa kun lukua päivitetään
    */
    @Test 
    public void lukuSuurenee() {
        Sovelluslogiikka s = new Sovelluslogiikka();
        s.setArvo(5);
        s.paivitaLuku();
        s.paivitaLuku();
        
        if(s.getLuku() == 3) {
            return;
        }
        fail("Luku ei päivity oikein");
    }
    
    
    /**
         Testaa että lukujen luettelu alkaa aina alusta kun koko lukujono on lueteltu
     */
    @Test
    public void lukuPaivittyyYliRajan() {
        Sovelluslogiikka s = new Sovelluslogiikka();
        s.setArvo(3);
        s.paivitaLuku();
        s.paivitaLuku();
        s.paivitaLuku();
        s.paivitaLuku();
        
        if(s.getLuku() == 2) {
            return;
        }
        fail("Luku ei päivity oikein");
    }
    
    
    /**
         Testaa että lueteltu luku muuttuu ykköseksi kun kutsutaan metodia lukuYkkoseksi()
    */
    @Test
    public void lukuMuuttuuYkkoseksi() {
        Sovelluslogiikka s = new Sovelluslogiikka();
        s.setArvo(3);
        s.paivitaLuku();
        s.paivitaLuku();
        s.lukuYkkoseksi();
        
        if(s.getLuku() == 1) {
            return;
        }
        fail("Luku ei päivity oikein");
    }
    
    /**
        Testaa että sovellus ei hyväksy liian suuria lukuja luettelu-arvoksi
    */
    @Test
    public void luvunEpakelvollisuus() {
        Sovelluslogiikka s = new Sovelluslogiikka();        

        if(s.epakelpoLuku(15)) {
            return;
        }
        fail("Luku kelpaa vaikka ei pitäisi");
    }
    
    /**
        Testaa että sovellus ei hyväksy negatiivisia lukuja luettelu-arvoksi
     */
    @Test
    public void luvunEpakelvollisuusNeg() {
        Sovelluslogiikka s = new Sovelluslogiikka();        

        if(s.epakelpoLuku(-3)) {
            return;
        }
        fail("Luku kelpaa vaikka ei pitäisi");
    }        
    
}
