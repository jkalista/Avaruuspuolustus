package avaruustaistelu.objektit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Luokka, joka sisältää meteoroidiin liittyvät tiedot ja metodit.
 * 
 * @author Jyri
 */
public class Meteoroidi extends Objekti {

    private int elamapisteet;
    
    public Meteoroidi(int x, int y) {
        super(x, y);
        this.elamapisteet = 5;
    }
    
    /**
     * Liikuttaa meteoroidia.
     */
    public void liiku() {
        this.y = this.y + 1;
    }
    
    /**
     * Piirtää meteoroidin sen elämäpisteiden mukaan, eli mitä vähemmän elämäpisteitä,
     * niin sitä pienempi meteoroidi on.
     * 
     * @param g Meteoroidin grafiikka
     */
    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(this.x, this.y, 15 + this.elamapisteet * 5, 15 + this.elamapisteet * 5);
    }

    /**
     * Palauttaa sen alueen, missä meteoroidi sillä hetkellä sijaitsee. Palautetun alueen
     * kokoon vaikuttaa luonnollisesti elämäpisteiden määrä, sillä meteoroidi on sitä
     * pienempi, mitä vähemmän sillä on elämäpisteitä. Tätä tietoa käytetään,
     * kun tutkitaan koskettavatko eri objektit toisiaan "intersects" -metodin avulla.
     * 
     * @return Rectangle Meteoroidin sijainnin alue
     */
    @Override
    public Rectangle getObjektinSijainninAlue() {
        return new Rectangle(this.x, this.y, 15 + this.elamapisteet * 5, 15 + this.elamapisteet * 5);
    }
    
    /**
     * Vähentää meteoroidilta yhden elämäpisteen.
     */
    public void menetaElamapiste() {
        this.elamapisteet = this.elamapisteet - 1;
    }
    
    public int getElamapisteet() {
        return this.elamapisteet;
    }
    
    public void setElamapisteet(int elamapisteet) {
        this.elamapisteet = elamapisteet;
    }
    
}
