/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avaruuspuolustus.Objektit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Jyri
 */
public class Meteoroidi extends Objekti {

    private int elamapisteet;
    
    public Meteoroidi(int x, int y) {
        super(x,y);
        this.elamapisteet = 5;
    }
    
    public void liiku() {
        this.y = this.y + 1;
    }
    
    @Override
    public void piirra(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        
        if(this.elamapisteet == 5) {
            g.fillOval(x, y, 40, 40);
        } else if(this.elamapisteet == 4) {
            g.fillOval(x, y, 35, 35);
        } else if(this.elamapisteet == 3) {
            g.fillOval(x, y, 30, 30);
        } else if(this.elamapisteet == 2) {
            g.fillOval(x, y, 25, 25);
        } else if(this.elamapisteet == 1) {
            g.fillOval(x, y, 20, 20);
        }
    }

    @Override
    public Rectangle getEsineenSijainninAlue() {
        if(this.elamapisteet == 5) {
            return new Rectangle(this.x, this.y, 40, 40);
        } else if(this.elamapisteet == 4) {
            return new Rectangle(this.x, this.y, 35, 35);
        } else if(this.elamapisteet == 3) {
            return new Rectangle(this.x, this.y, 30, 30);
        } else if(this.elamapisteet == 2) {
            return new Rectangle(this.x, this.y, 25, 25);
        }
        return new Rectangle(this.x, this.y, 20, 20);
    }
    
    public void menetaElamapiste() {
        this.elamapisteet = this.elamapisteet - 1;
    }
    
    public int getElamapisteet() {
        return this.elamapisteet;
    }
    
    public void setElamapisteet(int elamapisteet) {
        this.elamapisteet = elamapisteet;
    }
    
}
