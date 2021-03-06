package components;

import java.awt.Container;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class Button extends BaseComponent {
    protected ImageIcon hover_image;
    protected String tooltip;
    private Container parent;
    
    public Button(){}
    
    public Button(Container parent) {
        this.parent = parent;
    }

    public Container getParent() {
        return parent;
    }

    public void setParent(Container parent) {
        this.parent = parent;
    }
    
    
}
