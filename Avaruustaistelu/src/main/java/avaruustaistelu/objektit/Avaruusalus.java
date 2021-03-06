package avaruustaistelu.objektit;

import avaruustaistelu.tiedostojenkasittelija.TiedostojenKasittelija;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Luokka sisältää kaikki pelaajan ohjaamaan avaruusalukseen liittyvät tiedot
 * ja metodit.
 * 
 * @author Jyri
 */
public class Avaruusalus extends Objekti {
    
    private final CopyOnWriteArrayList<Ohjus> ohjukset;
    private boolean liikuOikealle;
    private boolean liikuVasemmalle;
    private int elamapisteet;
    private int pisteet;
    private BufferedImage avaruusaluksenKuva;
    
    /**
     * Luokan konstruktori, joka saa parametrikseen avaruusaluksen x- ja y-koordinaatit. Lisäksi konstruktori asettaa
     * liikuOikealle ja liikuVasemmalle booleanit falseksi, elämäpisteet viitoseksi (5) ja pisteet nollaksi (0).
     * 
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Avaruusalus(int x, int y) {
        super(x, y);
        this.ohjukset = new CopyOnWriteArrayList<>();
        this.liikuOikealle = false;
        this.liikuVasemmalle = false;
        this.elamapisteet = 5;
        this.pisteet = 0;        
    }
    
    /**
     * Liikuttaa pelaajan avaruusalusta oikealle silloin, kun ei olla ylitetty oikeaa rajaa.
     */
    public void liikuOikealle() {
        if (this.x == 595) {
            return;
        } else {
            this.x = this.x + 5;
        }
    }
    
    /**
     * Liikuttaa pelaajan avaruusalusta vasemmalle silloin, kun ei olla ylitetty vasenta rajaa.
     */
    public void liikuVasemmalle() {
        if (this.x == 0) {
            return;
        } else {
            this.x = this.x - 5;
        }
    }
    
    /**
     * Piirtää pelaajan avaruusaluksen kuvan, joka asetetaan setAvaruusaluksenKuva -metodilla Avaruustaistelu luokan
     * konstruktorissa.
     * 
     * @param g Avaruusaluksen grafiikka
     */
    @Override
    public void piirra(Graphics g) {
        g.drawImage(this.avaruusaluksenKuva, this.x, this.y, null);
    }

    /**
     * Palauttaa sen alueen, missä pelaajan avaruusalus sillä hetkellä sijaitsee. Tätä tietoa käytetään,
     * kun tutkitaan koskettavatko eri objektit toisiaan "intersects" -metodin avulla.
     * 
     * @return Rectangle Avaruusaluksen sijainnin alue
     */
    @Override
    public Rectangle getObjektinSijainninAlue() {
        return new Rectangle(this.x, this.y, 50, 50);
    }
    
    /**
     * Lisää ohjuksen pelaajan avaruusaluksen ohjuksia sisältävään CopyOnWriteArrayListiin.
     */
    public void ammuOhjus() {
        this.ohjukset.add(new Ohjus(this.x + 25, this.y - 15));
    }
    
    public CopyOnWriteArrayList<Ohjus> getOhjukset() {
        return this.ohjukset;
    }
    
    /**
     * Lisää pelaajan avaruusalukselle yhden pisteen.
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
    
    /**
     * Vähentää pelaajan avaruusalukselta yhden elämäpisteen.
     */
    public void menetaElamapiste() {
        this.elamapisteet = this.elamapisteet - 1;
    }
    
    /**
     * Lisää pelaajan avaruusalukselle yhden elämäpisteen, jos elämäpisteet
     * eivät ole täynnä (maksimi elämäpisteet ovat 5).
     */
    public void lisaaElamapiste() {
        if (this.elamapisteet < 5) {
            this.elamapisteet = this.elamapisteet + 1;
        }
    }
    
    public int getElamapisteet() {
        return this.elamapisteet;
    }
    
    public void setElamapisteet(int elamapisteet) {
        this.elamapisteet = elamapisteet;
    }
    
    public void setAvaruusaluksenKuva(BufferedImage avaruusaluksenKuva) {
        this.avaruusaluksenKuva = avaruusaluksenKuva;
    }
}
