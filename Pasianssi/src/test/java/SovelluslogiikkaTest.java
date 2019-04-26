
import com.mycompany.pasianssi.Sovelluslogiikka;
import com.mycompany.pasianssi.pakka.Kortit;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SovelluslogiikkaTest {
    
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
     * Testaa että lukujen luettelu alkaa aina alusta kun koko lukujono on lueteltu
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
    
    @Test
    public void luvunEpakelvollisuus() {
        Sovelluslogiikka s = new Sovelluslogiikka();        

        if(s.epaKelpoLuku(15)) {
            return;
        }
        fail("Luku kelpaa vaikka ei pitäisi");
    }
    
    @Test
    public void luvunEpakelvollisuusNeg() {
        Sovelluslogiikka s = new Sovelluslogiikka();        

        if(s.epaKelpoLuku(-3)) {
            return;
        }
        fail("Luku kelpaa vaikka ei pitäisi");
    }
    
}
