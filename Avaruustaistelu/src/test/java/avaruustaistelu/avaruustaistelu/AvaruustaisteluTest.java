package avaruustaistelu.avaruustaistelu;

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
public class AvaruustaisteluTest {
    
    Avaruustaistelu avaruustaistelu;
    
    public AvaruustaisteluTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kunMeteoroidinElamapisteetMeneeNollaanNiinSeTuhoutuu() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100,100));
        assertEquals(1, this.avaruustaistelu.getMeteoroidit().size());
        this.avaruustaistelu.getMeteoroidit().get(0).setElamapisteet(0);
        this.avaruustaistelu.poistaTuhoutuneetMeteoroidit();
        assertEquals(0, this.avaruustaistelu.getMeteoroidit().size());
    }
    
    @Test
    public void kunMeteoroidiTuhoutuuNiinUudenMeteoroidinLuovanTimerinViiveVahentyy() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100, 100));
        this.avaruustaistelu.getMeteoroidit().get(0).setElamapisteet(0);
        this.avaruustaistelu.poistaTuhoutuneetMeteoroidit();
        assertEquals(5980, this.avaruustaistelu.luoUusiMeteoroidi.getDelay());
    }
    
    @Test
    public void kunMeteoroidiTuhoutuuNiinPelaajaSaaPisteen() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100,100));
        this.avaruustaistelu.getMeteoroidit().get(0).setElamapisteet(0);
        this.avaruustaistelu.poistaTuhoutuneetMeteoroidit();
        assertEquals(1, this.avaruustaistelu.getAvaruusalus().getPisteet());
    }
    
    @Test
    public void kunOhjusOsuuMeteoroidiinNiinOhjusHaviaaJaMeteoroidiMenettaaElaman() {
        this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100, 100));
        assertEquals(1, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100,100));
        this.avaruustaistelu.tarkastaOhjustenOsuminenMeteoroideihin();
        assertEquals(4, this.avaruustaistelu.getMeteoroidit().get(0).getElamapisteet());
        assertEquals(0, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
    }
    
    @Test
    public void kunMeteoroidiLiikkuuPoisPelialueeltaNiinSePoistuu() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100,0));
        this.avaruustaistelu.poistaAlueeltaPoistuneetMeteoroidit();
        assertEquals(1, this.avaruustaistelu.getMeteoroidit().size());
        for(int i = 0; i < 900; i++) {
            this.avaruustaistelu.liikutaMeteoroideja();
        }
        this.avaruustaistelu.poistaAlueeltaPoistuneetMeteoroidit();
        assertEquals(0, this.avaruustaistelu.getMeteoroidit().size());
    }
    
    @Test
    public void kunOhjusLiikkuuPoisPelialueeltaNiinSePoistuu() {
        this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100,755));
        this.avaruustaistelu.poistaAlueeltaPoistuneetOhjukset();
        assertEquals(1, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
        for(int i = 0; i < 154; i++) {
            this.avaruustaistelu.liikutaOhjuksia();
        }
        this.avaruustaistelu.poistaAlueeltaPoistuneetOhjukset();
        assertEquals(0, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
    }
    
    @Test
    public void liikutaMeteoroidejaMetodiLiikuttaaKaikkiaMeteoroidejaOikein() {
        for(int i = 0; i < 3; i++) {
            this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100 + i*20, 0 + i*10));
        }
        this.avaruustaistelu.liikutaMeteoroideja();
        assertEquals(100, this.avaruustaistelu.getMeteoroidit().get(0).getX());
        assertEquals(1, this.avaruustaistelu.getMeteoroidit().get(0).getY());
        assertEquals(120, this.avaruustaistelu.getMeteoroidit().get(1).getX());
        assertEquals(11, this.avaruustaistelu.getMeteoroidit().get(1).getY());
        assertEquals(140, this.avaruustaistelu.getMeteoroidit().get(2).getX());
        assertEquals(21, this.avaruustaistelu.getMeteoroidit().get(2).getY());
    }
    
    @Test
    public void liikutaOhjuksiaMetodiLiikuttaaKaikkiaPelaajanOhjuksiaOikein() {
        for(int i = 0; i < 3; i++) {
            this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100 + i*15, 755 + i*10));
        }
        this.avaruustaistelu.liikutaOhjuksia();
        assertEquals(100, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(0).getX());
        assertEquals(750, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(0).getY());
        assertEquals(115, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(1).getX());
        assertEquals(760, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(1).getY());
        assertEquals(130, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(2).getX());
        assertEquals(770, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(2).getY());
    }
    
    @Test
    public void kunPeliKaynnissaNiinGetPeliKaynnissaPalauttaaOikeanBooleanin() {
        assertEquals(true, this.avaruustaistelu.getPeliKaynnissa());
    }
    
    @Test
    public void kunAsetetaanPeliKaynnissaFalseksiSetMetodillaNiinSeMuuttuu() {
        this.avaruustaistelu.setPeliKaynnissa(false);
        assertEquals(false, this.avaruustaistelu.getPeliKaynnissa());
    }
    
    @Test
    public void kunMeteoroidiOsuuPelaajaanNiinPeliKaynnissaBooleanMuuttuuFalseksi() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100,100));
        this.avaruustaistelu.getAvaruusalus().setX(100);
        this.avaruustaistelu.getAvaruusalus().setY(100);
        this.avaruustaistelu.tarkastaMeteoroidienOsuminenPelaajaan();
        assertEquals(false, this.avaruustaistelu.getPeliKaynnissa());
    }
    
    @Test
    public void paivitaPeliaMetodiLiikuttaaPelaajaaKunPelaajanOikealleLiikkuminenOnTrue() {
        this.avaruustaistelu.getAvaruusalus().setLiikuOikealle(true);
        this.avaruustaistelu.paivitaPelia();
        assertEquals(330, this.avaruustaistelu.getAvaruusalus().getX());
    }
    
    @Test
    public void paivitaPeliaMetodiLiikuttaaPelaajaaKunPelaajanVasemmalleLiikkuminenOnTrue() {
        this.avaruustaistelu.getAvaruusalus().setLiikuVasemmalle(true);
        this.avaruustaistelu.paivitaPelia();
        assertEquals(320, this.avaruustaistelu.getAvaruusalus().getX());
    }
    
    @Test
    public void paivitaPeliaMetodiLiikuttaaMeteoroidiaOikein() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100,100));
        this.avaruustaistelu.paivitaPelia();
        assertEquals(101, this.avaruustaistelu.getMeteoroidit().get(0).getY());
    }
    
    @Test
    public void paivitaPeliaMetodiLiikuttaaOhjustaOikein() {
        this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100, 100));
        this.avaruustaistelu.paivitaPelia();
        assertEquals(95, this.avaruustaistelu.getAvaruusalus().getOhjukset().get(0).getY());
    }
    
    @Test
    public void paivitaPeliaMetodiTuhoaaOhjuksenJosOhjusOnKosketuksissaMeteoroidinKanssa() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100,100));
        this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100, 100));
        this.avaruustaistelu.paivitaPelia();
        assertEquals(0, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
    }
    
    @Test
    public void paivitaPeliaMetodiPoistaaAlueeltaPoistuneenMeteoroidin() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100, 850));
        for(int i=0; i <= 50; i++) {
            this.avaruustaistelu.getMeteoroidit().get(0).liiku();
        }
        this.avaruustaistelu.paivitaPelia();
        assertEquals(0, this.avaruustaistelu.getMeteoroidit().size());
    }
    
    @Test
    public void paivitaPeliaMetodiaaPoistaaAlueeltaPoistuneenOhjuksen() {
        this.avaruustaistelu.getAvaruusalus().getOhjukset().add(new Ohjus(100, 100));
        for(int i=0; i <= 50; i++) {
            this.avaruustaistelu.getAvaruusalus().getOhjukset().get(0).liiku();
        }
        this.avaruustaistelu.paivitaPelia();
        assertEquals(0, this.avaruustaistelu.getAvaruusalus().getOhjukset().size());
    }
    
    @Test
    public void paivitaPeliaMetodiPoistaaTuhoutuneetMeteoroiditEliMeteoroiditJoillaNollaElamapistetta() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(100, 100));
        this.avaruustaistelu.getMeteoroidit().get(0).setElamapisteet(0);
        this.avaruustaistelu.paivitaPelia();
        assertEquals(0, this.avaruustaistelu.getMeteoroidit().size());
    }
    
    @Test
    public void paivitaPeliaMetodiMuuttaaPeliKaynnissaBooleaninFalseksiKunPelaajaKoskettaaMeteoroidia() {
        this.avaruustaistelu.getMeteoroidit().add(new Meteoroidi(325, 770));
        this.avaruustaistelu.paivitaPelia();
        assertEquals(false, this.avaruustaistelu.getPeliKaynnissa());
    }
    
    @Test
    public void uudenMeteoroidinLuovanTimerinViiveOnOikea() {
        assertEquals(6000, this.avaruustaistelu.luoUusiMeteoroidi.getDelay());
    }
    
    @Test
    public void metodiVaikeutaPeliaVahentaaUudenMeteoroidinLuovanTimerinViivettaOikein() {
        this.avaruustaistelu.vaikeutaPeliaLyhentamallaUudenMeteoroidinAjastimenAikaa();
        assertEquals(5980, this.avaruustaistelu.luoUusiMeteoroidi.getDelay());
    }
    
    @Test
    public void metodiVaikeutaPeliaEiVoiVahentaaAikaaAlleTuhannen() {
        for(int i=0; i <= 500; i++) {
            this.avaruustaistelu.vaikeutaPeliaLyhentamallaUudenMeteoroidinAjastimenAikaa();
        }
        assertEquals(1000, this.avaruustaistelu.luoUusiMeteoroidi.getDelay());
    }
}
