package avaruustaistelu.objektit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Luokka, joka sisältää pelaajan ohjaaman avaruusaluksen ampumaan ohjukseen liittyvät tiedot ja metodit.
 * 
 * @author Jyri
 */
public class Ohjus extends Objekti {

    /**
     * Luokan konstruktori, joka saa parametrikseen ohjuksen x- ja y-koordinaatit.
     * 
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Ohjus(int x, int y) {
        super(x, y);
    }
    
    /**
     * Liikuttaa ohjusta.
     */
    public void liiku() {
        this.y = this.y - 5;
    }

    /**
     * Piirtää ohjuksen, eli siihen kuuluvat harmaan ja punaisen alueen.
     * 
     * @param g Ohjuksen grafiikka
     */
    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 5, 10);
        g.setColor(Color.RED);
        g.fillRect(x, y + 10, 5, 5);
    }

    /**
     * Palauttaa sen alueen, missä ohjus sillä hetkellä sijaitsee. Tätä tietoa käytetään,
     * kun tutkitaan koskettavatko eri objektit toisiaan "intersects" -metodin avulla.
     * 
     * @return Rectangle Ohjuksen sijainnin alue
     */
    @Override
    public Rectangle getObjektinSijainninAlue() {
        return new Rectangle(this.x, this.y, 5, 15);
    }
    
}
