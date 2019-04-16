
import Pakka.Kortit;
import java.io.FileNotFoundException;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class KortitTest {
    
    
    
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
    
    @Test
    public void palauttaaTrueJosKorttejaJaljella() throws FileNotFoundException {
        Kortit k = new Kortit();       
        k.nostaKortti();
        
        if(k.onkoKorttejaJaljella()) {
            return;
        }
        fail("Metodi palauttaa false, vaikka pitäisi palauttaa true kun pakasta löytyy vielä kortteja");
    }
    
    @Test
    public void nostaKorttiPienentaaPakkaa() {
        Kortit k = new Kortit();
        k.nostaKortti();
        
        if(k.getKortit().size() == 51) {
            return;
        }
        fail("Pakan koko ei pienene korttia nostettaessa");
    }
}
