package components;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class BaseLine extends BaseComponent {
    private ImageIcon hoverImage;
    private ImageIcon focusImage;
    private Boolean focus;
    
    public BaseLine(int x, int y, int w, int h, String imagePath) {
        initProps(x, y, w, h, imagePath);
    }

    private void initProps(int x, int y, int w, int h, String imagePath) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.iconPath = imagePath;
        
        String defaultimage = iconPath + DEFAULT_EXTENSION;
        String hoverimage = iconPath + " - hover" + DEFAULT_EXTENSION;
        String focusimage = iconPath + " - focus" + DEFAULT_EXTENSION;
        
        this.default_image = getImage(defaultimage);
        this.hoverImage = getImage(hoverimage);
        this.focusImage = getImage(focusimage);
        this.cursor_type = new Cursor(Cursor.TEXT_CURSOR);
        this.setIcon(default_image);
        this.addMouseListener(new MouseActions());
    }
    
    public void setFocused(boolean isFocused) {
        this.focus = isFocused;
        changeImage(focusImage);
    }
    
    public boolean isFocused() {
        return this.focus;
    }
    
    public void toggleFocus() {
        this.focus = !this.focus;
        if(focus)
            changeImage(focusImage);
        else
            changeImage(default_image);
    }

    class MouseActions extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            if(!focus)
                changeImage(hoverImage);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!focus)
                changeImage(default_image);
        }
    }
}
