package components;

import constants.PaymentOptionsConstants.ARROW_BACK;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class ArrowBackButton extends BaseComponent {
    private String tooltip;
    
   public ArrowBackButton(int x, int y, int w, int h) {
       initProps(x, y, w, h);
       setConfigs();
    }
    
    class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        
        @Override
        public void mouseExited(MouseEvent e){
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void initProps(int x, int y, int w, int h) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.tooltip = ARROW_BACK.TOOLTIP;
        this.iconPath = ARROW_BACK.IMAGE_PATH;
        this.default_image = new ImageIcon(getClass().getResource(iconPath + this.DEFAULT_EXTENSION));
    }

    private void setConfigs() {
        setBounds(X, Y, W, H);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setToolTipText(tooltip);
        setIcon(default_image);
        addMouseListener(new Actions());
    } 
}
