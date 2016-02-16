package avaruustaistelu.kayttoliittyma;

import avaruustaistelu.avaruustaistelu.Avaruustaistelu;
import avaruustaistelu.objektit.Avaruusalus;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * Luokka, jossa määritellään miten eri näppäimistön näppäimet käyttäytyvät
 * Avaruustaistelu pelissä.
 * 
 * @author Jyri
 */
public class NappaimistonKuuntelija implements KeyListener {
    
    Avaruustaistelu avaruustaistelu;
    JFrame pelinKehykset;
    
    /**
     * Luokan konstruktori, joka saa parametrikseen Avaruustaistelu pelin, jonka kautta voidaan hakea
     * muun muassa pelaajan ohjaama avaruusalus "getAvaruusalus" -metodin avulla.
     * 
     * @param avaruustaistelu Avaruustaistelu peli
     * @param pelinKehykset JFrame kehykset
     */
    public NappaimistonKuuntelija(Avaruustaistelu avaruustaistelu, JFrame pelinKehykset) {
        this.avaruustaistelu = avaruustaistelu;
        this.pelinKehykset = pelinKehykset;
    }

    /**
     * Asettaa pelaajan avaruusaluksen LiikuOikealle booleanin trueksi silloin, kun painetaan
     * näppäintä "D", ja LiikuVasemmalle booleanin trueksi silloin, kun painetaan
     * näppäintä "A".
     *
     * @param e Alas painettu näppäin
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.avaruustaistelu.getAvaruusalus().setLiikuOikealle(true);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.avaruustaistelu.getAvaruusalus().setLiikuVasemmalle(true);
        }
        
    }

    /**
     * Asettaa pelaajan avaruusaluksen LiikuOikealle booleanin falseksi silloin, kun nostetaan
     * sormi näppäimeltä "D", ja LiikuVasemmalle booleanin falseksi silloin, kun
     * nostetaan sormi näppäimeltä "A".
     * 
     * Pelaajan avaruusalus ampuu ohjuksen silloin, kun nostetaan sormi näppäimeltä
     * "H".
     * 
     * @param e Ylös nostettu näppäin
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.avaruustaistelu.getAvaruusalus().setLiikuOikealle(false);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.avaruustaistelu.getAvaruusalus().setLiikuVasemmalle(false);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_H) {
            this.avaruustaistelu.getAvaruusalus().ammuOhjus();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
}
