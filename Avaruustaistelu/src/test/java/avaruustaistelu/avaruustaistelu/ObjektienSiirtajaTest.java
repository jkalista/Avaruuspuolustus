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
public class ObjektienSiirtajaTest {
    
    ObjektienSiirtaja objektienSiirtaja;
    Avaruustaistelu avaruustaistelu;
    
    public ObjektienSiirtajaTest() {
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
        this.objektienSiirtaja = new ObjektienSiirtaja(this.avaruustaistelu);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void liikutaAvaruusalustaMetodiLiikuttaaAvaruusalustaKunOikealleLiikkuminenOnTrue() {
        this.avaruustaistelu.getAvaruusalus().setLiikuOikealle(true);
        this.objektienSiirtaja.liikutaAvaruusalusta();
        assertEquals(330, this.avaruustaistelu.getAvaruusalus().getX());
    }
    
    @Test
    public void liikutaAvaruusalustaMetodiLiikuttaaAvaruusalustaKunVasemmalleLiikkuminenOnTrue() {
        this.avaruustaistelu.getAvaruusalus().setLiikuVasemmalle(true);
        this.objektienSiirtaja.liikutaAvaruusalusta();
        assertEquals(320, this.avaruustaistelu.getAvaruusalus().getX());
    }
    
    @Test
    public void liikutaOhjuksiaMetodiLiikuttaaKaikkiaAvaruusaluksenOhjuksiaOikein() {
        for(int i = 0; i < 3; i++) {
            this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100 + i*15, 755 + i*10));
        }
        this.objektienSiirtaja.liikutaOhjuksia();
        assertEquals(100, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(0).getX());
        assertEquals(750, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(0).getY());
        assertEquals(115, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(1).getX());
        assertEquals(760, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(1).getY());
        assertEquals(130, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(2).getX());
        assertEquals(770, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(2).getY());
    }
    
    @Test
    public void liikutaMeteoroidejaMetodiLiikuttaaKaikkiaMeteoroidejaOikein() {
        for(int i = 0; i < 3; i++) {
            this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100 + i*20, 0 + i*10));
        }
        this.objektienSiirtaja.liikutaMeteoroideja();
        assertEquals(100, this.avaruustaistelu.getMeteoroidit().get(0).getX());
        assertEquals(1, this.avaruustaistelu.getMeteoroidit().get(0).getY());
        assertEquals(120, this.avaruustaistelu.getMeteoroidit().get(1).getX());
        assertEquals(11, this.avaruustaistelu.getMeteoroidit().get(1).getY());
        assertEquals(140, this.avaruustaistelu.getMeteoroidit().get(2).getX());
        assertEquals(21, this.avaruustaistelu.getMeteoroidit().get(2).getY());
    }
    
    @Test
    public void liikutaElamapakettejaMetodiLiikuttaaKaikkiaElamapakettejaOikein() {
        for (int i = 0; i < 3; i++) {
            this.avaruustaistelu.getElamapaketit().add(new Elamapaketti(100 + i*20, 0 + i*10));
        }
        this.objektienSiirtaja.liikutaElamapaketteja();
        assertEquals(100, this.avaruustaistelu.getElamapaketit().get(0).getX());
        assertEquals(3, this.avaruustaistelu.getElamapaketit().get(0).getY());
        assertEquals(120, this.avaruustaistelu.getElamapaketit().get(1).getX());
        assertEquals(13, this.avaruustaistelu.getElamapaketit().get(1).getY());
        assertEquals(140, this.avaruustaistelu.getElamapaketit().get(2).getX());
        assertEquals(23, this.avaruustaistelu.getElamapaketit().get(2).getY());
    }
}
