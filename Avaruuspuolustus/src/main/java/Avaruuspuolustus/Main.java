package Avaruuspuolustus;

import Avaruuspuolustus.Avaruuspuolustus.Avaruuspuolustus;
import Avaruuspuolustus.Kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jyri
 */
public class Main {
    
    public static void main(String[] args) {
        Avaruuspuolustus avaruuspuolustus = new Avaruuspuolustus();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(avaruuspuolustus);
        SwingUtilities.invokeLater(kayttoliittyma);
        
        while (kayttoliittyma.getPiirtoalusta() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
         
        avaruuspuolustus.setPiirtoalusta(kayttoliittyma.getPiirtoalusta());
        avaruuspuolustus.pelinLoop();
    }
    
    
}
