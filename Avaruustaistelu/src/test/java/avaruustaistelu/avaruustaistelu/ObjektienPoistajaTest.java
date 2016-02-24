package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.objektit.Avaruusalus;
import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import avaruustaistelu.objektit.Ohjus;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jyri
 */
public class ObjektienPoistajaTest {
    
    ObjektienPoistaja objektienPoistaja;
    Avaruustaistelu avaruustaistelu;
    
    public ObjektienPoistajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.avaruustaistelu = new Avaruustaistelu();
        this.objektienPoistaja = new ObjektienPoistaja(this.avaruustaistelu);
        
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100, 0));
        this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(500, 500));
        this.avaruustaistelu.getElamapaketit().add(new Elamapaketti(100, 125));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kunMeteoroidinElamapisteetMeneeNollaanNiinMeteoroidiTuhoutuuJaAvaruusalusSaaPisteenJaPeliVaikeutuu() {
        this.avaruustaistelu.getMeteoroidit().get(0).setElamapisteet(0);
        this.avaruustaistelu.getObjektienPoistaja().poistaTuhoutuneetMeteoroidit();
        assertEquals(0, this.avaruustaistelu.getMeteoroidit().size());
        assertEquals(1, this.avaruustaistelu.getAvaruusalus().getPisteet());
        assertEquals(3950, this.avaruustaistelu.getLuoUusiMeteoroidi().getDelay());
    }
    
    @Test
    public void kunMeteoroidiLiikkuuPoisPelialueeltaNiinMeteoroidiPoistuuJaAvaruusalusMenettaaYhdenElamapisteen() {        
        for (int i = 0; i <= 1000; i++) {
            this.avaruustaistelu.getMeteoroidit().get(0).liiku();
        }
        this.avaruustaistelu.getObjektienPoistaja().poistaAlueeltaPoistuneetMeteoroiditJaMenetaElamapisteAvaruusalukselta();
        assertEquals(0, this.avaruustaistelu.getMeteoroidit().size());
        assertEquals(4, this.avaruustaistelu.getAvaruusalus().getElamapisteet());
    }
    
    @Test
    public void kunOhjusLiikkuuPoisPelialueeltaNiinSePoistuu() {
        for (int i = 0; i <= 500; i++) {
            this.avaruustaistelu.getAvaruusalus().getOhjukset().get(0).liiku();
        }
        this.avaruustaistelu.getObjektienPoistaja().poistaAlueeltaPoistuneetOhjukset();
        assertEquals(0, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
    }
    
    @Test
    public void kunElamapakettiLiikkuuPoisPelialueeltaNiinSePoistuu() {
        for (int i = 0; i <= 1000; i++) {
            this.avaruustaistelu.getElamapaketit().get(0).liiku();
        }
        this.avaruustaistelu.getObjektienPoistaja().poistaAlueeltaPoistuneetElamapaketit();
        assertEquals(0, this.avaruustaistelu.getElamapaketit().size());
    }
    
}
