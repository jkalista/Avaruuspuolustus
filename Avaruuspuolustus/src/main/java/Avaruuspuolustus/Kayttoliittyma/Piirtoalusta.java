package Avaruuspuolustus.Kayttoliittyma;

import Avaruuspuolustus.Avaruuspuolustus.Avaruuspuolustus;
import Avaruuspuolustus.Objektit.Ohjus;
import java.awt.Color;
import java.awt.Dimension;
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
        this.avaruuspuolustus.getPelaaja().piirra(g);
        piirraOhjukset(g);
    }
    
    public void piirraOhjukset(Graphics g) {
        for(Ohjus ohjus : this.avaruuspuolustus.getPelaaja().getOhjukset()) {
            ohjus.piirra(g);
        }
    }
    
}
