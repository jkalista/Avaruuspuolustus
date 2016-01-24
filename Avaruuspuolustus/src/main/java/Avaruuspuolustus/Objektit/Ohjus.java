package Avaruuspuolustus.Objektit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Jyri
 */
public class Ohjus extends Objekti {

    public Ohjus(int x, int y) {
        super(x,y);
    }
    
    @Override
    public void liiku(int sijainninMuutos) {
        this.y = this.y + sijainninMuutos;
    }

    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 5, 10);
        g.setColor(Color.RED);
        g.fillRect(x, y + 10, 5, 5);
    }

    @Override
    public Rectangle getEsineenSijainninAlue() {
        return new Rectangle(this.x, this.y, 5, 15);
    }
    
}
