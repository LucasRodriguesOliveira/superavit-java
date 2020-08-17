package view;

import components.AddBillButton;
import components.AppName;
import components.Background;
import components.CancelButton;
import components.Menu;
import constants.BillPaymentConstants;
import constants.BillPaymentConstants.BILL.BACKGROUND;
import constants.BillPaymentConstants.BILL.APPNAME;
import constants.BillPaymentConstants.BILL.PAY_LABEL;
import constants.BillPaymentConstants.BILL.ADD_BILL;
import constants.BillPaymentConstants.BILL.CANCEL;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Lucas Oliveira
 */
public class BillPaymentView extends BaseView {
    public BillPaymentView(Container parent) {
        super(BillPaymentConstants.BILL.NAME, parent);
        initComponents();
    }
    
    public Background getBackgroundBillPayment() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
    }
    
    private Menu getMenu() {
        return new Menu(BillPaymentConstants.BILL.NAME);
    }
    
    private AppName getAppName() {
        return new AppName(APPNAME.X, APPNAME.Y, APPNAME.W, APPNAME.H,
                APPNAME.IMAGE_PATH);
    }
    
    private JLabel getPaymentLabel() {
        JLabel paymentLabel = new JLabel(PAY_LABEL.TEXT);
        paymentLabel.setForeground(new Color(PAY_LABEL.R, PAY_LABEL.G, PAY_LABEL.B));
        paymentLabel.setFont(new Font(PAY_LABEL.FONT_FAMILY, PAY_LABEL.FONT_WEIGHT,
                PAY_LABEL.FONT_SIZE));
        paymentLabel.setBounds(PAY_LABEL.X, PAY_LABEL.Y, PAY_LABEL.W, PAY_LABEL.H);
        return paymentLabel;
    }
    
    private AddBillButton getAddBillButton() {
        AddBillButton btn = new AddBillButton(ADD_BILL.X, ADD_BILL.Y,
                ADD_BILL.W, ADD_BILL.H, ADD_BILL.TOOLTIP, ADD_BILL.IMAGE_PATH);
        return btn;
    }
    
    private CancelButton getCancelButton() {
        CancelButton btn = new CancelButton(CANCEL.X, CANCEL.Y,
                CANCEL.W, CANCEL.H, CANCEL.TOOLTIP, CANCEL.IMAGE_PATH);
        return btn;
    }
    
    private void initComponents() {
        this.setLayout(null);
        this.add(getAppName());
        this.add(getMenu());
        this.add(getPaymentLabel());
        this.add(getAddBillButton());
        this.add(getCancelButton());
        this.add(getBackgroundBillPayment());
    }
}
