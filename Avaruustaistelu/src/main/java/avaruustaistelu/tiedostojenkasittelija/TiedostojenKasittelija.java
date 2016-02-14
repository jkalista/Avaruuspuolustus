package avaruustaistelu.tiedostojenkasittelija;

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
    private final BufferedImage elamapaketinKuva;
    
    public TiedostojenKasittelija() {
        BufferedImage avaruusalusKuva = null;
        try {
            avaruusalusKuva = ImageIO.read(this.getClass().getResource("/tiedostot/Alus.png"));
        } catch (IOException e) {
            System.out.print(e);
        }
        this.avaruusaluksenKuva = avaruusalusKuva;
        
        BufferedImage elamapakettiKuva = null;
        try {
            elamapakettiKuva = ImageIO.read(this.getClass().getResource("/tiedostot/Elamapaketti.png"));
        } catch (IOException e) {
            System.out.print(e);
        }
        this.elamapaketinKuva = elamapakettiKuva;
    }
    
    /**
     * Palauttaa pelaajan ohjaaman avaruusaluksen kuvan.
     * 
     * @return BufferedImage Avaruusaluksen kuva
     */
    public BufferedImage getAvaruusaluksenKuva() {
        return this.avaruusaluksenKuva;
    }
    
    /**
     * Palauttaa elämäpaketin kuvan.
     * 
     * @return BufferedImage Elamapaketin kuva
     */
    public BufferedImage getElamapaketinKuva() {
        return this.elamapaketinKuva;
    }
}
