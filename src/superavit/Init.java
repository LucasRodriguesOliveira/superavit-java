package superavit;

import javax.swing.JFrame;
import view.Main;
/**
 *
 * @author Lucas Oliveira
 * @since 13/01/2020
 * @version 0.0.1
 */
public class Init {
    public static JFrame frame;
    
    public static void main(String[] args) {
        Init.frame = new Main();
        Init.frame.setVisible(true);
    }
}
