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
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Avaruuspuolustus());
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
    
}
