package controllers;

import components.PayButtonOperation;
import constants.PaymentOptionsConstants.PAYMENT;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Lucas Oliveira
 */
public class OperationsController {
    public static OperationsController controller;
    public static Container parent;
    
    public MouseAdapter getPayButtonActions() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainController.Controller.changeView(parent, PAYMENT.NAME);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                PayButtonOperation payButton = ((PayButtonOperation) e.getSource());
                payButton.setState(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                PayButtonOperation payButton = ((PayButtonOperation) e.getSource());
                payButton.setState(false);
            }
        };
    }
}
