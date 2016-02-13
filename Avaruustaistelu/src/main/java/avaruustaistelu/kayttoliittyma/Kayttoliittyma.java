package avaruustaistelu.kayttoliittyma;

import avaruustaistelu.avaruustaistelu.Avaruustaistelu;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka, jossa luodaan käyttöliittymä.
 * 
 * @author Jyri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame pelinKehykset;
    private final Avaruustaistelu avaruustaistelu;
    private Piirtoalusta piirtoalusta;
    
    public Kayttoliittyma(Avaruustaistelu avaruustaistelu) {
        this.avaruustaistelu = avaruustaistelu;
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
    * @param container Container
    */
    private void luoKomponentit(Container container) {
        this.piirtoalusta = new Piirtoalusta(this.avaruustaistelu);
        container.add(this.piirtoalusta);
         
        this.pelinKehykset.addKeyListener(new NappaimistonKuuntelija(this.avaruustaistelu.getAvaruusalus()));
    }

    public JFrame getFrame() {
        return this.pelinKehykset;
    }
    
    public Piirtoalusta getPiirtoalusta() {
        return this.piirtoalusta;
    }
    
}
