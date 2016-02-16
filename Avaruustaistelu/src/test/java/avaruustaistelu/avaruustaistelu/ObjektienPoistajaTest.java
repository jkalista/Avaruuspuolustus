package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.objektit.Avaruusalus;
import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
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
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
