package superavit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Main;
/**
 *
 * @author Lucas Oliveira
 * @since 13/01/2020
 * @version 0.0.1
 */
public class Init {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
              new com.sun.java.swing.plaf.windows.WindowsLookAndFeel()
            );
        } catch(UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        new Main().setVisible(true);
    }
}
