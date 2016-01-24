package Avaruuspuolustus.Objektit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Jyri
 */
public class Pelaaja extends Objekti {

    private ArrayList<Ohjus> ohjukset;
    
    public Pelaaja(int x, int y) {
        super(x,y);
        
        this.ohjukset = new ArrayList<>();
    }
    
    @Override
    public void liiku(int xKoordinaatinMuutos) {
        this.x = this.x + xKoordinaatinMuutos;
        
        if(this.x < 0) {
            this.x = 0;
        } else if(this.x > 595) {
            this.x = 595;
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
        this.ohjukset.add(new Ohjus(this.x + 25, this.y - 10));
    }
    
    public ArrayList<Ohjus> getOhjukset() {
        return this.ohjukset;
    }
    
}
