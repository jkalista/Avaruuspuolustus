package avaruustaistelu.objektit;

import avaruustaistelu.tiedostojenkasittelija.TiedostojenKasittelija;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Luokka, joka sisältää elämäpakettiin liittyvät tiedot ja metodit.
 * 
 * @author Jyri
 */
public class Elamapaketti extends Objekti {

    /**
     * Tiedostojenkäsittelijä, jolla saadaan haettua elämäpaketin kuva.
     */
    TiedostojenKasittelija tiedostojenKasittelija = new TiedostojenKasittelija();
    
    /**
     * Luokan konstruktori, joka saa parametrikseen elämäpaketin x- ja y-koordinaatit.
     * 
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Elamapaketti(int x, int y) {
        super(x, y);
    }
    
    /**
     * Liikuttaa elämäpakettia.
     */
    public void liiku() {
        this.y = this.y + 3;
    }
    
    /**
     * Piirtää elämäpaketin kuvan Tiedostojenkäsittelijän antaman kuvatiedoston perusteella.
     * 
     * @param g Elämäpaketin kuva
     */
    @Override
    public void piirra(Graphics g) {
        g.drawImage(this.tiedostojenKasittelija.getElamapaketinKuva(), this.x, this.y, null);
    }

    /**
     * Palauttaa sen alueen, missä elämäpaketti sillä hetkellä sijaitsee. Tätä tietoa käytetään,
     * kun tutkitaan koskettavatko eri objektit toisiaan "intersects" -metodin avulla.
     * 
     * @return Rectangle Elämäpaketin sijainnin alue
     */
    @Override
    public Rectangle getObjektinSijainninAlue() {
        return new Rectangle(this.x, this.y, 20, 20);
    }
    
}
