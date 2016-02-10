package Avaruuspuolustus.TiedostojenKasittely;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Luokka, jossa tapahtuu kaikki tiedostojen käsittelyyn liittyvät asiat, esimerkiksi
 * kuvien hakeminen.
 * 
 * @author Jyri
 */
public class TiedostojenKasittelija {
    
    private final BufferedImage avaruusaluksenKuva;
    
    public TiedostojenKasittelija() {
        BufferedImage avaruusAlusKuva = null;
        try {
            avaruusAlusKuva = ImageIO.read(this.getClass().getResource("/Tiedostot/Alus.png"));
        } catch (IOException e) {
            System.out.print(e);
        }
        this.avaruusaluksenKuva = avaruusAlusKuva;
    }
    
    /**
    * Palauttaa pelaajan avaruusaluksen kuvan.
    * @return 
    */
    public BufferedImage getAvaruusaluksenKuva() {
        return this.avaruusaluksenKuva;
    }
}
