
import pasianssi.domain.Kortit;
import java.io.FileNotFoundException;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class KortitTest {
    
    /**
     * Tarkistaa että onkoKorttejaJaljella() palauttaa false kun korttipakka on tyhjä
     * @throws FileNotFoundException 
     */
    @Test
    public void palauttaaFalseJosTyhja() throws FileNotFoundException {
        Kortit k = new Kortit();
        
        for (int i = 0; i < 52; i++) {
            k.nostaKortti();            
        }
        
        if(!k.onkoKorttejaJaljella()) {
            return;
        }
        fail("Metodi palauttaa true, vaikka pitäisi palauttaa false pakan ollessa tyhjä");
    }
    
    /**
     * Tarkistaa että onkoKorttejaJaljella() palauttaa true kun korttipakkassa on vielä kortteja
     * @throws FileNotFoundException 
     */
    @Test
    public void palauttaaTrueJosKorttejaJaljella() throws FileNotFoundException {
        Kortit k = new Kortit();       
        k.nostaKortti();
        
        if(k.onkoKorttejaJaljella()) {
            return;
        }
        fail("Metodi palauttaa false, vaikka pitäisi palauttaa true kun pakasta löytyy vielä kortteja");
    }
    
    /**
     * Tarkistaa että kortin koko pienenee oikein kun nostetaan kortti
     */
    @Test
    public void nostaKorttiPienentaaPakkaa() {
        Kortit k = new Kortit();
        k.nostaKortti();
        
        if(k.getKortit().size() == 51) {
            return;
        }
        fail("Pakan koko ei pienene korttia nostettaessa");
    }
    
    /**
     * Tarkistaa että uusiPakka() todellakin luo uuden 52-korttisen pakan
     */
    @Test
    public void uusiPakkaToimii() {
        Kortit k = new Kortit();
        k.nostaKortti();
        k.nostaKortti();
        k.nostaKortti();
        
        k.uusiPakka();
        if(k.getKortit().size() == 52) {            
            return;
        }
        fail("Pakka ei nollaantunut");
    }
}
