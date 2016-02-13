/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public TiedostojenKasittelija() {
        BufferedImage avaruusAlusKuva = null;
        try {
            avaruusAlusKuva = ImageIO.read(this.getClass().getResource("/tiedostot/Alus.png"));
        } catch (IOException e) {
            System.out.print(e);
        }
        this.avaruusaluksenKuva = avaruusAlusKuva;
    }
    
    /**
     * Palauttaa pelaajan ohjaaman avaruusaluksen kuvan.
     * 
     * @return BufferedImage Avaruusaluksen kuva
     */
    public BufferedImage getAvaruusaluksenKuva() {
        return this.avaruusaluksenKuva;
    }
}
