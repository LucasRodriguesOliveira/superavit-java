package view;

import components.AppName;
import components.Background;
import components.GeneralReportButton;
import components.Menu;
import components.ParcelReportButton;
import components.PayButtonOperation;
import constants.OperationsConstants.APPNAME;
import constants.OperationsConstants.OPERATIONS;
import constants.OperationsConstants.BACKGROUND;
import constants.OperationsConstants.OPERATIONS.OPR_LABEL;
import constants.OperationsConstants.OPERATIONS.SUMMARIES_LABEL;
import constants.OperationsConstants.GENEREAL_REPORT_BTN;
import constants.OperationsConstants.PARCEL_REPORT_BTN;
import constants.OperationsConstants.PAY_BUTTON;
import controllers.OperationsController;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Lucas Oliveira
 */
public class OperationsView extends BaseView {
    
    public OperationsView(Container parent) {
        super(OPERATIONS.NAME, parent);
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
    
    private JLabel getOperacoesLabel() {
        JLabel oprLabel = new JLabel(OPR_LABEL.TEXT);
        oprLabel.setForeground(new Color(OPR_LABEL.R, OPR_LABEL.G, OPR_LABEL.B));
        oprLabel.setFont(new Font(OPR_LABEL.FONT_FAMILY, OPR_LABEL.FONT_WEIGHT,
                OPR_LABEL.FONT_SIZE));
        oprLabel.setBounds(OPR_LABEL.X, OPR_LABEL.Y, OPR_LABEL.W, OPR_LABEL.H);
        return oprLabel;
    }
    
    private JLabel getSummariesLabel() {
        JLabel summarieLabel = new JLabel(SUMMARIES_LABEL.TEXT);
        summarieLabel.setForeground(new Color(SUMMARIES_LABEL.R, SUMMARIES_LABEL.G, SUMMARIES_LABEL.B));
        summarieLabel.setFont(new Font(SUMMARIES_LABEL.FONT_FAMILY, SUMMARIES_LABEL.FONT_WEIGHT,
                SUMMARIES_LABEL.FONT_SIZE));
        summarieLabel.setBounds(SUMMARIES_LABEL.X, SUMMARIES_LABEL.Y, SUMMARIES_LABEL.W, SUMMARIES_LABEL.H);
        return summarieLabel;
    }
    
    private PayButtonOperation getPayButton() {
        PayButtonOperation payButton = new PayButtonOperation(PAY_BUTTON.X,
                PAY_BUTTON.Y, PAY_BUTTON.W, PAY_BUTTON.H, PAY_BUTTON.TOOLTIP,
                PAY_BUTTON.IMAGE_PATH);
        payButton.addMouseListener(OperationsController.controller.getPayButtonActions());
        
        return payButton;
    }
    
    private GeneralReportButton getGeneralReportButton() {
        GeneralReportButton generalReportBtn = new GeneralReportButton(
                GENEREAL_REPORT_BTN.X, GENEREAL_REPORT_BTN.Y, GENEREAL_REPORT_BTN.W,
                GENEREAL_REPORT_BTN.H, GENEREAL_REPORT_BTN.TOOLTIP, GENEREAL_REPORT_BTN.IMAGE_PATH);
        
        return generalReportBtn;
    }
    
    private ParcelReportButton getParcelReportButton() {
        ParcelReportButton parcelReportBtn = new ParcelReportButton(
                PARCEL_REPORT_BTN.X, PARCEL_REPORT_BTN.Y, PARCEL_REPORT_BTN.W,
                PARCEL_REPORT_BTN.H, PARCEL_REPORT_BTN.TOOLTIP, PARCEL_REPORT_BTN.IMAGE_PATH);
        
        return parcelReportBtn;
    }

    private void initComponents() {
        this.setLayout(null);
        
        if(OperationsController.controller == null) {
            OperationsController.controller = new OperationsController();
        }
        
        OperationsController.parent = this.parent;
        
        this.add(getAppName());
        this.add(getMenu());
        this.add(getOperacoesLabel());
        this.add(getSummariesLabel());
        this.add(getPayButton());
        this.add(getGeneralReportButton());
        this.add(getParcelReportButton());
        this.add(getBackgroundOperations());
    }
}
