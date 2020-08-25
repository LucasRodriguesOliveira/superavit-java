package components;

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
      X = x;
      Y = y;
      W = w;
      H = h;
      default_image = getImage(imgName + DEFAULT_EXTENSION);
    }

    private void setConfigs() {
        setIcon(default_image);
        setBounds(X, Y, W, H);
    }
}
