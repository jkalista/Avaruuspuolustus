package avaruustaistelu.kayttoliittyma;

import avaruustaistelu.objektit.Avaruusalus;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Luokka, jossa määritellään miten eri näppäimistön näppäimet käyttäytyvät
 * Avaruustaistelu pelissä.
 * 
 * @author Jyri
 */
public class NappaimistonKuuntelija implements KeyListener {
    
    Avaruusalus avaruusalus;
    
    public NappaimistonKuuntelija(Avaruusalus avaruusalus) {
        this.avaruusalus = avaruusalus;
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
            this.avaruusalus.setLiikuOikealle(true);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.avaruusalus.setLiikuVasemmalle(true);
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
            this.avaruusalus.setLiikuOikealle(false);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.avaruusalus.setLiikuVasemmalle(false);
        }
        
        
        if (e.getKeyCode() == KeyEvent.VK_H) {
            this.avaruusalus.ammuOhjus();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
}
