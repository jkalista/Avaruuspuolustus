/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avaruuspuolustus.Avaruuspuolustus;

import Avaruuspuolustus.Objektit.Meteoroidi;
import Avaruuspuolustus.Objektit.Ohjus;
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
public class AvaruuspuolustusTest {
    
    Avaruuspuolustus avaruuspuolustus;
    
    public AvaruuspuolustusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.avaruuspuolustus = new Avaruuspuolustus();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kunMeteoroidinElamapisteetMeneeNollaanNiinSeTuhoutuu() {
        this.avaruuspuolustus.getMeteoroidit().add(new Meteoroidi(100,100));
        assertEquals(1, this.avaruuspuolustus.getMeteoroidit().size());
        this.avaruuspuolustus.getMeteoroidit().get(0).setElamapisteet(0);
        this.avaruuspuolustus.poistaTuhoutuneetMeteoroidit();
        assertEquals(0, this.avaruuspuolustus.getMeteoroidit().size());
    }
    
    @Test
    public void kunOhjusOsuuMeteoroidiinNiinOhjusHaviaaJaMeteoroidiMenettaaElaman() {
        this.avaruuspuolustus.getPelaaja().getOhjukset().add(new Ohjus(100, 100));
        assertEquals(1, this.avaruuspuolustus.getPelaaja().getOhjukset().size());
        this.avaruuspuolustus.getMeteoroidit().add(new Meteoroidi(100,100));
        this.avaruuspuolustus.tarkastaOhjustenOsuminenMeteoroideihin();
        assertEquals(4, this.avaruuspuolustus.getMeteoroidit().get(0).getElamapisteet());
        assertEquals(0, this.avaruuspuolustus.getPelaaja().getOhjukset().size());
    }
    
    @Test
    public void kunMeteoroidiLiikkuuPoisPelialueeltaNiinSePoistuu() {
        this.avaruuspuolustus.getMeteoroidit().add(new Meteoroidi(100,0));
        this.avaruuspuolustus.poistaAlueeltaPoistuneetMeteoroidit();
        assertEquals(1, this.avaruuspuolustus.getMeteoroidit().size());
        for(int i = 0; i < 900; i++) {
            this.avaruuspuolustus.liikutaMeteoroideja();
        }
        this.avaruuspuolustus.poistaAlueeltaPoistuneetMeteoroidit();
        assertEquals(0, this.avaruuspuolustus.getMeteoroidit().size());
    }
    
    @Test
    public void kunOhjusLiikkuuPoisPelialueeltaNiinSePoistuu() {
        this.avaruuspuolustus.getPelaaja().getOhjukset().add(new Ohjus(100,755));
        this.avaruuspuolustus.poistaAlueeltaPoistuneetOhjukset();
        assertEquals(1, this.avaruuspuolustus.getPelaaja().getOhjukset().size());
        for(int i = 0; i < 154; i++) {
            this.avaruuspuolustus.liikutaOhjuksia();
        }
        this.avaruuspuolustus.poistaAlueeltaPoistuneetOhjukset();
        assertEquals(0, this.avaruuspuolustus.getPelaaja().getOhjukset().size());
    }
    
    @Test
    public void liikutaMeteoroidejaMetodiLiikuttaaKaikkiaMeteoroidejaOikein() {
        for(int i = 0; i < 3; i++) {
            this.avaruuspuolustus.getMeteoroidit().add(new Meteoroidi(100 + i*20, 0 + i*10));
        }
        this.avaruuspuolustus.liikutaMeteoroideja();
        assertEquals(100, this.avaruuspuolustus.getMeteoroidit().get(0).getX());
        assertEquals(1, this.avaruuspuolustus.getMeteoroidit().get(0).getY());
        assertEquals(120, this.avaruuspuolustus.getMeteoroidit().get(1).getX());
        assertEquals(11, this.avaruuspuolustus.getMeteoroidit().get(1).getY());
        assertEquals(140, this.avaruuspuolustus.getMeteoroidit().get(2).getX());
        assertEquals(21, this.avaruuspuolustus.getMeteoroidit().get(2).getY());
    }
    
    @Test
    public void liikutaOhjuksiaMetodiLiikuttaaKaikkiaPelaajanOhjuksiaOikein() {
        for(int i = 0; i < 3; i++) {
            this.avaruuspuolustus.getPelaaja().getOhjukset().add(new Ohjus(100 + i*15, 755 + i*10));
        }
        this.avaruuspuolustus.liikutaOhjuksia();
        assertEquals(100, this.avaruuspuolustus.getPelaaja().getOhjukset().get(0).getX());
        assertEquals(750, this.avaruuspuolustus.getPelaaja().getOhjukset().get(0).getY());
        assertEquals(115, this.avaruuspuolustus.getPelaaja().getOhjukset().get(1).getX());
        assertEquals(760, this.avaruuspuolustus.getPelaaja().getOhjukset().get(1).getY());
        assertEquals(130, this.avaruuspuolustus.getPelaaja().getOhjukset().get(2).getX());
        assertEquals(770, this.avaruuspuolustus.getPelaaja().getOhjukset().get(2).getY());
    }
    
    @Test
    public void kunPeliKaynnissaNiinGetPeliKaynnissaPalauttaaOikeanBooleanin() {
        assertEquals(true, this.avaruuspuolustus.getPeliKaynnissa());
    }
    
    @Test
    public void kunAsetetaanPeliKaynnissaFalseksiSetMetodillaNiinSeMuuttuu() {
        this.avaruuspuolustus.setPeliKaynnissa(false);
        assertEquals(false, this.avaruuspuolustus.getPeliKaynnissa());
    }
}
