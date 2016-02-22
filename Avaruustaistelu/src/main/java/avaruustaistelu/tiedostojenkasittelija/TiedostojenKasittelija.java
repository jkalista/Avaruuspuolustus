package avaruustaistelu.tiedostojenkasittelija;

import avaruustaistelu.kayttoliittyma.MenuValikko;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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
    
    /**
     * Luokan konstruktori, jossa haetaan tiedostoista peliin liittyvät kuvat.
     */
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
    
    /**
     * Metodi, joka tarkistaa riittääkö pelistä saadut pisteet ennätyspisteluetteloon.
     * 
     * @param saadutPisteet Pisteet pelistä
     */
    public void tarkastaRiittavatkoPisteetEnnatyslistalle(int saadutPisteet) {
        File tiedosto = new File("ennatykset.txt");
        
        try {
            Scanner lukija = new Scanner(tiedosto);
            
            int ensimmainenSija = Integer.parseInt(lukija.nextLine());
            int toinenSija = Integer.parseInt(lukija.nextLine());
            int kolmasSija = Integer.parseInt(lukija.nextLine());
            
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            
            if (saadutPisteet > ensimmainenSija) {
                kirjoittaja.write(Integer.toString(saadutPisteet) + System.lineSeparator());
                kirjoittaja.write(Integer.toString(ensimmainenSija) + System.lineSeparator());
                kirjoittaja.write(Integer.toString(toinenSija));
            } else {
                kirjoittaja.write(Integer.toString(ensimmainenSija) + System.lineSeparator());
                
                if (saadutPisteet > toinenSija) {
                    kirjoittaja.write(Integer.toString(saadutPisteet) + System.lineSeparator());
                    kirjoittaja.write(Integer.toString(toinenSija));
                } else {
                    kirjoittaja.write(Integer.toString(toinenSija) + System.lineSeparator());
                    
                    if (saadutPisteet > kolmasSija) {
                        kirjoittaja.write(Integer.toString(saadutPisteet));
                    } else {
                        kirjoittaja.write(Integer.toString(kolmasSija));
                    }
                }
            }
            
            lukija.close();
            kirjoittaja.close();
        } catch (IOException | NumberFormatException e) {
            System.out.print(e);
        }
    }
    
}
