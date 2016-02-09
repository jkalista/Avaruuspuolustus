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
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Jyri
 */
public class Avaruuspuolustus implements ActionListener {
    
    private Piirtoalusta piirtoalusta;
    private final Pelaaja pelaaja;
    private final CopyOnWriteArrayList<Meteoroidi> meteoroidit;
    Timer luoUusiMeteoroidi = new Timer(6000, this);
    private boolean peliKaynnissa;
    Random meteoroidinPaikanArpoja = new Random();
    
    public Avaruuspuolustus() {
        this.pelaaja = new Pelaaja(325, 770);
        this.meteoroidit = new CopyOnWriteArrayList<>();
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
        
        long viimeLoopinAika = System.nanoTime();
        final int tavoiteFPS = 60;
        final long optimaalinenAika = 1000000000 / tavoiteFPS;

        while (this.peliKaynnissa == true) {

            long aikaTallaHetkella = System.nanoTime();
            long updateLength = aikaTallaHetkella - viimeLoopinAika;
            viimeLoopinAika = aikaTallaHetkella;

            if(this.pelaaja.getLiikuOikealle() == true) {
                    this.pelaaja.liikuOikealle();
            } else if(this.pelaaja.getLiikuVasemmalle() == true) {
                    this.pelaaja.liikuVasemmalle();
            }

            paivitaPelia();
            
            this.piirtoalusta.paivita();

            try{
                Thread.sleep((viimeLoopinAika - System.nanoTime() + optimaalinenAika) / 1000000);
            } catch (InterruptedException ex) {
                    Logger.getLogger(Avaruuspuolustus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void paivitaPelia() {
            liikutaOhjuksia();
            liikutaMeteoroideja();
            tarkastaMeteoroidienOsuminenPelaajaan();
            tarkastaOhjustenOsuminenMeteoroideihin();
            poistaTuhoutuneetMeteoroidit();
            poistaAlueeltaPoistuneetOhjukset();
            poistaAlueeltaPoistuneetMeteoroidit();
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
    
    public void tarkastaMeteoroidienOsuminenPelaajaan() {
        for(Meteoroidi meteoroidi : this.meteoroidit) {
            if(meteoroidi.getObjektinSijainninAlue().intersects(this.pelaaja.getObjektinSijainninAlue())) {
                this.peliKaynnissa = false;
            }
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
    
    public CopyOnWriteArrayList<Meteoroidi> getMeteoroidit() {
        return this.meteoroidit;
    }
    
    public boolean getPeliKaynnissa() {
        return this.peliKaynnissa;
    }
    
    public void setPeliKaynnissa(boolean peliKaynnissa) {
        this.peliKaynnissa = peliKaynnissa;
    }
}
