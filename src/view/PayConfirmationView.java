package view;

import components.AppName;
import components.Background;
import components.CancelButton;
import components.Menu;
import components.PayButton;
import constants.PayConfirmationConstants.CONFIRMATION;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Lucas Oliveira
 */
public class PayConfirmationView extends BaseView {
    public PayConfirmationView(Container parent) {
        super(CONFIRMATION.NAME, parent);
        initComponents();
    }
    
    public Background getBackgroundBillPayment() {
        return new Background(CONFIRMATION.BACKGROUND.X, CONFIRMATION.BACKGROUND.Y,
                CONFIRMATION.BACKGROUND.W, CONFIRMATION.BACKGROUND.H, CONFIRMATION.BACKGROUND.IMAGE_PATH);
    }
    
    private Menu getMenu() {
        return new Menu(CONFIRMATION.NAME);
    }
    
    private AppName getAppName() {
        return new AppName(CONFIRMATION.APPNAME.X, CONFIRMATION.APPNAME.Y, CONFIRMATION.APPNAME.W, CONFIRMATION.APPNAME.H,
                CONFIRMATION.APPNAME.IMAGE_PATH);
    }
    
    private JLabel getPaymentLabel() {
        JLabel paymentLabel = new JLabel(CONFIRMATION.PAY_LABEL.TEXT);
        paymentLabel.setForeground(new Color(CONFIRMATION.PAY_LABEL.R, CONFIRMATION.PAY_LABEL.G, CONFIRMATION.PAY_LABEL.B));
        paymentLabel.setFont(new Font(CONFIRMATION.PAY_LABEL.FONT_FAMILY, CONFIRMATION.PAY_LABEL.FONT_WEIGHT,
                CONFIRMATION.PAY_LABEL.FONT_SIZE));
        paymentLabel.setBounds(CONFIRMATION.PAY_LABEL.X, CONFIRMATION.PAY_LABEL.Y, CONFIRMATION.PAY_LABEL.W, CONFIRMATION.PAY_LABEL.H);
        return paymentLabel;
    }
    
    private JLabel getSubtitle() {
        JLabel subtitle = new JLabel(CONFIRMATION.SUBTITLE.TEXT);
        subtitle.setForeground(new Color(CONFIRMATION.SUBTITLE.R, CONFIRMATION.SUBTITLE.G, CONFIRMATION.SUBTITLE.B));
        subtitle.setFont(new Font(CONFIRMATION.SUBTITLE.FONT_FAMILY, CONFIRMATION.SUBTITLE.FONT_WEIGHT,
                CONFIRMATION.SUBTITLE.FONT_SIZE));
        subtitle.setBounds(CONFIRMATION.SUBTITLE.X, CONFIRMATION.SUBTITLE.Y, CONFIRMATION.SUBTITLE.W, CONFIRMATION.SUBTITLE.H);
        
        return subtitle;
    }
    
    private JLabel getBillValue() {
        final String billValue = "20,00";
        JLabel value = new JLabel("R$ " + billValue);
        value.setForeground(new Color(CONFIRMATION.VALUE.R, CONFIRMATION.VALUE.G, CONFIRMATION.VALUE.B));
        value.setFont(new Font(CONFIRMATION.VALUE.FONT_FAMILY, CONFIRMATION.VALUE.FONT_WEIGHT,
                CONFIRMATION.VALUE.FONT_SIZE));
        value.setBounds(CONFIRMATION.VALUE.X, CONFIRMATION.VALUE.Y, CONFIRMATION.VALUE.W, CONFIRMATION.VALUE.H);
        
        return value;
    }
    
    private CancelButton getCancelButton() {
        CancelButton btn = new CancelButton(CONFIRMATION.CANCEL.X, CONFIRMATION.CANCEL.Y,
                CONFIRMATION.CANCEL.W, CONFIRMATION.CANCEL.H, CONFIRMATION.CANCEL.TOOLTIP, CONFIRMATION.CANCEL.IMAGE_PATH);
        return btn;
    }
    
    private PayButton getPayButton() {
        PayButton btn = new PayButton(CONFIRMATION.PAY_BTN.X, CONFIRMATION.PAY_BTN.Y,
                CONFIRMATION.PAY_BTN.W, CONFIRMATION.PAY_BTN.H, CONFIRMATION.PAY_BTN.TOOLTIP, CONFIRMATION.PAY_BTN.IMAGE_PATH);
        return btn;
    }
    
    private JLabel getPaymentMethodsLabel() {
        JLabel paymethods = new JLabel(CONFIRMATION.PAY_METHODS.TEXT);
        paymethods.setForeground(new Color(CONFIRMATION.PAY_METHODS.R, CONFIRMATION.PAY_METHODS.G, CONFIRMATION.PAY_METHODS.B));
        paymethods.setFont(new Font(CONFIRMATION.PAY_METHODS.FONT_FAMILY, CONFIRMATION.PAY_METHODS.FONT_WEIGHT,
                CONFIRMATION.PAY_METHODS.FONT_SIZE));
        paymethods.setBounds(CONFIRMATION.PAY_METHODS.X, CONFIRMATION.PAY_METHODS.Y, CONFIRMATION.PAY_METHODS.W, CONFIRMATION.PAY_METHODS.H);
        
        return paymethods;
    }
    
    private void initComponents() {
        this.setLayout(null);
        this.add(getAppName());
        this.add(getMenu());
        this.add(getPaymentLabel());
        this.add(getSubtitle());
        this.add(getCancelButton());
        this.add(getPayButton());
        this.add(getBillValue());
        this.add(getPaymentMethodsLabel());
        this.add(getBackgroundBillPayment());
    }
}
