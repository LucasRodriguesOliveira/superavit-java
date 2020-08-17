package components;

import constants.MenuConstants.OPR_BUTTON;
import constants.MenuConstants.MENU;
import constants.MenuConstants.BACKGROUND;
import constants.MenuConstants.CONFIG_BUTTON;
import constants.MenuConstants.HOME_BUTTON;
import constants.MenuConstants.EXIT_BUTTON;
import constants.MenuConstants.MENU_ITEMS;
import constants.MenuConstants.MENU_ITEMS.BACK;
import constants.MenuConstants.PROFILE_BUTTON;
import controllers.MenuController;
import javax.swing.JPanel;
/**
 *
 * @author Lucas Oliveira
 */
public class Menu extends BaseComponent {
    private Background background;
    private JPanel menuItens;
    
    public Menu(String menuActive) {
        initProperties(menuActive);
        initComponents();
    }
    
    private Background getMenuBackground(int x, int y, int w, int h, String img) {
        return new Background(x, y, w, h, img);
    }

    private void initComponents() {
        this.setLayout(null);
        this.add(this.menuItens);
        this.add(getMenuBackground(BACKGROUND.X, BACKGROUND.Y, BACKGROUND.W,
                BACKGROUND.H, BACKGROUND.IMAGE_PATH));
        
    }

    private void initProperties(String menuActive) {
        this.setBounds(MENU.X, MENU.Y, MENU.W, MENU.H);
        MenuController.controller = new MenuController();
        initMenuItens(menuActive);
    }
    
    private void initMenuItens(String menuActive) {
        this.menuItens = new JPanel(null);
        this.menuItens.setBounds(MENU_ITEMS.X, MENU_ITEMS.Y, MENU_ITEMS.W, MENU_ITEMS.H);
        this.menuItens.add(getHomeButton("HOME".equals(menuActive)));
        this.menuItens.add(getOperationButton("OPERATIONS".equals(menuActive)));
        this.menuItens.add(getUserButton("USER".equals(menuActive)));
        this.menuItens.add(getConfigButton("CONFIG".equals(menuActive)));
        this.menuItens.add(getExitButton());
        this.menuItens.add(getMenuBackground(BACK.X, BACK.Y,
                BACK.W, BACK.H, MENU_ITEMS.IMAGE_PATH));
        
    }
    
    private MenuItem getHomeButton(boolean active) {
        MenuItem home = new MenuItem(HOME_BUTTON.X, HOME_BUTTON.Y, HOME_BUTTON.W,
                HOME_BUTTON.H, HOME_BUTTON.TOOLTIP, HOME_BUTTON.IMAGE_PATH);
        home.setState(active);
        home.addMouseListener(MenuController.controller.getHomeActions());
        return home;
    }
    
    private MenuItem getOperationButton(boolean active) {
        MenuItem operation = new MenuItem(OPR_BUTTON.X, OPR_BUTTON.Y, OPR_BUTTON.W,
                OPR_BUTTON.H, OPR_BUTTON.TOOLTIP, OPR_BUTTON.IMAGE_PATH);
        operation.setState(active);
        operation.addMouseListener(MenuController.controller.getOperationsActions());
        return operation;
    }
    
    private MenuItem getUserButton(boolean active) {
        MenuItem profile = new MenuItem(PROFILE_BUTTON.X, PROFILE_BUTTON.Y, PROFILE_BUTTON.W,
                PROFILE_BUTTON.H, PROFILE_BUTTON.TOOLTIP, PROFILE_BUTTON.IMAGE_PATH);
        profile.setState(active);
        return profile;
    }
    
    private MenuItem getConfigButton(boolean active) {
        MenuItem config = new MenuItem(CONFIG_BUTTON.X, CONFIG_BUTTON.Y, CONFIG_BUTTON.W,
                CONFIG_BUTTON.H, CONFIG_BUTTON.TOOLTIP, CONFIG_BUTTON.IMAGE_PATH);
        config.setState(active);
        return config;
    }
    
    private MenuItem getExitButton() {
        MenuItem exit = new MenuItem(EXIT_BUTTON.X, EXIT_BUTTON.Y, EXIT_BUTTON.W,
                EXIT_BUTTON.H, EXIT_BUTTON.TOOLTIP, EXIT_BUTTON.IMAGE_PATH);
        exit.addMouseListener(MenuController.controller.getExitActions());
        return exit;
    }
}
