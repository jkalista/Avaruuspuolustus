package Avaruuspuolustus.Objektit;

import Avaruuspuolustus.TiedostojenKasittely.TiedostojenKasittelija;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Jyri
 */
public class Pelaaja extends Objekti {

    TiedostojenKasittelija tiedostojenKasittelija = new TiedostojenKasittelija();
    
    private CopyOnWriteArrayList<Ohjus> ohjukset;
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
    
    public void liikuOikealle() {
        this.x = this.x + 5;
        
        if(this.x > 595) {
            this.x = 595;
        }
    }
    
    public void liikuVasemmalle() {
        this.x = this.x - 5;
        
        if(this.x < 0) {
            this.x = 0;
        }
    }
    
    @Override
    public void piirra(Graphics g) {
        //g.setColor(Color.RED);
        //g.fillRect(x, y, 50, 50);
        g.drawImage(this.tiedostojenKasittelija.getAvaruusaluksenKuva(), this.x, this.y, null);
    }

    @Override
    public Rectangle getObjektinSijainninAlue() {
        return new Rectangle(this.x, this.y, 50, 50);
    }
    
    public void ammuOhjus() {
        this.ohjukset.add(new Ohjus(this.x + 25, this.y - 15));
    }
    
    public CopyOnWriteArrayList<Ohjus> getOhjukset() {
        return this.ohjukset;
    }
    
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
