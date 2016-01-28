package Avaruuspuolustus.Objektit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author Jyri
 */
public class Pelaaja extends Objekti {

    private ArrayList<Ohjus> ohjukset;
    private boolean liikuOikealle;
    private boolean liikuVasemmalle;
    
    public Pelaaja(int x, int y) {
        super(x,y);
        this.ohjukset = new ArrayList<>();
        this.liikuOikealle = false;
        this.liikuVasemmalle = false;
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
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    @Override
    public Rectangle getEsineenSijainninAlue() {
        return new Rectangle(this.x, this.y, 50, 50);
    }
    
    public void ammuOhjus() {
        this.ohjukset.add(new Ohjus(this.x + 25, this.y - 15));
    }
    
    public ArrayList<Ohjus> getOhjukset() {
        return this.ohjukset;
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
