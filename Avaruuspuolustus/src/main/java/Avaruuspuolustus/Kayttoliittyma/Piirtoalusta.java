package Avaruuspuolustus.Kayttoliittyma;

import Avaruuspuolustus.Avaruuspuolustus.Avaruuspuolustus;
import Avaruuspuolustus.Objektit.Meteoroidi;
import Avaruuspuolustus.Objektit.Ohjus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Jyri
 */
public class Piirtoalusta extends JPanel {
    
    private Avaruuspuolustus avaruuspuolustus;
    
    public Piirtoalusta(Avaruuspuolustus avaruuspuolustus) {
        super.setBackground(Color.BLACK);
        this.avaruuspuolustus = avaruuspuolustus;
    }
    
    public void paivita() {
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);        
        piirraPelaaja(g);
        piirraOhjukset(g);
        piirraMeteoroidit(g);
        piirraPelaajanPisteet(g);
    }
    
    public void piirraPelaaja(Graphics g) {
        this.avaruuspuolustus.getPelaaja().piirra(g);
    }
    
    public void piirraPelaajanPisteet(Graphics g) {
        g.setFont(new Font("BAZOOKA", Font.BOLD, 24));
        g.setColor(Color.WHITE);
        g.drawString("Pisteet: " + Integer.toString(this.avaruuspuolustus.getPelaaja().getPisteet()), 510, 30);
    }
    
    public void piirraOhjukset(Graphics g) {
        for(Ohjus ohjus : this.avaruuspuolustus.getPelaaja().getOhjukset()) {
            ohjus.piirra(g);
        }
    }
    
    public void piirraMeteoroidit(Graphics g) {
        for(Meteoroidi meteoroidi : this.avaruuspuolustus.getMeteoroidit()) {
            meteoroidi.piirra(g);
        }
    }
    
}
