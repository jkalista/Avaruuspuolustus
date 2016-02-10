package Avaruuspuolustus.Objektit;

import Avaruuspuolustus.TiedostojenKasittely.TiedostojenKasittelija;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Luokka sisältää kaikki pelaajan ohjaamaan avaruusalukseen liittyvät tiedot
 * ja metodit.
 * 
 * @author Jyri
 */
public class Pelaaja extends Objekti {

    TiedostojenKasittelija tiedostojenKasittelija = new TiedostojenKasittelija();
    
    private final CopyOnWriteArrayList<Ohjus> ohjukset;
    private boolean liikuOikealle;
    private boolean liikuVasemmalle;
    private int pisteet;
    
    public Pelaaja(int x, int y) {
        super(x,y);
        this.ohjukset = new CopyOnWriteArrayList<>();
        this.liikuOikealle = false;
        this.liikuVasemmalle = false;
        this.pisteet = 0;        
    }
    
    /**
    * Liikuttaa avaruusalusta oikealle silloin, kun ei olla ylitetty oikeaa rajaa.
    */
    public void liikuOikealle() {
        this.x = this.x + 5;
        
        if(this.x > 595) {
            this.x = 595;
        }
    }
    
    /**
    * Liikuttaa avaruusalusta vasemmalle silloin, kun ei olla ylitetty vasenta rajaa.
    */
    public void liikuVasemmalle() {
        this.x = this.x - 5;
        
        if(this.x < 0) {
            this.x = 0;
        }
    }
    
    /**
     * Piirtää pelaajan avaruusaluksen kuvan TiedostojenKasittelijan antaman kuvatiedoston perusteella.
     * 
     * @param g 
     */
    @Override
    public void piirra(Graphics g) {
        g.drawImage(this.tiedostojenKasittelija.getAvaruusaluksenKuva(), this.x, this.y, null);
    }

    /**
    * Palauttaa sen alueen, missä pelaajan avaruusalus sillä hetkellä sijaitsee. Tätä tietoa käytetään,
    * kun tutkitaan koskettavatko eri objektit toisiaan "intersects" -metodin avulla.
    * 
    * @return 
    */
    @Override
    public Rectangle getObjektinSijainninAlue() {
        return new Rectangle(this.x, this.y, 50, 50);
    }
    
    /**
    * Lisää ohjuksen pelaajan ohjuksia sisältävään CopyOnWriteArrayListiin.
    */
    public void ammuOhjus() {
        this.ohjukset.add(new Ohjus(this.x + 25, this.y - 15));
    }
    
    public CopyOnWriteArrayList<Ohjus> getOhjukset() {
        return this.ohjukset;
    }
    
    /**
    * Lisää pelaajalle yhden pisteen.
    */
    public void lisaaPiste() {
        this.pisteet = this.pisteet + 1;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public boolean getLiikuOikealle() {
        return this.liikuOikealle;
    }
    
    public void setLiikuOikealle(boolean liikuOikealle) {
        this.liikuOikealle = liikuOikealle;
    }
    
    public boolean getLiikuVasemmalle() {
        return this.liikuVasemmalle;
    }
    
    public void setLiikuVasemmalle(boolean liikuVasemmalle) {
        this.liikuVasemmalle = liikuVasemmalle;
    }
}
