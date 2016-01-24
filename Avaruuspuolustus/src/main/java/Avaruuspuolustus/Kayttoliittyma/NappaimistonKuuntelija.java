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
    Component component;
    
    public NappaimistonKuuntelija(Pelaaja pelaaja, Component component) {
        this.pelaaja = pelaaja;
        this.component = component;
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
        
        this.component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_H) {
            pelaaja.ammuOhjus();
        }
        
        this.component.repaint();
    }
    
}
