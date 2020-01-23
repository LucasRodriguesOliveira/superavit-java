package components;

import controllers.LoginController;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class FormFieldButton extends Button {
    private boolean active;
    private ImageIcon active_image;
    private LoginController controller;
    
    public FormFieldButton(int x, int y, int w, int h, boolean active, 
            String imgName, LoginController controller) {
        initProps(x, y, w, h, active, imgName, controller);
        setConfigs();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if(active) {
            this.setIcon(this.active_image);
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        } else {
            this.setIcon(this.active_image);
            this.setCursor(cursor_type);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setIcon(active ? active_image : default_image);
    }

    private void initProps(int x, int y, int w, int h, boolean active,
            String imgName, LoginController controller) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.default_image = new ImageIcon(getClass().getResource(imgName+ ".png"));
        this.active_image = new ImageIcon(getClass().getResource(imgName + " - ativo.png"));
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
        this.controller = controller;
        this.active = active;
    }

    private void setConfigs() {
        setIcon(active ? active_image : default_image);
        setBounds(X, Y, W, H);
        setCursor(cursor_type);
        addMouseListener(this);
        setToolTipText(tooltip);
    }
    
    public void changeState(boolean state) {
        this.active = state;
        
        setIcon(active ? active_image : default_image);
    }
}
