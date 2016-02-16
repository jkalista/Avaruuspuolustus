package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import avaruustaistelu.objektit.Ohjus;

/**
 * Luokka, joka sisältää metodit kaikkien "Avaruustaistelu" -pelin pelialueella liikkuvien objektien siirtämiseen.
 * 
 * @author Jyri
 */
public class ObjektienSiirtaja {
    
    private final Avaruustaistelu avaruustaistelu;
    
    /**
     * Luokan konstruktori, joka saa parametrikseen Avaruustaistelu pelin.
     * 
     * @param avaruustaistelu Avaruustaistelu
     */
    public ObjektienSiirtaja(Avaruustaistelu avaruustaistelu) {
        this.avaruustaistelu = avaruustaistelu;
    }
    
    /**
     * Tarkistaa, onko avaruusaluksen liikuOikealle tai liikuVasemmalle booleanit true, ja kutsuu myönteisessä tapauksessa
     * liikuOikealle tai liikuVasemmalle metodia.
     */
    public void liikutaAvaruusalusta() {
        if (this.avaruustaistelu.getAvaruusalus().getLiikuOikealle() == true) {
            this.avaruustaistelu.getAvaruusalus().liikuOikealle();
        } else if (this.avaruustaistelu.getAvaruusalus().getLiikuVasemmalle() == true) {
            this.avaruustaistelu.getAvaruusalus().liikuVasemmalle();
        }
    }
    
    /**
     * Kutsuu liikkumismetodia kaikille pelissä oleville ohjuksille.
     */
    public void liikutaOhjuksia() {
        for (Ohjus ohjus : this.avaruustaistelu.getAvaruusalus().getOhjukset()) {
            ohjus.liiku();
        }
    }
    
    /**
     * Kutsuu liikkumismetodia kaikille pelissä oleville meteoroideille.
     */
    public void liikutaMeteoroideja() {
        for (Meteoroidi meteoroidi : this.avaruustaistelu.getMeteoroidit()) {
            meteoroidi.liiku();
        }
    }
    
    /**
     * Kutsuu liikkumismetodia kaikille pelissä oleville elämäpaketeille.
     */
    public void liikutaElamapaketteja() {
        for (Elamapaketti elamapaketti : this.avaruustaistelu.getElamapaketit()) {
            elamapaketti.liiku();
        }
    }
}
