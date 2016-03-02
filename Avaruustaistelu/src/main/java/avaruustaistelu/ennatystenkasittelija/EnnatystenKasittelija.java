package avaruustaistelu.ennatystenkasittelija;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Luokka, jossa tarkastetaan riittävätkö pelistä saadut pisteet ennätyslistalle, ja korvataan
 * tarvitaessa ennätyslista tiedostoa.
 * 
 * @author Jyri
 */
public class EnnatystenKasittelija {
    
    
    /**
     * Metodi, joka tarkistaa riittääkö pelistä saadut pisteet ennätyspisteluetteloon.
     * 
     * @param saadutPisteet Pisteet pelistä
     */
    public void tarkastaRiittavatkoPisteetEnnatyslistalle(int saadutPisteet) {
        File tiedosto = new File("./ennatykset/ennatykset.txt");
        
        try {
            Scanner lukija = new Scanner(tiedosto.getAbsoluteFile());
            
            int ensimmainenSija = Integer.parseInt(lukija.nextLine());
            int toinenSija = Integer.parseInt(lukija.nextLine());
            int kolmasSija = Integer.parseInt(lukija.nextLine());
            
            FileWriter kirjoittaja = new FileWriter(tiedosto.getAbsoluteFile());
            
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
