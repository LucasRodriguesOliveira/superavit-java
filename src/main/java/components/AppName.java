/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.ImageIcon;

/**
 *
 * @author Lucas Oliveira
 */
public class AppName extends BaseComponent {
    private final String DEFAULT_EXTENSION = ".png";
    
    public AppName(int x, int y, int w, int h, String imgName) {
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
      this.default_image = new ImageIcon(getClass().getResource(iconPath));
    }

    private void setConfigs() {
        setIcon(default_image);
        setBounds(X, Y, W, H);
    }
}
