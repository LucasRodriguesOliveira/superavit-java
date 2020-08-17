package components;

import constants.InitialConstants.LETSGO_BUTTON;
import controllers.MainController;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class LetsGoButton extends Button implements MouseListener {
    
    public LetsGoButton(int x, int y, int w, int h, String tooltip, Container parent) {
        super(parent);
        initProps(x, y, w, h, tooltip);
        setConfigs();
    }
    
    private void initProps(int x, int y, int w, int h, String t) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.tooltip = t;
        this.iconPath = LETSGO_BUTTON.IMAGE_PATH;
        this.default_image = new ImageIcon(getClass().getResource(iconPath + LETSGO_BUTTON.IMAGE_EXTENSION));
        this.hover_image = new ImageIcon(getClass().getResource(iconPath + LETSGO_BUTTON.IMAGE_HOVER_PATH));
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
    }
    
    private void setConfigs() {
        setIcon(default_image);
        setBounds(X, Y, W, H);
        setCursor(cursor_type);
        addMouseListener(this);
        this.setBackground(Color.red);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      MainController.Controller.nextView(this.getParent());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setIcon(this.hover_image);
        this.setSize(LETSGO_BUTTON.W_HOVER, LETSGO_BUTTON.H_HOVER);
        //this.setLocation(LETSGO_BUTTON.X_HOVER, LETSGO_BUTTON.Y_HOVER);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(this.default_image);
        this.setSize(LETSGO_BUTTON.W, LETSGO_BUTTON.H);
        //this.setLocation(LETSGO_BUTTON.X, LETSGO_BUTTON.Y);
    }
    
}
