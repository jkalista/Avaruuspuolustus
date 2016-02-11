package Avaruuspuolustus.Kayttoliittyma;

import Avaruuspuolustus.Avaruuspuolustus.Avaruuspuolustus;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka, jossa luodaan käyttöliittymä ja sen komponentit.
 * 
 * @author Jyri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame pelinKehykset;
    private final Avaruuspuolustus avaruuspuolustus;
    private Piirtoalusta piirtoalusta;
    
    public Kayttoliittyma(Avaruuspuolustus avaruuspuolustus) {
        this.avaruuspuolustus = avaruuspuolustus;
    }
    
    @Override
    public void run() {
        this.pelinKehykset = new JFrame("Avaruuspuolustus");
        this.pelinKehykset.setPreferredSize(new Dimension(650, 900));

        this.pelinKehykset.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(this.pelinKehykset.getContentPane());

        this.pelinKehykset.pack();
        this.pelinKehykset.setResizable(false);
        this.pelinKehykset.setVisible(true);
    }
    
    /**
    * Luo piirtoalustan Avaruuspuolustus pelille ja lisää näppäimistönkuuntelijan
    * Avaruuspuolustus pelin tuntemalle pelaajalle.
    * 
    * @param container 
    */
    private void luoKomponentit(Container container) {
        this.piirtoalusta = new Piirtoalusta(this.avaruuspuolustus);
        container.add(this.piirtoalusta);
         
        this.pelinKehykset.addKeyListener(new NappaimistonKuuntelija(this.avaruuspuolustus.getPelaaja()));
    }

    public JFrame getFrame() {
        return this.pelinKehykset;
    }
    
    public Piirtoalusta getPiirtoalusta() {
        return this.piirtoalusta;
    }
    
}