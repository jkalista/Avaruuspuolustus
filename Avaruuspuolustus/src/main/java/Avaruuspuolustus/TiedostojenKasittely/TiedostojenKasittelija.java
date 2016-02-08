/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avaruuspuolustus.TiedostojenKasittely;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jyri
 */
public class TiedostojenKasittelija {
    
    private BufferedImage avaruusaluksenKuva;
    
    public TiedostojenKasittelija() {
        BufferedImage avaruusAlusKuva = null;
        try {
            avaruusAlusKuva = ImageIO.read(this.getClass().getResource("/Tiedostot/Alus.png"));
        } catch (IOException e) {
            System.out.print(e);
        }
        this.avaruusaluksenKuva = avaruusAlusKuva;
    }
    
    public BufferedImage getAvaruusaluksenKuva() {
        return this.avaruusaluksenKuva;
    }
}
