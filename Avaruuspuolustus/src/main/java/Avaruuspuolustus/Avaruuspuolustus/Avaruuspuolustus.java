package Avaruuspuolustus.Avaruuspuolustus;

import Avaruuspuolustus.Kayttoliittyma.Piirtoalusta;
import Avaruuspuolustus.Objektit.Meteoroidi;
import Avaruuspuolustus.Objektit.Ohjus;
import Avaruuspuolustus.Objektit.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
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
    private ArrayList<Meteoroidi> meteoroidit;
    Timer luoUusiMeteoroidi = new Timer(6000, this);
    private boolean peliKaynnissa;
    Random meteoroidinPaikanArpoja = new Random();
    
    public Avaruuspuolustus() {
        this.pelaaja = new Pelaaja(325, 770);
        this.meteoroidit = new ArrayList<>();
        this.luoUusiMeteoroidi.start();
        this.peliKaynnissa = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.luoUusiMeteoroidi) {
            this.meteoroidit.add(new Meteoroidi(25 + this.meteoroidinPaikanArpoja.nextInt(117)*5,0));
        }
    }
    
    public void pelinLoop() {
        
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        while (this.peliKaynnissa == true) {

            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            if(this.pelaaja.getLiikuOikealle() == true) {
                    this.pelaaja.liikuOikealle();
            } else if(this.pelaaja.getLiikuVasemmalle() == true) {
                    this.pelaaja.liikuVasemmalle();
            }

            poistaAlueeltaPoistuneetOhjukset();
            poistaAlueeltaPoistuneetMeteoroidit();
            liikutaOhjuksia();
            liikutaMeteoroideja();
            tarkastaOhjustenOsuminenMeteoroideihin();
            poistaTuhoutuneetMeteoroidit();
            
            this.piirtoalusta.paivita();

            try{
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            } catch (InterruptedException ex) {
                    Logger.getLogger(Avaruuspuolustus.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
    
    public void liikutaOhjuksia() {
        for(Ohjus ohjus : this.pelaaja.getOhjukset()) {
            ohjus.liiku();
        }
    }
    
    public void liikutaMeteoroideja() {
        for(Meteoroidi meteoroidi : this.meteoroidit) {
            meteoroidi.liiku();
        }
    }
    
    public void tarkastaOhjustenOsuminenMeteoroideihin() {
        ArrayList<Ohjus> meteoroidiinOsuneetOhjukset = new ArrayList<>();
        
        for(Meteoroidi meteoroidi : this.meteoroidit) {
            for(Ohjus ohjus : this.pelaaja.getOhjukset()) {
                if(ohjus.getObjektinSijainninAlue().intersects(meteoroidi.getObjektinSijainninAlue())) {
                    meteoroidi.menetaElamapiste();
                    meteoroidiinOsuneetOhjukset.add(ohjus);
                }
            }
        }
        
        this.pelaaja.getOhjukset().removeAll(meteoroidiinOsuneetOhjukset);
    }
    
    public void poistaTuhoutuneetMeteoroidit() {
        ArrayList<Meteoroidi> tuhoutuneetMeteoroidit = new ArrayList<>();
        
        for(Meteoroidi meteoroidi : this.meteoroidit) {
            if(meteoroidi.getElamapisteet() == 0) {
                tuhoutuneetMeteoroidit.add(meteoroidi);
                this.pelaaja.lisaaPiste();
            }
        }
        
        this.meteoroidit.removeAll(tuhoutuneetMeteoroidit);
    }
        
    public void poistaAlueeltaPoistuneetOhjukset() {
        ArrayList<Ohjus> poistettavat = new ArrayList<>();
        for(Ohjus ohjus : this.pelaaja.getOhjukset()) {
            if(ohjus.getY() == -15) {
                poistettavat.add(ohjus);
            }
        }
        this.pelaaja.getOhjukset().removeAll(poistettavat);
    }
    
    public void poistaAlueeltaPoistuneetMeteoroidit() {
        ArrayList<Meteoroidi> poistettavat = new ArrayList<>();
        for(Meteoroidi meteoroidi : this.meteoroidit) {
            if(meteoroidi.getY() == 900) {
                poistettavat.add(meteoroidi);
            }
        }
        this.meteoroidit.removeAll(poistettavat);
    }
    
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }
    
    public void setPiirtoalusta(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
    }
    
    public ArrayList<Meteoroidi> getMeteoroidit() {
        return this.meteoroidit;
    }
    
    public boolean getPeliKaynnissa() {
        return this.peliKaynnissa;
    }
    
    public void setPeliKaynnissa(boolean peliKaynnissa) {
        this.peliKaynnissa = peliKaynnissa;
    }
}
