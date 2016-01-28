package Avaruuspuolustus.Kayttoliittyma;

import Avaruuspuolustus.Objektit.Pelaaja;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Jyri
 */
public class NappaimistonKuuntelija implements KeyListener {
    
    Pelaaja pelaaja;
    
    public NappaimistonKuuntelija(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) {
            this.pelaaja.setLiikuOikealle(true);
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            this.pelaaja.setLiikuVasemmalle(true);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) {
            this.pelaaja.setLiikuOikealle(false);
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            this.pelaaja.setLiikuVasemmalle(false);
        }
        
        
        if (e.getKeyCode() == KeyEvent.VK_H) {
            this.pelaaja.ammuOhjus();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
}