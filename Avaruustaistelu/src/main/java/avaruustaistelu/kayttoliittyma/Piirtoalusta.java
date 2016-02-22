package avaruustaistelu.kayttoliittyma;

import avaruustaistelu.avaruustaistelu.Avaruustaistelu;
import avaruustaistelu.objektit.Elamapaketti;
import avaruustaistelu.objektit.Meteoroidi;
import avaruustaistelu.objektit.Ohjus;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Luokka, jossa tapahtuu Avaruuspuolustus pelin piirtämiseen liittyvät asiat.
 * 
 * @author Jyri
 */
public class Piirtoalusta extends JPanel {
    
    private final Avaruustaistelu avaruustaistelu;
    
    /**
     * Luokan konstruktori, joka saa parametrikseen Avaruustaistelu luokan ilmentymän.
     * 
     * @param avaruustaistelu Avaruustaistelu peli
     */
    public Piirtoalusta(Avaruustaistelu avaruustaistelu) {
        super.setBackground(Color.BLACK);
        this.avaruustaistelu = avaruustaistelu;
    }
    
    /**
     * Metodi, joka päivittää piirtoalustan.
     */
    public void paivita() {
        this.repaint();
    }
    
    /**
     * Piirtää kaikki Avaruuspuolustus peliin liittyvät asiat.
     * 
     * @param g Grafiikka
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraAvaruusalus(g);
        piirraOhjukset(g);
        piirraMeteoroidit(g);
        piirraElamapaketit(g);
        piirraPelaajanPisteet(g);
        piirraPelaajanElamapisteet(g);
        piirraPelinPaatosIkkuna(g);
    }
    
    /**
     * Piirtää pelaajan avaruusaluksen.
     * 
     * @param g Avaruusaluksen grafiikka
     */
    public void piirraAvaruusalus(Graphics g) {
        this.avaruustaistelu.getAvaruusalus().piirra(g);
    }
    
    /**
     * Piirtää pelaajan avaruusaluksen pisteet oikeaan yläkulmaan.
     * 
     * @param g Pelaajan pisteiden grafiikka
     */
    public void piirraPelaajanPisteet(Graphics g) {
        g.setFont(new Font("BAZOOKA", Font.BOLD, 24));
        g.setColor(Color.WHITE);
        g.drawString("Pisteet: " + Integer.toString(this.avaruustaistelu.getAvaruusalus().getPisteet()), 510, 30);
    }
    
    /**
     * Piirtää pelaajan avaruusaluksen elämäpisteet vasempaan yläkulmaan.
     * 
     * @param g Pelaajan elämäpisteiden grafiikka
     */
    public void piirraPelaajanElamapisteet(Graphics g) {
        g.setFont(new Font("BAZOOKA", Font.BOLD, 24));
        g.setColor(Color.WHITE);
        g.drawString("Elämät: " + Integer.toString(this.avaruustaistelu.getAvaruusalus().getElamapisteet()) + "/5", 10, 30);
    }
    
    /**
     * Piirtää kaikki Avaruuspuolustus pelissä olevat ohjukset.
     * 
     * @param g Ohjusten grafiikka
     */
    public void piirraOhjukset(Graphics g) {
        for (Ohjus ohjus : this.avaruustaistelu.getAvaruusalus().getOhjukset()) {
            ohjus.piirra(g);
        }
    }
    
    /**
     * Piirtää kaikki Avaruuspuolustus pelissä olevat meteoroidit.
     * 
     * @param g Meteoroidien grafiikka
     */
    public void piirraMeteoroidit(Graphics g) {
        for (Meteoroidi meteoroidi : this.avaruustaistelu.getMeteoroidit()) {
            meteoroidi.piirra(g);
        }
    }
    
    /**
     * Piirtää kaikki Avaruuspuolustus pelissä olevat elämäpaketit.
     * 
     * @param g Elamapakettien grafiikka
     */
    public void piirraElamapaketit(Graphics g) {
        for (Elamapaketti elamapaketti : this.avaruustaistelu.getElamapaketit()) {
            elamapaketti.piirra(g);
        }
    }
    
    /**
     * Piirtää ikkunan, joka ilmestyy silloin, kun pelaaja häviää pelin.
     * 
     * @param g Päätösikkunan grafiikka
     */
    public void piirraPelinPaatosIkkuna(Graphics g) {
        if (this.avaruustaistelu.getPeliKaynnissa() == false) {
            g.setColor(Color.RED);
            g.fillRoundRect(120, 250, 410, 300, 200, 50);
            g.setColor(Color.YELLOW);
            g.fillRoundRect(130, 260, 390, 280, 200, 50);
            g.setColor(Color.RED);
            g.fillRoundRect(140, 270, 370, 260, 200, 50);
            g.setColor(Color.DARK_GRAY);
            g.fillRoundRect(150, 280, 350, 240, 200, 50);
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("BAZOOKA", Font.BOLD, 20));
            g.drawString("Peli päättyi!", 280, 340);
            g.drawString("Onneksi olkoon! Sait " + this.avaruustaistelu.getAvaruusalus().getPisteet() + " pistettä.", 180, 380);
            g.drawString("Paina [Y] -näppäintä, niin", 180, 440);
            g.drawString("pääset takaisin valikkoon.", 180, 460);
        }
    }
}
