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
public class AvaruusalusTest {
    
    Avaruusalus avaruusalus;
    
    public AvaruusalusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.avaruusalus = new Avaruusalus(325, 770);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelaajaLiikkuuOikealleOikeanMaaranKunKutsutaanLiikuOikealleMetodia() {
        this.avaruusalus.liikuOikealle();
        assertEquals(330, this.avaruusalus.getX());
        assertEquals(770, this.avaruusalus.getY());
    }
    
    @Test
    public void pelaajaLiikkuuVasemmalleOikeanMaaranKunKutsutaanLiikuVasemmalleMetodia() {
        this.avaruusalus.liikuVasemmalle();
        assertEquals(320, this.avaruusalus.getX());
        assertEquals(770, this.avaruusalus.getY());
    }
    
    @Test
    public void pelaajaEiVoiLiikkuaYliOikeanRajan() {
        for(int i = 0; i <= 200; i++) {
            this.avaruusalus.liikuOikealle();
        }
        assertEquals(595, this.avaruusalus.getX());
        assertEquals(770, this.avaruusalus.getY());
    }
    
    @Test
    public void pelaajaEiVoiLiikkuaYliVasemmanRajan() {
        for(int i = 0; i <= 200; i++) {
            this.avaruusalus.liikuVasemmalle();
        }
        assertEquals(0, this.avaruusalus.getX());
        assertEquals(770, this.avaruusalus.getY());
    }
    
    @Test
    public void ohjustenAmpuminenLisaaOhjukset() {
        for(int i = 0; i < 5; i++) {
            this.avaruusalus.ammuOhjus();
        }
        assertEquals(5, this.avaruusalus.getOhjukset().size());
    }
    
    @Test
    public void pelaajanAmpuessaOhjusLuodaanOikeaanPaikkaan() {
        this.avaruusalus.ammuOhjus();
        assertEquals(this.avaruusalus.getX(), this.avaruusalus.getOhjukset().get(0).getX() - 25);
        assertEquals(this.avaruusalus.getY(), this.avaruusalus.getOhjukset().get(0).getY() + 15);
    }
    
    @Test
    public void pelaajanSijainninAlueOikea() {
        assertEquals(new Rectangle(325, 770, 50, 50), this.avaruusalus.getObjektinSijainninAlue());
    }
    
    @Test
    public void pelaajanSijainninAlueOikeaLiikkumisenJalkeen() {
        for(int i = 0; i < 5; i++) {
            this.avaruusalus.liikuOikealle();
        }
        assertEquals(new Rectangle(350, 770, 50, 50), this.avaruusalus.getObjektinSijainninAlue());
    }
    
    @Test
    public void pelaajanXKoordinaattiAlleVasemmanRajanMuttaMuuttuuRajaArvoksiKunLiikkuuVasemmalle() {
        Avaruusalus pelaajanAvaruusalus = new Avaruusalus(-50, 770);
        pelaajanAvaruusalus.liikuVasemmalle();
        assertEquals(0, pelaajanAvaruusalus.getX());
    }
    
    @Test
    public void pelaajanXKoordinaattiYliOikeanRajanMuttaMuuttuuRajaArvoksiKunLiikkuuOikealle() {
        Avaruusalus pelaajanAvaruusalus = new Avaruusalus(1000, 770);
        pelaajanAvaruusalus.liikuOikealle();
        assertEquals(595, pelaajanAvaruusalus.getX());
    }
    
    @Test
    public void asettamallaUudetXJaYArvotPelaajallePalautuuUudetArvot() {
        this.avaruusalus.setX(200);
        this.avaruusalus.setY(200);
        assertEquals(200, this.avaruusalus.getX());
        assertEquals(200, this.avaruusalus.getY());
    }
    
    @Test
    public void liikuVasemmalleBooleanOnFalseKunPelaajaLuodaan() {
        assertEquals(false, this.avaruusalus.getLiikuVasemmalle());
    }
    
    @Test
    public void liikuOikealleBooleanOnFalseKunPelaajaLuodaan() {
        assertEquals(false, this.avaruusalus.getLiikuOikealle());
    }
    
    @Test
    public void liikuVasemmalleMuuttuuTrueksiSetteriaKutsumalla() {
        this.avaruusalus.setLiikuVasemmalle(true);
        assertEquals(true, this.avaruusalus.getLiikuVasemmalle());
    }
    
    @Test
    public void liikuOikealleMuuttuuTrueksiSetteriaKutsumalla() {
        this.avaruusalus.setLiikuOikealle(true);
        assertEquals(true, this.avaruusalus.getLiikuOikealle());
    }
    
    @Test
    public void pelaajaSaaPisteenKunKutsutaanLisaaPisteMetodia() {
        this.avaruusalus.lisaaPiste();
        assertEquals(1, this.avaruusalus.getPisteet());
    }
}
