package lro.superavit.view;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import controllers.MainController;
import constants.MainConstants.MAIN;

/**
 *
 * @author Lucas Oliveira
 */
public class Main extends JFrame {
    
    public Main(){
      initProps();
      generateComponents();
    }
    
    private void initProps() {
        this.setTitle(MAIN.TITLE);
        this.setSize(MAIN.WIDTH, MAIN.HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage((new ImageIcon(getClass().getResource(MAIN.ICON))).getImage());
        this.setUndecorated(true);
        centralize();
        
        if(null == MainController.Controller)
            MainController.Controller = new MainController(getContentPane());
    }

    private void centralize() {
        Dimension dt = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dj = this.getSize();
        this.setLocation((dt.width - dj.width) / 2, (dt.height - dj.height) / 2);
    }

    private void generateComponents() {
        this.setLayout(MainController.Controller.getLayout());
        MainController.Controller.getViews().forEach((vw) -> {
            getContentPane().add(vw, vw.getViewName());
        });
    }
}
