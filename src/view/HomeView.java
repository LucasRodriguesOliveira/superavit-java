package view;

import components.AppName;
import components.Background;
import java.awt.Container;
import constants.HomeConstants.HOME;
import constants.HomeConstants.BACKGROUND;
import constants.HomeConstants.APPNAME;
import constants.HomeConstants.NEW_BILL_BTN;
import constants.HomeConstants.NOTIFICATION_MANAGER;
import constants.HomeConstants.CONTAINER;
import controllers.MainController;
import javax.swing.JOptionPane;
import components.Menu;
import components.NewBillButton;
import components.NotificationManager;
import controllers.MenuController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lucas Oliveira
 */
public class HomeView extends BaseView {
    private JLabel username;
    
    public HomeView(Container parent) {
        super(HOME.NAME, parent);
        initComponents();
    }
    
    private Background getBackgroundHome() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
    }
    
    private Menu getMenu() {
        return new Menu(HOME.NAME);
    }
    
    private AppName getAppName() {
        return new AppName(APPNAME.X, APPNAME.Y, APPNAME.W, APPNAME.H, APPNAME.IMAGE_PATH);
    }
    
    private NewBillButton getNewBillButton() {
        NewBillButton newbillbtn = new NewBillButton(NEW_BILL_BTN.X, NEW_BILL_BTN.Y,
                NEW_BILL_BTN.W, NEW_BILL_BTN.H, NEW_BILL_BTN.TOOLTIP, NEW_BILL_BTN.IMAGE_PATH);
        
        return newbillbtn;
    }
    
    private void initComponents() {
        getUserName();
        
        this.add(getAppName());
        this.add(getMenu());
        this.add(username);
        this.add(getNotificationManager());
        this.add(getNewBillButton());
        this.add(getBackgroundHome());
        this.initProps();
        
        MenuController.parent = parent;
    }

    public void loadUserInfo() {
        Thread retrieveUserData = new Thread(new RetrieveUserData());
        retrieveUserData.setName("RetrieveUserData");
        retrieveUserData.setPriority(Thread.NORM_PRIORITY);
        retrieveUserData.start();
    }
    
    private void getUserName() {
        username = new JLabel(HOME.PRELOAD_NAME);
        username.setFont(new Font("Segoe UI", Font.BOLD, 30));
        username.setForeground(new Color(43, 158, 179));
        username.setBounds(550, 100, 300, 150);
    }
    
    private JPanel getNotificationManager() {
        NotificationManager notificationmanager = new NotificationManager(
          NOTIFICATION_MANAGER.X, NOTIFICATION_MANAGER.Y, NOTIFICATION_MANAGER.W,
          NOTIFICATION_MANAGER.H, NOTIFICATION_MANAGER.IMAGE_PATH
        );
        
        components.Container container = new components.Container(
          CONTAINER.X, CONTAINER.Y, CONTAINER.W, CONTAINER.H, CONTAINER.IMAGE_PATH,
          notificationmanager
        );
        
        return container;
    }
    
    // Carrega as informações visuais do usuário
    private void setUserInfo() {
        this.username.setText(MainController.usuario.getNome());
    }
    
    class RetrieveUserData implements Runnable {
        private boolean found;
        private int tries;
        
        @Override
        public void run() {
            found = false;
            tries = 0;
            while(!found) {
                if(null != MainController.usuario)
                    found = true;
                else {
                    if(++tries > 10) return;
                    
                    try { Thread.sleep(1000); }
                    catch(InterruptedException iex) {
                        JOptionPane.showMessageDialog(null, "Houve um problema ao tentar recuperar suas informações");
                    }
                }
            }
            
            setUserInfo();
        }
    } 
}
