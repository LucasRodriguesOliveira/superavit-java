package view;

import components.AppName;
import components.ArrowBackButton;
import components.Background;
import components.Menu;
import components.PayBillButton;
import constants.OperationsConstants.APPNAME;
import constants.OperationsConstants.OPERATIONS;
import constants.OperationsConstants.BACKGROUND;
import constants.PaymentOptionsConstants.ARROW_BACK;
import constants.PaymentOptionsConstants.PAYMENT;
import constants.PaymentOptionsConstants.PAYMENT.PAY_LABEL;
import constants.PaymentOptionsConstants.BILL_BUTTON;
import controllers.PaymentOptionsController;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Lucas Oliveira
 */
public class PaymentOptionsView extends BaseView {
    
    public PaymentOptionsView(Container parent) {
        super(PAYMENT.NAME, parent);
        initComponents();
    }
    
    public Background getBackgroundOperations() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
    }
    
    private Menu getMenu() {
        return new Menu(OPERATIONS.NAME);
    }
    
    private AppName getAppName() {
        return new AppName(APPNAME.X, APPNAME.Y, APPNAME.W, APPNAME.H,
                APPNAME.IMAGE_PATH);
    }
    
    private ArrowBackButton getGoBackButton() {
        ArrowBackButton arrow = new ArrowBackButton(ARROW_BACK.X, ARROW_BACK.Y,
                ARROW_BACK.W, ARROW_BACK.H);
        //arrow.addMouseListener(PaymentOptionsController.controller.GoBackButton(parent));
        return arrow;
    }
    
    private JLabel getPaymentLabel() {
        JLabel paymentLabel = new JLabel(PAY_LABEL.TEXT);
        paymentLabel.setForeground(new Color(PAY_LABEL.R, PAY_LABEL.G, PAY_LABEL.B));
        paymentLabel.setFont(new Font(PAY_LABEL.FONT_FAMILY, PAY_LABEL.FONT_WEIGHT,
                PAY_LABEL.FONT_SIZE));
        paymentLabel.setBounds(PAY_LABEL.X, PAY_LABEL.Y, PAY_LABEL.W, PAY_LABEL.H);
        return paymentLabel;
    }
    
    private PayBillButton getPayBillButton() {
        PayBillButton btn = new PayBillButton(BILL_BUTTON.X, BILL_BUTTON.Y,
                BILL_BUTTON.W, BILL_BUTTON.H, BILL_BUTTON.TOOLTIP, BILL_BUTTON.IMAGE_PATH);
        return btn;
    }

    private void initComponents() {
        this.setLayout(null);
        if(null == PaymentOptionsController.controller)
          PaymentOptionsController.controller = new PaymentOptionsController();
        this.add(getAppName());
        this.add(getMenu());
        this.add(getPaymentLabel());
        this.add(getPayBillButton());
        this.add(getGoBackButton());
        this.add(getBackgroundOperations());
    }
}
