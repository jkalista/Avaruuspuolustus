package Avaruuspuolustus.Avaruuspuolustus;

import Avaruuspuolustus.Kayttoliittyma.Piirtoalusta;
import Avaruuspuolustus.Objektit.Ohjus;
import Avaruuspuolustus.Objektit.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Jyri
 */
public class Avaruuspuolustus implements ActionListener {
    
    private Piirtoalusta piirtoalusta;
    private Pelaaja pelaaja;
    private boolean peliKaynnissa;
    
    public Avaruuspuolustus() {
        this.pelaaja = new Pelaaja(325, 770);
        this.peliKaynnissa = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public void pelinLoop() {
        
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        while (this.peliKaynnissa == true) {

            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            if(pelaaja.liikuOikealle == true) {
                    pelaaja.liikuOikealle();
            } else if(pelaaja.liikuVasemmalle == true) {
                    pelaaja.liikuVasemmalle();
            }

            liikutaOhjuksia();

            this.piirtoalusta.paivita();

            try{
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Avaruuspuolustus.class.getName()).log(Level.SEVERE, null, ex);
            };

        }
        
    }
    
    public void liikutaOhjuksia() {
        for(Ohjus ohjus : this.pelaaja.getOhjukset()) {
            ohjus.liiku(-10);
        }
    }
    
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }
    
    public void setPiirtoalusta(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
    }
}
