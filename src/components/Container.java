package components;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Lucas Oliveira
 */
public class Container extends JPanel {
    protected int X;
    protected int Y;
    protected int W;
    protected int H;
    protected String iconPath;
    protected Cursor cursor_type;
    protected final String DEFAULT_EXTENSION = ".png";
    protected Background background;
    
    public Container(int x, int y, int w, int h, String i, JPanel content) {
        initProps(x, y, w, h, i);
        setConfigs(content);
    }
    
    private void initProps(int x, int y, int w, int h, String i) {
        this.X = x;
        this.Y = y;
        this.W = w;
        this.H = h;
        this.background = new Background(0, 0, w, h, i);
    }
    
    private void setConfigs(JPanel content) {
        this.setBounds(X, Y, W, H);
        this.setLayout(null);
        this.add(content);
        this.add(background);
    }
    
    protected ImageIcon getImage(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
    
    public ImageIcon getCurrentBackgroundImage() {
        return this.background.getCurrentImage();
    }
    
    public void changeBackgroundImage(ImageIcon image) {
        this.background.setIcon(image);
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
