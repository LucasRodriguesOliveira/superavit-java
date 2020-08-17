package components;

import controllers.LoginController;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
//Por algum motivo, ao fazer com que FormFieldButton herde de Button,
// o Evento de MouseEvent, não é capturado
// Apesar de funcionar perfeitamente no component CloseButton e LetsGoButton
/**
 *
 * @author Lucas Oliveira
 */
public class FormFieldButton extends BaseComponent {
    private boolean active;
    private ImageIcon active_image;
    private LoginController controller;
    
    public FormFieldButton(int x, int y, int w, int h, boolean active, 
        String imgName, LoginController controller) {
        initProps(x, y, w, h, active, imgName, controller);
        setConfigs();
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
        addMouseListener(new Actions(this));
    }
    
    public void toggleState() {
        this.active = !this.active;
        
        setIcon(active ? active_image : default_image);
    }
    
    public boolean getState() {
        return this.active;
    }
    
    class Actions extends MouseAdapter {
        private final FormFieldButton parent;
        public Actions(FormFieldButton parent) {
            this.parent = parent;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            controller.changeState();
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            if(active) {
                parent.setIcon(active_image);
                parent.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            } else {
                parent.setIcon(active_image);
                parent.setCursor(cursor_type);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            parent.setIcon(active ? active_image : default_image);
        }
    }
}
