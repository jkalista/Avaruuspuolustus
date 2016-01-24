package Avaruuspuolustus.Avaruuspuolustus;

import Avaruuspuolustus.Kayttoliittyma.Piirtoalusta;
import Avaruuspuolustus.Objektit.Ohjus;
import Avaruuspuolustus.Objektit.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Jyri
 */
public class Avaruuspuolustus implements ActionListener {
    
    Timer uudelleenPiirto = new Timer(50, this);
    private Piirtoalusta piirtoalusta;
    private Pelaaja pelaaja;
    
    public Avaruuspuolustus() {
        this.pelaaja = new Pelaaja(325, 770);
        
        this.uudelleenPiirto.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.uudelleenPiirto) {
            liikutaOhjuksia();
        }
        
        //this.piirtoalusta.paivita();
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
