package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import avaruustaistelu.objektit.Ohjus;
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
public class ObjektienTarkastajaTest {
    
    ObjektienTarkastaja objektienTarkastaja;
    Avaruustaistelu avaruustaistelu;
    
    public ObjektienTarkastajaTest() {
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
        this.objektienTarkastaja = new ObjektienTarkastaja(this.avaruustaistelu);
        
        this.avaruustaistelu.getAvaruusalus().setX(100);
        this.avaruustaistelu.getAvaruusalus().setY(100);
        this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100, 100));
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100, 100));
        this.avaruustaistelu.getElamapaketit().add(new Elamapaketti(100, 100));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kunMeteoroidiOsuuAvaruusalukseenNiinPeliKaynnissaBooleanMuuttuuFalseksi() {
        this.avaruustaistelu.getObjektienTarkastaja().tarkastaMeteoroidienOsuminenAvaruusalukseen();
        assertEquals(false, this.avaruustaistelu.getPeliKaynnissa());
    }
    
    @Test
    public void kunAvaruusaluksenElamapisteetMenevatNollaanNiinPeliKaynnissaBooleanMuuttuuFalseksi() {
        this.avaruustaistelu.getAvaruusalus().setElamapisteet(0);
        this.avaruustaistelu.getObjektienTarkastaja().tarkastaAvaruusaluksenElamapisteidenMeneminenNollaan();
        assertEquals(false, this.avaruustaistelu.getPeliKaynnissa());
    }
    
    @Test
    public void kunOhjusOsuuMeteoroidiinNiinOhjusHaviaaJaMeteoroidiMenettaaElaman() {
        this.avaruustaistelu.getObjektienTarkastaja().tarkastaOhjustenOsuminenMeteoroideihin();
        assertEquals(4, this.avaruustaistelu.getMeteoroidit().get(0).getElamapisteet());
        assertEquals(0, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
    }
    
    @Test
    public void kunElamapakettiOsuuAvaruusalukseenNiinElamapakettiHaviaaJaPelaajaSaaElamapisteen() {
        this.avaruustaistelu.getAvaruusalus().setElamapisteet(4);
        this.objektienTarkastaja.tarkastaElamapakettienOsuminenAvaruusalukseen();
        assertEquals(0, this.avaruustaistelu.getElamapaketit().size());
        assertEquals(5, this.avaruustaistelu.getAvaruusalus().getElamapisteet());
    }
}
