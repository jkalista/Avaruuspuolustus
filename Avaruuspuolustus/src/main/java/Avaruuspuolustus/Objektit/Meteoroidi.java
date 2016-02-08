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
        g.fillOval(this.x, this.y, 15 + this.elamapisteet*5, 15 + this.elamapisteet*5);
    }

    @Override
    public Rectangle getObjektinSijainninAlue() {
        return new Rectangle(this.x, this.y, 15 + this.elamapisteet*5, 15 + this.elamapisteet*5);
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
