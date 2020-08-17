/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class ActionButton extends Button {
   private ImageIcon inative_image; 
   private boolean state;
    
   public ActionButton(int x, int y, int w, int h, String tooltip, String imgPath, Container parent) {
        super(parent);
        initProps(x, y, w, h, tooltip, imgPath);
        setConfigs();
    }
    
    class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            if(state) {
                setIcon(hover_image);
                setCursor(cursor_type);
            } else {
                setIcon(inative_image);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(state) {
                setIcon(default_image);
                setCursor(cursor_type);
            } else  {
                setIcon(inative_image);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
        
        if(state) {
            setIcon(default_image);
            setCursor(cursor_type);
        } else {
            setIcon(inative_image);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    

    private void initProps(int x, int y, int w, int h, String t, String p) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.state = false;
        this.tooltip = t;
        this.iconPath = p;
        this.default_image = new ImageIcon(getClass().getResource(iconPath + this.DEFAULT_EXTENSION));
        this.hover_image = new ImageIcon(getClass().getResource(iconPath + " - hover" + this.DEFAULT_EXTENSION));
        this.inative_image = this.getImage(iconPath + " - inativo" + this.DEFAULT_EXTENSION);
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
    }

    private void setConfigs() {
        setIcon(inative_image);
        setBounds(X, Y, W, H);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        addMouseListener(new Actions());
        setToolTipText(tooltip);
    } 
}
