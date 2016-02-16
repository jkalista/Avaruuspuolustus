package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.objektit.Avaruusalus;
import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import avaruustaistelu.objektit.Ohjus;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Luokka, joka sisältää metodit kaikkien "Avaruustaistelu" -pelin pelialueella liikkuvien objektien poistamiseen.
 * 
 * @author Jyri
 */
public class ObjektienPoistaja {
    
    private final Avaruustaistelu avaruustaistelu;
    
    public ObjektienPoistaja(Avaruustaistelu avaruustaistelu) {
        this.avaruustaistelu = avaruustaistelu;
    }
    
    /**
     * Poistaa ohjukset, jotka eivät ole enää pelialueella.
     */
    public void poistaAlueeltaPoistuneetOhjukset() {
        ArrayList<Ohjus> poistettavatOhjukset = new ArrayList<>();
        
        for (Ohjus ohjus : this.avaruustaistelu.getAvaruusalus().getOhjukset()) {
            if (ohjus.getY() <= -15) {
                poistettavatOhjukset.add(ohjus);
            }
        }
        
        this.avaruustaistelu.getAvaruusalus().getOhjukset().removeAll(poistettavatOhjukset);
    }
    
    /**
     * Poistaa elämäpaketit, jotka eivät ole enää pelialueella.
     */
    public void poistaAlueeltaPoistuneetElamapaketit() {
        ArrayList<Elamapaketti> poistettavatElamapaketit = new ArrayList<>();
        
        for (Elamapaketti elamapaketti : this.avaruustaistelu.getElamapaketit()) {
            if (elamapaketti.getY() >= 900) {
                poistettavatElamapaketit.add(elamapaketti);
            }
        }
        
        this.avaruustaistelu.getElamapaketit().removeAll(poistettavatElamapaketit);
    }
    
    /**
     * Poistaa meteoroidit, jotka eivät ole enää pelialueella. Vähentää yhden elämäpisteen avaruusalukselta jokaista poistunutta meteoroidia kohden.
     */
    public void poistaAlueeltaPoistuneetMeteoroiditJaMenetaElamapisteAvaruusalukselta() {
        ArrayList<Meteoroidi> poistettavatMeteoroidit = new ArrayList<>();
        
        for (Meteoroidi meteoroidi : this.avaruustaistelu.getMeteoroidit()) {
            if (meteoroidi.getY() >= 900) {
                poistettavatMeteoroidit.add(meteoroidi);
                this.avaruustaistelu.getAvaruusalus().menetaElamapiste();
            }
        }
        
        this.avaruustaistelu.getMeteoroidit().removeAll(poistettavatMeteoroidit);
    }
    
    /**
     * Poistaa tuhoutuneet meteoroidit (Meteoroidi, jolla 0 elämäpistettä). Lisää yhden pisteen pelaajalle.
     * Vaikeuttaa peliä kutsumalla metodia, joka lyhentää uuden meteoroidin luovan ajastimen viivettä.
     */
    public void poistaTuhoutuneetMeteoroidit() {
        ArrayList<Meteoroidi> tuhoutuneetMeteoroidit = new ArrayList<>();
        
        for (Meteoroidi meteoroidi : this.avaruustaistelu.getMeteoroidit()) {
            if (meteoroidi.getElamapisteet() == 0) {
                tuhoutuneetMeteoroidit.add(meteoroidi);
                this.avaruustaistelu.getAvaruusalus().lisaaPiste();
                this.avaruustaistelu.vaikeutaPeliaLyhentamallaUudenMeteoroidinAjastimenAikaa();
            }
        }
        
        this.avaruustaistelu.getMeteoroidit().removeAll(tuhoutuneetMeteoroidit);
    }
    
}
