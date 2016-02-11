package Avaruuspuolustus.Objektit;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Abstrakti luokka, jonka kaikki pelin objektit perivät.
 * 
 * @author Jyri
 */
public abstract class Objekti {
    
    protected int x;
    protected int y;

    public Objekti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
    * Metodi, joka piirtää objektin.
    * 
    * @param g
    */
    public abstract void piirra(Graphics g);
    
    /**
    * Metodi, joka palauttaa alueen, jolla objekti sijaitsee.
    * 
    * @return 
    */
    public abstract Rectangle getObjektinSijainninAlue();
    
}