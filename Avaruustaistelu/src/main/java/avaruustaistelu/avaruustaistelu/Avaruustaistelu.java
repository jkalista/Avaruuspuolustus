package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.kayttoliittyma.Piirtoalusta;
import avaruustaistelu.objektit.Avaruusalus;
import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import avaruustaistelu.objektit.Ohjus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * Luokka, joka sisältää Avaruustaistelu peliin liittyvät tiedot ja metodit.
 * 
 * @author Jyri
 */
public class Avaruustaistelu implements ActionListener {
    
    private Piirtoalusta piirtoalusta;
    private final Avaruusalus avaruusalus;
    private final CopyOnWriteArrayList<Meteoroidi> meteoroidit;
    private final CopyOnWriteArrayList<Elamapaketti> elamapaketit;
    Timer luoUusiMeteoroidi = new Timer(5000, this);
    Timer luoUusiElamapaketti = new Timer(8000, this);
    private boolean peliKaynnissa;
    Random meteoroidinJaElamapaketinPaikanArpoja = new Random();
    
    /**
     * Luokan konstruktori, jossa luodaan pelille avaruusalus, meteoroidi lista, elamapaketit lista, käynnistetään ajastimet ja asetetaan peliKaynnissa trueksi.
     */
    public Avaruustaistelu() {
        this.avaruusalus = new Avaruusalus(325, 770);
        this.meteoroidit = new CopyOnWriteArrayList<>();
        this.elamapaketit = new CopyOnWriteArrayList<>();
        this.luoUusiMeteoroidi.start();
        this.luoUusiElamapaketti.start();
        this.peliKaynnissa = true;
    }

    /**
     * Luo peliin uuden meteoroidin "luoUusiMeteoroidi" -ajastimen viiveen mukaan ja uuden elämäpaketin "luoUusiElamapaketti" -ajastimen viiveen mukaan.
     * 
     * @param e Ajastin
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.luoUusiMeteoroidi) {
            this.meteoroidit.add(new Meteoroidi(25 + this.meteoroidinJaElamapaketinPaikanArpoja.nextInt(117) * 5, 0));
        }
        if (e.getSource() == this.luoUusiElamapaketti) {
            this.elamapaketit.add(new Elamapaketti(this.meteoroidinJaElamapaketinPaikanArpoja.nextInt(126) * 5, 0));
        }
    }
    
    /**
     * Metodi, joka pyörittää Avaruuspuolustus peliä päivittämällä sitä ja piirtoalustaa 60 FPS:n nopeudella.
     */
    public void pelinLoop() {
        long viimeLoopinAika = System.nanoTime();
        final int tavoiteFPS = 60;
        final long optimaalinenAika = 1000000000 / tavoiteFPS;

        while (this.peliKaynnissa == true) {
            long aikaTallaHetkella = System.nanoTime();
            viimeLoopinAika = aikaTallaHetkella;

            paivitaPelia();
            this.piirtoalusta.paivita();

            try {
                Thread.sleep((viimeLoopinAika - System.nanoTime() + optimaalinenAika) / 1000000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Avaruustaistelu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Päivittää peliä tarkistamalla pelaajan liikkumisen, liikuttaa kaikkia objekteja, tarkistaa objektien törmäykset,
     * poistaa kaikki tuhoutuneet ja pelialueelta poistuneet objektit, tarkistaa pelin jatkumisen.
     */
    public void paivitaPelia() {
        if (this.avaruusalus.getLiikuOikealle() == true) {
            this.avaruusalus.liikuOikealle();
        } else if (this.avaruusalus.getLiikuVasemmalle() == true) {
            this.avaruusalus.liikuVasemmalle();
        }
        liikutaOhjuksia();
        liikutaMeteoroideja();
        liikutaElamapaketteja();
        tarkastaMeteoroidienOsuminenPelaajaan();
        tarkastaOhjustenOsuminenMeteoroideihin();
        tarkastaElamapakettienOsuminenPelaajaan();
        poistaTuhoutuneetMeteoroidit();
        poistaAlueeltaPoistuneetOhjukset();
        poistaAlueeltaPoistuneetMeteoroiditJaMenetaElamapisteAvaruusalukselta();
        tarkastaAvaruusaluksenElamapisteidenMeneminenNollaan();
    }
    
    /**
     * Kutsuu liikkumismetodia kaikille pelissä oleville ohjuksille.
     */
    public void liikutaOhjuksia() {
        for (Ohjus ohjus : this.avaruusalus.getOhjukset()) {
            ohjus.liiku();
        }
    }
    
    /**
     * Kutsuu liikkumismetodia kaikille pelissä oleville meteoroideille.
     */
    public void liikutaMeteoroideja() {
        for (Meteoroidi meteoroidi : this.meteoroidit) {
            meteoroidi.liiku();
        }
    }
    
    /**
     * Kutsuu liikkumismetodia kaikille pelissä oleville elämäpaketeille.
     */
    public void liikutaElamapaketteja() {
        for (Elamapaketti elamapaketti : this.elamapaketit) {
            elamapaketti.liiku();
        }
    }
    
    /**
     * Tarkastaa elämäpakettien osumisen pelaajan avaruusalukseen. Jos elämäpaketti osuu avaruusalukseen, niin avaruusalus saa yhden elämäpisteen.
     */
    public void tarkastaElamapakettienOsuminenPelaajaan() {
        ArrayList<Elamapaketti> pelaajaanOsuneetElamapaketit = new ArrayList<>();
        
        for (Elamapaketti elamapaketti : this.elamapaketit) {
            if (elamapaketti.getObjektinSijainninAlue().intersects(this.avaruusalus.getObjektinSijainninAlue())) {
                this.avaruusalus.lisaaElamapiste();
                pelaajaanOsuneetElamapaketit.add(elamapaketti);
            }
        }
        this.elamapaketit.removeAll(pelaajaanOsuneetElamapaketit);
    }
    
    /**
     * Tarkastaa meteoroidien osumisen pelaajan avaruusalukseen. Jos meteoroidi osuu avaruusalukseen, niin peliKäynnissä boolean muuttuu falseksi.
     */
    public void tarkastaMeteoroidienOsuminenPelaajaan() {
        for (Meteoroidi meteoroidi : this.meteoroidit) {
            if (meteoroidi.getObjektinSijainninAlue().intersects(this.avaruusalus.getObjektinSijainninAlue())) {
                this.peliKaynnissa = false;
            }
        }
    }
    
    /**
     * Muuttaa peliKaynnissa booleanin falseksi, jos avaruusaluksen elämäpisteet ovat nolla.
     */
    public void tarkastaAvaruusaluksenElamapisteidenMeneminenNollaan() {
        if (this.avaruusalus.getElamapisteet() == 0) {
            this.peliKaynnissa = false;
        }
    }
    
    /**
     * Tarkastaa pelaajan ampumien ohjusten osumisen meteoroideihin vertaamalla ohjusten ja meteoroidien sijaintia
     * toisiinsa. Jos ohjus osuu meteoroidiin, niin ohjus tuhoutuu ja meteoroidi menettää yhden elämäpisteen.
     */
    public void tarkastaOhjustenOsuminenMeteoroideihin() {
        ArrayList<Ohjus> meteoroidiinOsuneetOhjukset = new ArrayList<>();
        
        for (Meteoroidi meteoroidi : this.meteoroidit) {
            for (Ohjus ohjus : this.avaruusalus.getOhjukset()) {
                if (ohjus.getObjektinSijainninAlue().intersects(meteoroidi.getObjektinSijainninAlue())) {
                    meteoroidi.menetaElamapiste();
                    meteoroidiinOsuneetOhjukset.add(ohjus);
                }
            }
        }
        this.avaruusalus.getOhjukset().removeAll(meteoroidiinOsuneetOhjukset);
    }
    
    /**
     * Poistaa tuhoutuneet meteoroidit (Meteoroidi, jolla 0 elämäpistettä). Lisää yhden pisteen pelaajalle.
     * Vaikeuttaa peliä kutsumalla metodia, joka lyhentää uuden meteoroidin luovan ajastimen viivettä.
     */
    public void poistaTuhoutuneetMeteoroidit() {
        ArrayList<Meteoroidi> tuhoutuneetMeteoroidit = new ArrayList<>();
        
        for (Meteoroidi meteoroidi : this.meteoroidit) {
            if (meteoroidi.getElamapisteet() == 0) {
                tuhoutuneetMeteoroidit.add(meteoroidi);
                this.avaruusalus.lisaaPiste();
                vaikeutaPeliaLyhentamallaUudenMeteoroidinAjastimenAikaa();
            }
        }
        this.meteoroidit.removeAll(tuhoutuneetMeteoroidit);
    }
    
    /**
     * Lyhentää uuden meteoroidin luovan ajastimen viiveaikaa vähentämällä kaksikymmentä millisekuntia.
     */
    public void vaikeutaPeliaLyhentamallaUudenMeteoroidinAjastimenAikaa() {
        if (this.luoUusiMeteoroidi.getDelay() > 1000) {
            this.luoUusiMeteoroidi.setDelay(this.luoUusiMeteoroidi.getDelay() - 50);
        }
    }
        
    /**
     * Poistaa ohjukset, jotka eivät ole enää pelialueella.
     */
    public void poistaAlueeltaPoistuneetOhjukset() {
        ArrayList<Ohjus> poistettavat = new ArrayList<>();
        for (Ohjus ohjus : this.avaruusalus.getOhjukset()) {
            if (ohjus.getY() <= -15) {
                poistettavat.add(ohjus);
            }
        }
        this.avaruusalus.getOhjukset().removeAll(poistettavat);
    }
    
    /**
     * Poistaa meteoroidit, jotka eivät ole enää pelialueella. Vähentää yhden elämäpisteen avaruusalukselta jokaista poistunutta meteoroidia kohden.
     */
    public void poistaAlueeltaPoistuneetMeteoroiditJaMenetaElamapisteAvaruusalukselta() {
        ArrayList<Meteoroidi> poistettavat = new ArrayList<>();
        for (Meteoroidi meteoroidi : this.meteoroidit) {
            if (meteoroidi.getY() >= 900) {
                poistettavat.add(meteoroidi);
                this.avaruusalus.menetaElamapiste();
            }
        }
        this.meteoroidit.removeAll(poistettavat);
    }
    
    public Avaruusalus getAvaruusalus() {
        return this.avaruusalus;
    }
    
    public void setPiirtoalusta(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
    }
    
    public CopyOnWriteArrayList<Meteoroidi> getMeteoroidit() {
        return this.meteoroidit;
    }
    
    public CopyOnWriteArrayList<Elamapaketti> getElamapaketit() {
        return this.elamapaketit;
    }
    
    public boolean getPeliKaynnissa() {
        return this.peliKaynnissa;
    }
    
    public void setPeliKaynnissa(boolean peliKaynnissa) {
        this.peliKaynnissa = peliKaynnissa;
    }
}