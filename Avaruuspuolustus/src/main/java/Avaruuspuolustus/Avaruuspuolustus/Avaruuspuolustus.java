package Avaruuspuolustus.Avaruuspuolustus;

import Avaruuspuolustus.Objektit.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jyri
 */
public class Avaruuspuolustus implements ActionListener {
    
    private Pelaaja pelaaja;
    
    public Avaruuspuolustus() {
        this.pelaaja = new Pelaaja(325, 770);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }
}
