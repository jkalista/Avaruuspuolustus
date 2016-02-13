package avaruustaistelu;

import avaruustaistelu.avaruustaistelu.Avaruustaistelu;
import avaruustaistelu.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jyri
 */
public class Main {
    
    public static void main(String[] args) {
        
        Avaruustaistelu avaruustaistelu = new Avaruustaistelu();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(avaruustaistelu);
        SwingUtilities.invokeLater(kayttoliittyma);
        
        while (kayttoliittyma.getPiirtoalusta() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        
        avaruustaistelu.setPiirtoalusta(kayttoliittyma.getPiirtoalusta());
        avaruustaistelu.pelinLoop();
    }
    
    
}
