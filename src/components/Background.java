package components;

import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class Background extends BaseComponent {    
    public Background(int x, int y, int w, int h, String imgName) {
        super();
        initProps(x, y, w, h, imgName);
        setConfigs();
    }

    private void initProps(int x, int y, int w, int h, String imgName) {
      this.X = x;
      this.Y = y;
      this.W = w;
      this.H = h;
      this.iconPath = imgName + DEFAULT_EXTENSION;
      this.default_image = this.getImage(iconPath);
    }

    private void setConfigs() {
        setIcon(default_image);
        setBounds(X, Y, W, H);
    }
}
