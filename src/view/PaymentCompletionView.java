package view;

import components.AppName;
import components.Background;
import components.ProceedButton;
import constants.PaymentCompletionConstants.COMPLETION;
import constants.PaymentCompletionConstants.COMPLETION.BACKGROUND;
import constants.PaymentCompletionConstants.COMPLETION.APPNAME;
import constants.PaymentCompletionConstants.COMPLETION.PAY_LABEL;
import constants.PaymentCompletionConstants.COMPLETION.SUBTITLE_1;
import constants.PaymentCompletionConstants.COMPLETION.SUBTITLE_2;
import constants.PaymentCompletionConstants.COMPLETION.CONFIRMATION_SIGN;
import constants.PaymentCompletionConstants.COMPLETION.PROCEED_BUTTON;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Lucas Oliveira
 */
public class PaymentCompletionView extends BaseView {
    public PaymentCompletionView(Container parent) {
        super(COMPLETION.NAME, parent);
        initComponents();
    }
    
    public Background getBackgroundBillPayment() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
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
    
    private JLabel getSubtitle_1() {
        JLabel subtitle = new JLabel(SUBTITLE_1.TEXT);
        subtitle.setForeground(new Color(SUBTITLE_1.R, SUBTITLE_1.G, SUBTITLE_1.B));
        subtitle.setFont(new Font(SUBTITLE_1.FONT_FAMILY, SUBTITLE_1.FONT_WEIGHT,
                SUBTITLE_1.FONT_SIZE));
        subtitle.setBounds(SUBTITLE_1.X, SUBTITLE_1.Y, SUBTITLE_1.W, SUBTITLE_1.H);
        
        return subtitle;
    }
    
    private JLabel getSubtitle_2() {
        JLabel subtitle = new JLabel(SUBTITLE_2.TEXT);
        subtitle.setForeground(new Color(SUBTITLE_2.R, SUBTITLE_2.G, SUBTITLE_2.B));
        subtitle.setFont(new Font(SUBTITLE_2.FONT_FAMILY, SUBTITLE_2.FONT_WEIGHT,
                SUBTITLE_2.FONT_SIZE));
        subtitle.setBounds(SUBTITLE_2.X, SUBTITLE_2.Y, SUBTITLE_2.W, SUBTITLE_2.H);
        
        return subtitle;
    }
    
    private JLabel getConfirmationSign() {
        JLabel confirm = new JLabel();
        confirm.setIcon(new ImageIcon(getClass().getResource(CONFIRMATION_SIGN.IMAGE_PATH + ".png")));
        confirm.setBounds(CONFIRMATION_SIGN.X, CONFIRMATION_SIGN.Y, CONFIRMATION_SIGN.W,
                CONFIRMATION_SIGN.H);
        
        return confirm;
    }
    
    private ProceedButton getProceedButton() {
        return new ProceedButton(PROCEED_BUTTON.X, PROCEED_BUTTON.Y, PROCEED_BUTTON.W,
                PROCEED_BUTTON.H, PROCEED_BUTTON.TOOLTIP, this);
    }
    
    private void initComponents() {
        this.setLayout(null);
        this.add(getPaymentLabel());
        this.add(getConfirmationSign());
        this.add(getSubtitle_1());
        this.add(getSubtitle_2());
        this.add(getAppName());
        this.add(getProceedButton());
        this.add(getBackgroundBillPayment());
    }
}
