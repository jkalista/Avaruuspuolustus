package Avaruuspuolustus.Kayttoliittyma;

import Avaruuspuolustus.Objektit.Pelaaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Luokka, jossa määritellään miten eri näppäimistön näppäimet käyttäytyvät
 * Avaruuspuolustus pelissä.
 * 
 * @author Jyri
 */
public class NappaimistonKuuntelija implements KeyListener {
    
    Pelaaja pelaaja;
    
    public NappaimistonKuuntelija(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    /**
    * Asettaa pelaajan LiikuOikealle booleanin trueksi silloin, kun painetaan
    * näppäintä "D", ja LiikuVasemmalle booleanin trueksi silloin, kun painetaan
    * näppäintä "A".
    *
    * @param e
    */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.pelaaja.setLiikuOikealle(true);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.pelaaja.setLiikuVasemmalle(true);
        }
        
    }

    /**
    * Asettaa pelaajan LiikuOikealle booleanin falseksi silloin, kun nostetaan
    * sormi näppäimeltä "D", ja LiikuVasemmalle booleanin falseksi silloin, kun
    * nostetaan sormi näppäimeltä "A".
    * 
    * Pelaajan avaruusalus ampuu ohjuksen silloin, kun nostetaan sormi näppäimeltä
    * "H".
    * 
    * @param e 
    */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.pelaaja.setLiikuOikealle(false);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.pelaaja.setLiikuVasemmalle(false);
        }
        
        
        if (e.getKeyCode() == KeyEvent.VK_H) {
            this.pelaaja.ammuOhjus();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
}
