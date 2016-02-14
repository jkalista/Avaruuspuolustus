package avaruustaistelu.objektit;

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
public class ElamapakettiTest {
    
    Elamapaketti elamapaketti;
    
    public ElamapakettiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.elamapaketti = new Elamapaketti(100, 0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void elamapakettiLiikkuuOikeinKunKutsutaanLiikuKomentoaKerran() {
        this.elamapaketti.liiku();
        assertEquals(3, this.elamapaketti.getY());
        assertEquals(100, this.elamapaketti.getX());
    }
    
    @Test
    public void elamapakettiLiikkuuOikeinKunKutsutaanLiikuKomentoaUseammanKerran() {
        for (int i = 0; i < 5; i++) {
            this.elamapaketti.liiku();
        }
        assertEquals(15, this.elamapaketti.getY());
        assertEquals(100, this.elamapaketti.getX());
    }
    
    @Test
    public void elamapaketinSijainninAlueOikea() {
        assertEquals(new Rectangle(100, 0, 20, 20), this.elamapaketti.getObjektinSijainninAlue());
    }
    
    @Test
    public void elamapaketinSijainninAlueOikeaLiikkumisenJalkeen() {
        for (int i = 0; i < 5; i++) {
            this.elamapaketti.liiku();
        }
        assertEquals(new Rectangle(100, 15, 20, 20), this.elamapaketti.getObjektinSijainninAlue());
    }
}
