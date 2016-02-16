package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import avaruustaistelu.objektit.Ohjus;
import java.util.ArrayList;

/**
 * Luokka, joka sisältää metodit kaikkien "Avaruustaistelu" -pelin pelialueella liikkuvien objektien yhteentörmäysten tarkastamiseen ja
 * avaruusaluksen elämäpisteiden tarkastamiseen.
 * 
 * @author Jyri
 */
public class ObjektienTarkastaja {
    
    private final Avaruustaistelu avaruustaistelu;
    
    public ObjektienTarkastaja(Avaruustaistelu avaruustaistelu) {
        this.avaruustaistelu = avaruustaistelu;
    }
    
    /**
     * Tarkastaa elämäpakettien osumisen pelaajan avaruusalukseen. Jos elämäpaketti osuu avaruusalukseen, niin avaruusalus saa yhden elämäpisteen.
     */
    public void tarkastaElamapakettienOsuminenAvaruusalukseen() {
        ArrayList<Elamapaketti> avaruusalukseenOsuneetElamapaketit = new ArrayList<>();
        
        for (Elamapaketti elamapaketti : this.avaruustaistelu.getElamapaketit()) {
            if (elamapaketti.getObjektinSijainninAlue().intersects(this.avaruustaistelu.getAvaruusalus().getObjektinSijainninAlue())) {
                this.avaruustaistelu.getAvaruusalus().lisaaElamapiste();
                avaruusalukseenOsuneetElamapaketit.add(elamapaketti);
            }
        }
        this.avaruustaistelu.getElamapaketit().removeAll(avaruusalukseenOsuneetElamapaketit);
    }
    
    /**
     * Tarkastaa meteoroidien osumisen pelaajan avaruusalukseen. Jos meteoroidi osuu avaruusalukseen, niin peliKäynnissä boolean muuttuu falseksi.
     */
    public void tarkastaMeteoroidienOsuminenAvaruusalukseen() {
        for (Meteoroidi meteoroidi : this.avaruustaistelu.getMeteoroidit()) {
            if (meteoroidi.getObjektinSijainninAlue().intersects(this.avaruustaistelu.getAvaruusalus().getObjektinSijainninAlue())) {
                this.avaruustaistelu.setPeliKaynnissa(false);
            }
        }
    }
    
    /**
     * Muuttaa peliKaynnissa booleanin falseksi, jos pelaajan avaruusaluksen elämäpisteet ovat nolla.
     */
    public void tarkastaAvaruusaluksenElamapisteidenMeneminenNollaan() {
        if (this.avaruustaistelu.getAvaruusalus().getElamapisteet() == 0) {
            this.avaruustaistelu.setPeliKaynnissa(false);
        }
    }
    
    /**
     * Tarkastaa pelaajan avaruusaluksen ampumien ohjusten osumisen meteoroideihin vertaamalla ohjusten ja meteoroidien sijaintia
     * toisiinsa. Jos ohjus osuu meteoroidiin, niin ohjus tuhoutuu ja meteoroidi menettää yhden elämäpisteen.
     */
    public void tarkastaOhjustenOsuminenMeteoroideihin() {
        ArrayList<Ohjus> meteoroidiinOsuneetOhjukset = new ArrayList<>();
        
        for (Meteoroidi meteoroidi : this.avaruustaistelu.getMeteoroidit()) {
            for (Ohjus ohjus : this.avaruustaistelu.getAvaruusalus().getOhjukset()) {
                if (ohjus.getObjektinSijainninAlue().intersects(meteoroidi.getObjektinSijainninAlue())) {
                    meteoroidi.menetaElamapiste();
                    meteoroidiinOsuneetOhjukset.add(ohjus);
                }
            }
        }
        this.avaruustaistelu.getAvaruusalus().getOhjukset().removeAll(meteoroidiinOsuneetOhjukset);
    }
    
}
