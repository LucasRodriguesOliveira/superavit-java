package controllers;

import components.MenuItem;
import constants.HomeConstants.HOME;
import constants.OperationsConstants.OPERATIONS;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Lucas Oliveira
 */
public class MenuController {
    public static MenuController controller;
    public static Container parent;
    
    public MouseAdapter getExitActions() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                MenuItem exit = ((MenuItem) e.getSource());
                exit.setState(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                MenuItem exit = ((MenuItem) e.getSource());
                exit.setState(false);
            }
        };
        return adapter;
    }
    
    public MouseAdapter getHomeActions() {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainController.Controller.changeView(parent, HOME.NAME);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                MenuItem home = ((MenuItem) e.getSource());
                home.hover(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                MenuItem home = ((MenuItem) e.getSource());
                home.hover(false);
            }
        };
        return adapter;
    }
    
    public MouseAdapter getOperationsActions() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainController.Controller.changeView(parent, OPERATIONS.NAME);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                MenuItem opr = ((MenuItem) e.getSource());
                opr.hover(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                MenuItem opr = ((MenuItem) e.getSource());
                opr.hover(false);
            }
        };
    }
}
