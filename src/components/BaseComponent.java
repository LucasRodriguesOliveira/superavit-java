/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author Lucas Oliveira
 */
public abstract class BaseComponent extends JLabel {
    protected int X;
    protected int Y;
    protected int W;
    protected int H;
    protected String iconPath;
    protected ImageIcon default_image;
    protected Cursor cursor_type;
    protected final String DEFAULT_EXTENSION = ".png";
    
    protected ImageIcon getImage(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
    
    public ImageIcon getCurrentImage() {
        return this.default_image;
    }
    
    public void changeImage(ImageIcon image) {
        this.setIcon(image);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getW() {
        return W;
    }

    public int getH() {
        return H;
    }
}
