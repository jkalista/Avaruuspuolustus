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
public class MeteoroidiTest {
    
    Meteoroidi meteoroidi;
    
    public MeteoroidiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.meteoroidi = new Meteoroidi(100, 100);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void meteoroidiLiikkuuOikeinKunKutsutaanLiikuKomentoaKerran() {
        this.meteoroidi.liiku();
        assertEquals(101, this.meteoroidi.getY());
        assertEquals(100, this.meteoroidi.getX());
    }
    
    @Test
    public void meteoroidiLiikkuuOikeinKunKutsutaanLiikuKomentoaUseammanKerran() {
        for(int i = 0; i < 5; i++) {
            this.meteoroidi.liiku();
        }
        assertEquals(105, this.meteoroidi.getY());
        assertEquals(100, this.meteoroidi.getX());
    }
    
    @Test
    public void meteoroidiMenettaaElamapisteenKunKutsutaanMenetaElamapisteMetodia() {
        assertEquals(5, this.meteoroidi.getElamapisteet());
        this.meteoroidi.menetaElamapiste();
        assertEquals(4, this.meteoroidi.getElamapisteet());
    }
    
    @Test
    public void meteoroidiElamapisteetOikeinSetMetodinKutsumisenJalkeen() {
        this.meteoroidi.setElamapisteet(3);
        assertEquals(3, this.meteoroidi.getElamapisteet());
    }
    
    @Test
    public void meteoroidinSijainninAlueetOvatOikeinJokaisellaEriElamapisteella() {
        assertEquals(new Rectangle(100, 100, 40, 40), this.meteoroidi.getObjektinSijainninAlue());
        this.meteoroidi.menetaElamapiste();
        assertEquals(new Rectangle(100, 100, 35, 35), this.meteoroidi.getObjektinSijainninAlue());
        this.meteoroidi.menetaElamapiste();
        assertEquals(new Rectangle(100, 100, 30, 30), this.meteoroidi.getObjektinSijainninAlue());
        this.meteoroidi.menetaElamapiste();
        assertEquals(new Rectangle(100, 100, 25, 25), this.meteoroidi.getObjektinSijainninAlue());
        this.meteoroidi.menetaElamapiste();
        assertEquals(new Rectangle(100, 100, 20, 20), this.meteoroidi.getObjektinSijainninAlue());
    }
}
