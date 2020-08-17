package controllers;

import constants.OperationsConstants.OPERATIONS;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Lucas Oliveira
 */
public class PaymentOptionsController {
    public static PaymentOptionsController controller;
    
    public MouseAdapter GoBackButton(Container parent) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainController.Controller.changeView(parent, OPERATIONS.NAME);
            }
        };
    }
    
    public MouseAdapter PayOptionButton(Container parent) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //setCursor(cursor_type);
                //setIcon(hover_image);
            }

            @Override
            public void mouseExited(MouseEvent e){
                //setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                //setIcon(hover_image);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
               // MainController.Controller.changeView(parent, view);
            }
        };
    }
}
