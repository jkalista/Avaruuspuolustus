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
public class OhjusTest {
    
    Ohjus ohjus;
    
    public OhjusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.ohjus = new Ohjus(350, 760);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ohjusLiikkuuOikeinKunKutsutaanLiikuKomentoaKerran() {
        this.ohjus.liiku();
        assertEquals(755, this.ohjus.getY());
        assertEquals(350, this.ohjus.getX());
    }
    
    @Test
    public void ohjusLiikkuuOikeinKunKutsutaanLiikuKomentoaUseammanKerran() {
        for(int i = 0; i < 5; i++) {
            this.ohjus.liiku();
        }
        assertEquals(735, this.ohjus.getY());
        assertEquals(350, this.ohjus.getX());
    }
    
    @Test
    public void ohjuksenSijainninAlueOikea() {
        assertEquals(new Rectangle(350, 760, 5, 15), this.ohjus.getEsineenSijainninAlue());
    }
    
    @Test
    public void ohjuksenSijainninAlueOikeaLiikkumisenJalkeen() {
        for(int i = 0; i < 5; i++) {
            this.ohjus.liiku();
        }
        assertEquals(new Rectangle(350, 735, 5, 15), this.ohjus.getEsineenSijainninAlue());
    }
}
