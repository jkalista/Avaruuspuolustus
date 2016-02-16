package avaruustaistelu.avaruustaistelu;

import avaruustaistelu.kayttoliittyma.Piirtoalusta;
import avaruustaistelu.objektit.Avaruusalus;
import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final Random meteoroidinJaElamapaketinPaikanArpoja;
    private final ObjektienSiirtaja objektienSiirtaja;
    private final ObjektienPoistaja objektienPoistaja;
    private final ObjektienTarkastaja objektienTarkastaja;
    
    /**
     * Luokan konstruktori, jossa luodaan pelille avaruusalus, meteoroidi lista, elamapaketit lista, käynnistetään ajastimet ja
     * asetetaan peliKaynnissa trueksi. Lisäksi luodaan meteoroidien ja elämäpakettien paikkojen arpoja.
     * 
     * Luodaan myös ObjektienSiirtäjä (sisältää kaikki objektien liikuttamiseen liittyvät metodit), ObjektienPoistaja (sisältää kaikki
     * objektien poistamiseen liittyvät metodit) ja ObjektienTarkastaja (sisältää kaikki objektien keskenäiseen törmäämiseen ja käyttäytymiseen
     * liittyvät metodit).
     */
    public Avaruustaistelu() {
        this.avaruusalus = new Avaruusalus(325, 770);
        this.meteoroidit = new CopyOnWriteArrayList<>();
        this.elamapaketit = new CopyOnWriteArrayList<>();
        this.luoUusiMeteoroidi.start();
        this.luoUusiElamapaketti.start();
        this.peliKaynnissa = true;
        this.meteoroidinJaElamapaketinPaikanArpoja = new Random();
        this.objektienSiirtaja = new ObjektienSiirtaja(this);
        this.objektienPoistaja = new ObjektienPoistaja(this);
        this.objektienTarkastaja = new ObjektienTarkastaja(this);
    }

    /**
     * Luo peliin uuden meteoroidin "luoUusiMeteoroidi" -ajastimen viiveen mukaan ja uuden elämäpaketin "luoUusiElamapaketti"
     * -ajastimen viiveen mukaan.
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
        this.objektienSiirtaja.liikutaAvaruusalusta();
        this.objektienSiirtaja.liikutaOhjuksia();
        this.objektienSiirtaja.liikutaMeteoroideja();
        this.objektienSiirtaja.liikutaElamapaketteja();
        this.objektienTarkastaja.tarkastaMeteoroidienOsuminenAvaruusalukseen();
        this.objektienTarkastaja.tarkastaOhjustenOsuminenMeteoroideihin();
        this.objektienTarkastaja.tarkastaElamapakettienOsuminenAvaruusalukseen();
        this.objektienPoistaja.poistaTuhoutuneetMeteoroidit();
        this.objektienPoistaja.poistaAlueeltaPoistuneetOhjukset();
        this.objektienPoistaja.poistaAlueeltaPoistuneetElamapaketit();
        this.objektienPoistaja.poistaAlueeltaPoistuneetMeteoroiditJaMenetaElamapisteAvaruusalukselta();
        this.objektienTarkastaja.tarkastaAvaruusaluksenElamapisteidenMeneminenNollaan();
    }
    
    /**
     * Lyhentää uuden meteoroidin luovan ajastimen viiveaikaa vähentämällä kaksikymmentä millisekuntia.
     */
    public void vaikeutaPeliaLyhentamallaUudenMeteoroidinAjastimenAikaa() {
        if (this.luoUusiMeteoroidi.getDelay() > 1000) {
            this.luoUusiMeteoroidi.setDelay(this.luoUusiMeteoroidi.getDelay() - 50);
        }
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
    
    public ObjektienSiirtaja getObjektienSiirtaja() {
        return this.objektienSiirtaja;
    }
    
    public ObjektienPoistaja getObjektienPoistaja() {
        return this.objektienPoistaja;
    }
    
    public ObjektienTarkastaja getObjektienTarkastaja() {
        return this.objektienTarkastaja;
    }
    
    public Timer getLuoUusiMeteoroidi() {
        return this.luoUusiMeteoroidi;
    }
}