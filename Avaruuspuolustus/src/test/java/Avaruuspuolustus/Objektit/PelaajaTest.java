/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avaruuspuolustus.Objektit;

import java.awt.Rectangle;
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
public class PelaajaTest {
    
    Pelaaja pelaaja;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja(325, 770);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelaajanLiikkuminenOikealle() {
        this.pelaaja.liikuOikealle();
        assertEquals(330, this.pelaaja.getX());
    }
    
    @Test
    public void pelaajanLiikkuminenVasemmalle() {
        this.pelaaja.liikuVasemmalle();
        assertEquals(320, this.pelaaja.getX());
    }
    
    @Test
    public void pelaajaEiVoiLiikkuaYliOikeanRajan() {
        for(int i = 0; i <= 100; i++) {
            this.pelaaja.liikuOikealle();
        }
        assertEquals(595, this.pelaaja.getX());
    }
    
    @Test
    public void pelaajaEiVoiLiikkuaYliVasemmanRajan() {
        for(int i = 0; i <= 100; i++) {
            this.pelaaja.liikuVasemmalle();
        }
        assertEquals(0, this.pelaaja.getX());
    }
    
    @Test
    public void ohjustenAmpuminenLisaaOhjukset() {
        for(int i = 0; i < 5; i++) {
            this.pelaaja.ammuOhjus();
        }
        assertEquals(5, this.pelaaja.getOhjukset().size());
    }
    
    @Test
    public void pelaajanSijainninAlueOikea() {
        assertEquals(new Rectangle(325, 770, 50, 50), this.pelaaja.getEsineenSijainninAlue());
    }
    
    @Test
    public void pelaajanSijainninAlueOikeaLiikkumisenJalkeen() {
        for(int i = 0; i < 5; i++) {
            this.pelaaja.liikuOikealle();
        }
        assertEquals(new Rectangle(350, 770, 50, 50), this.pelaaja.getEsineenSijainninAlue());
    }
}
