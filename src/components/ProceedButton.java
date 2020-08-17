package components;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import constants.PaymentCompletionConstants.COMPLETION.PROCEED_BUTTON;
import java.awt.Cursor;

/**
 *
 * @author Lucas Oliveira
 */
public class ProceedButton extends BaseComponent {
    private ImageIcon default_image;
    private ImageIcon hover_image;
    protected String tooltip;
    
    public ProceedButton(int x, int y, int w, int h, String tooltip, Container parent) {
        super();
        initProps(x, y, w, h, tooltip);
        setConfigs();
    }
    
    class Actions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(hover_image);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(default_image);
        }
    }
    
    private void initProps(int x, int y, int w, int h, String t) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.tooltip = t;
        this.iconPath = PROCEED_BUTTON.IMAGE_PATH;
        this.default_image = this.getImage(iconPath + DEFAULT_EXTENSION);
        this.hover_image = this.getImage(iconPath + " - hover" + DEFAULT_EXTENSION);
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
    }
    
    private void setConfigs() {
        setIcon(default_image);
        setBounds(X, Y, W, H);
        setCursor(cursor_type);
        addMouseListener(new Actions());
        setToolTipText(tooltip);
    }
}
