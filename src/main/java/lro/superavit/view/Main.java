package lro.superavit.view;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import controllers.MainController;
import constants.MainConstants.MAIN;
import javax.swing.JPanel;

/**
 *
 * @author Lucas Oliveira
 */
public class Main extends JFrame {
    private JPanel Container;
    
    public Main(){
      initProps();
      generateComponents();
    }
    
    private void initProps() {
        setTitle(MAIN.TITLE);
        setSize(MAIN.WIDTH, MAIN.HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setIconImage((new ImageIcon(getClass().getResource(MAIN.ICON))).getImage());
        setUndecorated(true);
        centralize();
        setLocationRelativeTo(null);
        
        if(null == MainController.Controller)
            MainController.Controller = new MainController();
        
        MainController.Controller.generateComponents();
        
        Container = new JPanel(MainController.Controller.getLayout());
        Container.setBounds(0, 0, MAIN.WIDTH, MAIN.HEIGHT);
        MainController.Controller.initViews(Container);
    }

    private void centralize() {
        Dimension dt = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dj = this.getSize();
        this.setLocation((dt.width - dj.width) / 2, (dt.height - dj.height) / 2);
    }

    private void generateComponents() {
        MainController.Controller.getViews().forEach((vw) -> {
            Container.add(vw.getViewName(), vw);
        });
        
        getContentPane().setLayout(null);
        getContentPane().add(Container);
    }
}
