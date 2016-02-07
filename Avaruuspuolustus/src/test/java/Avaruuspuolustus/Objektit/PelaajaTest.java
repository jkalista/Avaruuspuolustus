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
    public void pelaajaLiikkuuOikealleOikeanMaaranKunKutsutaanLiikuOikealleMetodia() {
        this.pelaaja.liikuOikealle();
        assertEquals(330, this.pelaaja.getX());
        assertEquals(770, this.pelaaja.getY());
    }
    
    @Test
    public void pelaajaLiikkuuVasemmalleOikeanMaaranKunKutsutaanLiikuVasemmalleMetodia() {
        this.pelaaja.liikuVasemmalle();
        assertEquals(320, this.pelaaja.getX());
        assertEquals(770, this.pelaaja.getY());
    }
    
    @Test
    public void pelaajaEiVoiLiikkuaYliOikeanRajan() {
        for(int i = 0; i <= 100; i++) {
            this.pelaaja.liikuOikealle();
        }
        assertEquals(595, this.pelaaja.getX());
        assertEquals(770, this.pelaaja.getY());
    }
    
    @Test
    public void pelaajaEiVoiLiikkuaYliVasemmanRajan() {
        for(int i = 0; i <= 100; i++) {
            this.pelaaja.liikuVasemmalle();
        }
        assertEquals(0, this.pelaaja.getX());
        assertEquals(770, this.pelaaja.getY());
    }
    
    @Test
    public void ohjustenAmpuminenLisaaOhjukset() {
        for(int i = 0; i < 5; i++) {
            this.pelaaja.ammuOhjus();
        }
        assertEquals(5, this.pelaaja.getOhjukset().size());
    }
    
    @Test
    public void pelaajanAmpuessaOhjusLuodaanOikeaanPaikkaan() {
        this.pelaaja.ammuOhjus();
        assertEquals(this.pelaaja.getX(), this.pelaaja.getOhjukset().get(0).getX() - 25);
        assertEquals(this.pelaaja.getY(), this.pelaaja.getOhjukset().get(0).getY() + 15);
    }
    
    @Test
    public void pelaajanSijainninAlueOikea() {
        assertEquals(new Rectangle(325, 770, 50, 50), this.pelaaja.getObjektinSijainninAlue());
    }
    
    @Test
    public void pelaajanSijainninAlueOikeaLiikkumisenJalkeen() {
        for(int i = 0; i < 5; i++) {
            this.pelaaja.liikuOikealle();
        }
        assertEquals(new Rectangle(350, 770, 50, 50), this.pelaaja.getObjektinSijainninAlue());
    }
    
    @Test
    public void pelaajanXKoordinaattiAlleVasemmanRajanMuttaMuuttuuRajaArvoksiKunLiikkuuVasemmalle() {
        Pelaaja pelaajanHahmo = new Pelaaja(-50, 770);
        pelaajanHahmo.liikuVasemmalle();
        assertEquals(0, pelaajanHahmo.getX());
    }
    
    @Test
    public void pelaajanXKoordinaattiYliOikeanRajanMuttaMuuttuuRajaArvoksiKunLiikkuuOikealle() {
        Pelaaja pelaajanHahmo = new Pelaaja(1000, 770);
        pelaajanHahmo.liikuOikealle();
        assertEquals(595, pelaajanHahmo.getX());
    }
    
    @Test
    public void asettamallaUudetXJaYArvotPelaajallePalautuuUudetArvot() {
        this.pelaaja.setX(200);
        this.pelaaja.setY(200);
        assertEquals(200, this.pelaaja.getX());
        assertEquals(200, this.pelaaja.getY());
    }
    
    @Test
    public void liikuVasemmalleBooleanOnFalseKunPelaajaLuodaan() {
        assertEquals(false, this.pelaaja.getLiikuVasemmalle());
    }
    
    @Test
    public void liikuOikealleBooleanOnFalseKunPelaajaLuodaan() {
        assertEquals(false, this.pelaaja.getLiikuOikealle());
    }
    
    @Test
    public void liikuVasemmalleMuuttuuTrueksiSetteriaKutsumalla() {
        this.pelaaja.setLiikuVasemmalle(true);
        assertEquals(true, this.pelaaja.getLiikuVasemmalle());
    }
    
    @Test
    public void liikuOikealleMuuttuuTrueksiSetteriaKutsumalla() {
        this.pelaaja.setLiikuOikealle(true);
        assertEquals(true, this.pelaaja.getLiikuOikealle());
    }
}
