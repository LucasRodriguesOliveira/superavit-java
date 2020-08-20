package view;

import components.AppName;
import components.ArrowBackButton;
import components.Background;
import components.CloseButton;
import java.awt.Container;
import constants.FormSignupUserInfoConstants.USER_INFO;
import constants.FormSignupUserInfoConstants.BACKGROUND;
import constants.FormSignupUserInfoConstants.APPNAME;
import constants.FormSignupUserInfoConstants.CLOSE_BUTTON;
import constants.FormSignupUserInfoConstants.ARROW_BACK;
import constants.FormSignupUserInfoConstants.SIGNUP_FIELD;
import constants.FormSignupUserInfoConstants.FORM_FIELD;
import constants.FormSignupUserInfoConstants.FORM_FIELD.ADDRESS;
import constants.FormSignupUserInfoConstants.FORM_FIELD.ADDRESS.COUNTRY;
import constants.FormSignupUserInfoConstants.FORM_FIELD.PERSONAL;
import constants.FormSignupUserInfoConstants.FORM_FIELD.TITLE;
import constants.FormSignupUserInfoConstants.FORM_FIELD.SUBTITLE;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lucas Oliveira
 */
public final class FormSignupUserInfoView extends BaseView {
    private JPanel pnForm;
    private JPanel pnFormPersonal;
    private JPanel pnFormAddress;
    private CardLayout layout;
    
    private JComboBox<String> cbCountry;
    private JComboBox<String> cbState;
    private JComboBox<String> cbCity;
    private JComboBox<String> cbStreetType;
    private JComboBox<String> cbDocumentType;
    
    private JFormattedTextField ftfCEP;
    private JFormattedTextField ftfDocument;
    private JTextField tfStreet;
    private JTextField tfNumber;
    private JTextField tfComplement;
    private JTextField tfReference;
    private JTextField tfName;
    private JTextField tfPhone;
    
    public FormSignupUserInfoView(Container parent) {
        super(USER_INFO.NAME, parent);
        initComponents();
    }
    
    private Background getBackgroundImage() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
    }
    
    private AppName getAppName() {
        return new AppName(APPNAME.X, APPNAME.Y,
                APPNAME.W, APPNAME.H, APPNAME.IMAGE_PATH);
    }
    
    private CloseButton getCloseButton() {
        return new CloseButton(CLOSE_BUTTON.X, CLOSE_BUTTON.Y,
                CLOSE_BUTTON.W, CLOSE_BUTTON.H, CLOSE_BUTTON.TOOLTIP, this.parent);
    }
    
    private ArrowBackButton getGoBackButton() {
        ArrowBackButton arrow = new ArrowBackButton(ARROW_BACK.X, ARROW_BACK.Y,
                ARROW_BACK.W, ARROW_BACK.H);
        return arrow;
    }
    
    private JLabel getSignupButtonImage() {
        JLabel btn = new JLabel();
        btn.setIcon(new ImageIcon(getClass().getResource(SIGNUP_FIELD.IMAGE + ".png")));
        btn.setBounds(SIGNUP_FIELD.X, SIGNUP_FIELD.Y, SIGNUP_FIELD.W, SIGNUP_FIELD.H);
        
        return btn;
    }
    
    private JLabel getTitle() {
        JLabel title = new JLabel(TITLE.TEXT);
        title.setBounds(TITLE.X, TITLE.Y, TITLE.W, TITLE.H);
        title.setForeground(new Color(TITLE.R, TITLE.G, TITLE.B));
        title.setFont(new Font(TITLE.FONT_FAMILY, TITLE.FONT_WEIGHT, TITLE.FONT_SIZE));
        
        return title;
    }
    
    private JLabel getSubtitle(String text) {
        JLabel subtitle = new JLabel(text);
        subtitle.setBounds(SUBTITLE.X, SUBTITLE.Y, SUBTITLE.W, SUBTITLE.H);
        subtitle.setForeground(new Color(SUBTITLE.R, SUBTITLE.G, SUBTITLE.B));
        subtitle.setFont(new Font(SUBTITLE.FONT_FAMILY, SUBTITLE.FONT_WEIGHT, SUBTITLE.FONT_SIZE));
        
        return subtitle;
    }
    
    private void generateAddressComponents() {
        String[] countries = new String[]{
          "Brasil", "Japão", "Canadá", "Argentina", "Estados Unidos"
        };
        cbCountry = new JComboBox<>(countries);
        cbCountry.setBounds(COUNTRY.X, COUNTRY.Y, COUNTRY.W, COUNTRY.H);
        cbCountry.setForeground(new Color(COUNTRY.FR, COUNTRY.FG, COUNTRY.FB));
        cbCountry.setBackground(new Color(COUNTRY.BR, COUNTRY.BG, COUNTRY.BB));
        cbCountry.setFont(new Font(COUNTRY.FONT_FAMILY, COUNTRY.FONT_WEIGHT, COUNTRY.FONT_SIZE));
    }
    
    private void generateFormAddress(JLabel background) {
        generateAddressComponents();
        background.setBounds(0, 0, ADDRESS.W, FORM_FIELD.H);
        
        pnFormAddress = new JPanel();
        pnFormAddress.setLayout(null);
        pnFormAddress.setBounds(0, 0, ADDRESS.W, FORM_FIELD.H);
        
        pnFormAddress.add(getTitle());
        pnFormAddress.add(getSubtitle(SUBTITLE.TEXT_ADDRESS));
        pnFormAddress.add(cbCountry);
        pnFormAddress.add(background);
    }
    
    private void generateFormPersonal(JLabel background) {
        background.setBounds(0, 0, PERSONAL.W, FORM_FIELD.H);
        pnFormPersonal = new JPanel();
        pnFormPersonal.setLayout(null);
        pnFormPersonal.setBounds(0, 0, PERSONAL.W, FORM_FIELD.H);
        pnFormPersonal.add(getTitle());
        pnFormPersonal.add(getSubtitle(SUBTITLE.TEXT_PERSONAL));
        pnFormPersonal.add(background);
    }
    
    private JPanel getForm() {
        layout = new CardLayout();
        pnForm = new JPanel(layout);
        pnForm.setBounds(ADDRESS.X, FORM_FIELD.Y, ADDRESS.W, FORM_FIELD.H);
        
        generateFormAddress(new JLabel(new ImageIcon(getClass().getResource(
                FORM_FIELD.IMG_PATH + ".png"))));
        generateFormPersonal(new JLabel(new ImageIcon(getClass().getResource(
                FORM_FIELD.IMG_PATH + ".png"))));
        
        pnForm.add(pnFormAddress);
        pnForm.add(pnFormPersonal);
        
        return pnForm;
    }
    
    public void initComponents() {
        itens.add(getAppName());
        itens.add(getCloseButton());
        itens.add(getGoBackButton());
        itens.add(getSignupButtonImage());
        this.add(getForm());
        itens.add(getBackgroundImage());
        initProps();
    }
}
