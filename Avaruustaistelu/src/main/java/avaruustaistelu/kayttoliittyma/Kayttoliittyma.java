package avaruustaistelu.kayttoliittyma;

import avaruustaistelu.avaruustaistelu.Avaruustaistelu;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka, jossa luodaan pelin käyttöliittymä.
 * 
 * @author Jyri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame pelinKehykset;
    private final Avaruustaistelu avaruustaistelu;
    private Piirtoalusta piirtoalusta;
    
    /**
     * Luokan konstruktori, joka saa parametrikseen Avaruustaistelu luokan ilmentymän.
     * 
     * @param avaruustaistelu Avaruustaistelu peli
     */
    public Kayttoliittyma(Avaruustaistelu avaruustaistelu) {
        this.avaruustaistelu = avaruustaistelu;
    }
    
    @Override
    public void run() {
        this.pelinKehykset = new JFrame("Avaruustaistelu");
        this.pelinKehykset.setPreferredSize(new Dimension(650, 900));

        this.pelinKehykset.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(this.pelinKehykset.getContentPane());

        this.pelinKehykset.pack();
        this.pelinKehykset.setResizable(false);
        this.pelinKehykset.setVisible(true);
    }
    
    /**
     * Luo piirtoalustan Avaruustaistelu pelille ja lisää näppäimistönkuuntelijan
     * Avaruustaistelu pelin tuntemalle pelaajalle.
     * 
     * @param container Container
     */
    private void luoKomponentit(Container container) {
        this.piirtoalusta = new Piirtoalusta(this.avaruustaistelu);
        container.add(this.piirtoalusta);
        
        this.pelinKehykset.addKeyListener(new NappaimistonKuuntelija(this.avaruustaistelu, this.pelinKehykset));
    }

    public JFrame getFrame() {
        return this.pelinKehykset;
    }
    
    public Piirtoalusta getPiirtoalusta() {
        return this.piirtoalusta;
    }
    
}
