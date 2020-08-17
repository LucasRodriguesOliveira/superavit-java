package components;

import components.PayButtonOperation.Actions;
import java.awt.Cursor;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class PayOption extends BaseComponent {
    private String tooltip;
    private ImageIcon hover_image;
    private String view;
    
   public PayOption(int x, int y, int w, int h, String imagePath, String view) {
        initProps(x, y, w, h, imagePath, view);
        setConfigs();
    }

    private void initProps(int x, int y, int w, int h, String imagePath, String view) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.view = view;
        this.default_image = new ImageIcon(getClass().getResource(imagePath + this.DEFAULT_EXTENSION));
        this.hover_image = new ImageIcon(getClass().getResource(iconPath + " - ativo" + this.DEFAULT_EXTENSION));
        this.cursor_type = new Cursor(Cursor.HAND_CURSOR);
    }

    private void setConfigs() {
        setBounds(X, Y, W, H);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setToolTipText(tooltip);
        setIcon(default_image);
        //addMouseListener(new Actions().);
    } 
}
