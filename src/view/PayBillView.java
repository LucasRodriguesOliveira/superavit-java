package view;

import components.AppName;
import components.Background;
import components.CancelButton;
import components.Menu;
import components.PayButton;
import constants.PayBillConstants.BILL;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Lucas Oliveira
 */
public class PayBillView extends BaseView {
    public PayBillView(Container parent) {
        super(BILL.NAME, parent);
        initComponents();
    }
    
    public Background getBackgroundBillPayment() {
        return new Background(BILL.BACKGROUND.X, BILL.BACKGROUND.Y,
                BILL.BACKGROUND.W, BILL.BACKGROUND.H, BILL.BACKGROUND.IMAGE_PATH);
    }
    
    private Menu getMenu() {
        return new Menu(BILL.NAME);
    }
    
    private AppName getAppName() {
        return new AppName(BILL.APPNAME.X, BILL.APPNAME.Y, BILL.APPNAME.W, BILL.APPNAME.H,
                BILL.APPNAME.IMAGE_PATH);
    }
    
    private JLabel getPaymentLabel() {
        JLabel paymentLabel = new JLabel(BILL.PAY_LABEL.TEXT);
        paymentLabel.setForeground(new Color(BILL.PAY_LABEL.R, BILL.PAY_LABEL.G, BILL.PAY_LABEL.B));
        paymentLabel.setFont(new Font(BILL.PAY_LABEL.FONT_FAMILY, BILL.PAY_LABEL.FONT_WEIGHT,
                BILL.PAY_LABEL.FONT_SIZE));
        paymentLabel.setBounds(BILL.PAY_LABEL.X, BILL.PAY_LABEL.Y, BILL.PAY_LABEL.W, BILL.PAY_LABEL.H);
        return paymentLabel;
    }
    
    private JLabel getSubtitle() {
        JLabel subtitle = new JLabel(BILL.SUBTITLE.TEXT);
        subtitle.setForeground(new Color(BILL.SUBTITLE.R, BILL.SUBTITLE.G, BILL.SUBTITLE.B));
        subtitle.setFont(new Font(BILL.SUBTITLE.FONT_FAMILY, BILL.SUBTITLE.FONT_WEIGHT,
                BILL.SUBTITLE.FONT_SIZE));
        subtitle.setBounds(BILL.SUBTITLE.X, BILL.SUBTITLE.Y, BILL.SUBTITLE.W, BILL.SUBTITLE.H);
        
        return subtitle;
    }
    
    private JLabel getBillValue() {
        final String billValue = "20,00";
        JLabel value = new JLabel("R$ " + billValue);
        value.setForeground(new Color(BILL.VALUE.R, BILL.VALUE.G, BILL.VALUE.B));
        value.setFont(new Font(BILL.VALUE.FONT_FAMILY, BILL.VALUE.FONT_WEIGHT,
                BILL.VALUE.FONT_SIZE));
        value.setBounds(BILL.VALUE.X, BILL.VALUE.Y, BILL.VALUE.W, BILL.VALUE.H);
        
        return value;
    }
    
    private CancelButton getCancelButton() {
        CancelButton btn = new CancelButton(BILL.CANCEL.X, BILL.CANCEL.Y,
                BILL.CANCEL.W, BILL.CANCEL.H, BILL.CANCEL.TOOLTIP, BILL.CANCEL.IMAGE_PATH);
        return btn;
    }
    
    private PayButton getPayButton() {
        PayButton btn = new PayButton(BILL.PAY_BTN.X, BILL.PAY_BTN.Y,
                BILL.PAY_BTN.W, BILL.PAY_BTN.H, BILL.PAY_BTN.TOOLTIP, BILL.PAY_BTN.IMAGE_PATH);
        return btn;
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
        this.add(getBackgroundBillPayment());
    }
}
