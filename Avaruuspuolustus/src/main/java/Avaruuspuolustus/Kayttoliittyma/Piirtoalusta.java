package Avaruuspuolustus.Kayttoliittyma;

import Avaruuspuolustus.Avaruuspuolustus.Avaruuspuolustus;
import java.awt.Color;
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.avaruuspuolustus.getPelaaja().piirra(g);
    }
    
}
