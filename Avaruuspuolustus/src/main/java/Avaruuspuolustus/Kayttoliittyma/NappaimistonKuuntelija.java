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
    Component komponentti;
    
    public NappaimistonKuuntelija(Pelaaja pelaaja, Component komponentti) {
        this.pelaaja = pelaaja;
        this.komponentti = komponentti;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) {
            this.pelaaja.liiku(5);
        } else if(e.getKeyCode() == KeyEvent.VK_A) {
            this.pelaaja.liiku(-5);
        }
        
        this.komponentti.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
