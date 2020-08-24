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
import constants.FormSignupUserInfoConstants.FORM_FIELD.ADDRESS.*;
import constants.FormSignupUserInfoConstants.FORM_FIELD.PERSONAL;
import constants.FormSignupUserInfoConstants.FORM_FIELD.PERSONAL.*;
import constants.FormSignupUserInfoConstants.FORM_FIELD.TITLE;
import constants.FormSignupUserInfoConstants.FORM_FIELD.SUBTITLE;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private JFormattedTextField ftfPhone;
    private JTextField tfStreet;
    private JTextField tfNumber;
    private JTextField tfComplement;
    private JTextField tfReference;
    private JTextField tfName;
    
    private JLabel lbCountry;
    private JLabel lbState;
    private JLabel lbCity;
    private JLabel lbStreetType;
    private JLabel lbDocumentType;
    private JLabel lbCEP;
    private JLabel lbDocument;
    private JLabel lbStreet;
    private JLabel lbNumber;
    private JLabel lbComplement;
    private JLabel lbReference;
    private JLabel lbName;
    private JLabel lbPhone;
    
    private JLabel btnNext;
    private JLabel btnRegister;
    private JLabel btnBack;
    
    public FormSignupUserInfoView(Container parent) {
        super(USER_INFO.NAME, parent);
        initComponents();
    }
    
    private ImageIcon getImage(String imgPath) {
        return new ImageIcon(this.getClass().getResource(imgPath));
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
    
    private void generateCoutryComponent() {
        String[] countries = new String[]{
          "Selecione um país...", "Brasil", "Japão", "Canadá", "Argentina", "Estados Unidos"
        };
        cbCountry = new JComboBox<>(countries);
        cbCountry.setBounds(COUNTRY.X, COUNTRY.Y, COUNTRY.W, COUNTRY.H);
        cbCountry.setForeground(new Color(COUNTRY.FR, COUNTRY.FG, COUNTRY.FB));
        cbCountry.setBackground(new Color(COUNTRY.BR, COUNTRY.BG, COUNTRY.BB));
        cbCountry.setFont(new Font(COUNTRY.FONT_FAMILY, COUNTRY.FONT_WEIGHT, COUNTRY.FONT_SIZE));
        cbCountry.addItemListener((ItemEvent e) -> {
            if(e.getItem() != countries[0]) {
                cbState.setEnabled(true);
                lbState.setEnabled(true);
            } else {
                cbState.setEnabled(false);
                lbState.setEnabled(false);
                cbCity.setEnabled(false);
                lbCity.setEnabled(false);
                ftfCEP.setEnabled(false);
                lbCEP.setEnabled(false);
                lbStreetType.setEnabled(false);
                cbStreetType.setEnabled(false);
                tfStreet.setEnabled(false);
                lbStreet.setEnabled(false);
            }
        });
    }
    
    private void generateStateComponent() {
        String[] states = new String[]{
            "Selecione um estado...",
          "Amazonas", "Acre", "Ceará", "Mato Grosso", "Minas Gerais", "Pará", "Paraná",
          "São Paulo", "Rio de Janeiro", "Pernambuco"
        };
        
        cbState = new JComboBox<>(states);
        cbState.setBounds(STATE.X, STATE.Y, STATE.W, STATE.H);
        cbState.setForeground(new Color(STATE.FR, STATE.FG, STATE.FB));
        cbState.setBackground(new Color(STATE.BR, STATE.BG, STATE.BB));
        cbState.setFont(new Font(STATE.FONT_FAMILY, STATE.FONT_WEIGHT, STATE.FONT_SIZE));
        cbState.setEnabled(false);
        cbState.addItemListener((ItemEvent e) -> {
            if(e.getItem() != states[0]) {
                cbCity.setEnabled(true);
                lbCity.setEnabled(true);
            } else {
                cbCity.setEnabled(false);
                lbCity.setEnabled(false);
                ftfCEP.setEnabled(false);
                lbCEP.setEnabled(false);
                lbStreetType.setEnabled(false);
                cbStreetType.setEnabled(false);
                tfStreet.setEnabled(false);
                lbStreet.setEnabled(false);
            }
        });
    }
    
    private void generateCityComponent() {
        String[] cities = new String[]{
            "Selecione uma cidade",
          "Toledo", "Cascavel", "Cuiabá", "Ponta Grossa", "Curitiba", "São Paulo", "Florianópolis",
          "Foz do Iguaçu", "Rio de Janeiro", "Recife"
        };
        
        cbCity = new JComboBox<>(cities);
        cbCity.setBounds(CITY.X, CITY.Y, CITY.W, CITY.H);
        cbCity.setForeground(new Color(CITY.FR, CITY.FG, CITY.FB));
        cbCity.setBackground(new Color(CITY.BR, CITY.BG, CITY.BB));
        cbCity.setFont(new Font(CITY.FONT_FAMILY, CITY.FONT_WEIGHT, CITY.FONT_SIZE));
        cbCity.setEnabled(false);
        cbCity.addItemListener((ItemEvent e) -> {
            if(e.getItem() != cities[0]) {
                ftfCEP.setEnabled(true);
                lbCEP.setEnabled(true);
            } else {
                ftfCEP.setEnabled(false);
                lbCEP.setEnabled(false);
                lbStreetType.setEnabled(false);
                cbStreetType.setEnabled(false);
                tfStreet.setEnabled(false);
                lbStreet.setEnabled(false);
            }
        });
    }
    
    private class CEPActions extends KeyAdapter {
        JFormattedTextField cep;
        
        public CEPActions(JFormattedTextField cep) {
            this.cep = cep;
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            String cepText = cep.getText().replace("-", "").trim();
            if(cep.isEditValid() && cepText.length() == 8) {
                lbStreetType.setEnabled(true);
                cbStreetType.setEnabled(true);
            } else {
                lbStreetType.setEnabled(false);
                cbStreetType.setEnabled(false);
                tfStreet.setEnabled(false);
                lbStreet.setEnabled(false);
            }
        }
    }
    
    private void generateCEPComponent() {
        MaskFormatter mask = new MaskFormatter();
        try {
            mask.setMask("#####-###");
        } catch(ParseException pex) {
            // Obviamente vou montar uma mensagem de erro aqui
            JOptionPane.showMessageDialog(parent, "Ocorreu um erro inesperado",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        mask.setValidCharacters("0123456789");
        
        ftfCEP = new JFormattedTextField(mask);
        ftfCEP.setBounds(CEP.X, CEP.Y, CEP.W, CEP.H);
        ftfCEP.setForeground(new Color(CEP.FR, CEP.FG, CEP.FB));
        ftfCEP.setBackground(new Color(CEP.BR, CEP.BG, CEP.BB));
        ftfCEP.setFont(new Font(CEP.FONT_FAMILY, CEP.FONT_WEIGHT, CEP.FONT_SIZE));
        ftfCEP.setEnabled(false);
        ftfCEP.addKeyListener(new CEPActions(ftfCEP));
    }
    
    private void generateStreetTypeComponent() {
        String[] streettypes = {
          "Selecione","Rua", "Avenida", "Rodovia"
        };
        
        cbStreetType = new JComboBox<>(streettypes);
        cbStreetType.setBounds(STREET_TYPE.X, STREET_TYPE.Y, STREET_TYPE.W, STREET_TYPE.H);
        cbStreetType.setForeground(new Color(STREET_TYPE.FR, STREET_TYPE.FG, STREET_TYPE.FB));
        cbStreetType.setBackground(new Color(STREET_TYPE.BR, STREET_TYPE.BG, STREET_TYPE.BB));
        cbStreetType.setFont(new Font(STREET_TYPE.FONT_FAMILY, STREET_TYPE.FONT_WEIGHT, STREET_TYPE.FONT_SIZE));
        cbStreetType.setEnabled(false);
        cbStreetType.addItemListener((ItemEvent e) -> {
            if(e.getItem() != streettypes[0]) {
                tfStreet.setEnabled(true);
                lbStreet.setEnabled(true);
                tfNumber.setEnabled(true);
                lbNumber.setEnabled(true);
                tfComplement.setEnabled(true);
                lbComplement.setEnabled(true);
                tfReference.setEnabled(true);
                lbReference.setEnabled(true);
                btnNext.setEnabled(true);
            } else {
                tfStreet.setEnabled(false);
                lbStreet.setEnabled(false);
                tfNumber.setEnabled(false);
                lbNumber.setEnabled(false);
                tfComplement.setEnabled(false);
                lbComplement.setEnabled(false);
                tfReference.setEnabled(false);
                lbReference.setEnabled(false);
            }
        });
    }
    
    private void generateStreetComponent() {
        tfStreet = new JTextField();
        tfStreet.setBounds(STREET.X, STREET.Y, STREET.W, STREET.H);
        tfStreet.setForeground(new Color(STREET.FR, STREET.FG, STREET.FB));
        tfStreet.setBackground(new Color(STREET.BR, STREET.BG, STREET.BB));
        tfStreet.setFont(new Font(STREET.FONT_FAMILY, STREET.FONT_WEIGHT, STREET.FONT_SIZE));
        tfStreet.setEnabled(false);
    }
    
    private void generateNumberComponent() {
        tfNumber = new JTextField();
        tfNumber.setBounds(NUMBER.X, NUMBER.Y, NUMBER.W, NUMBER.H);
        tfNumber.setForeground(new Color(NUMBER.FR, NUMBER.FG, NUMBER.FB));
        tfNumber.setBackground(new Color(NUMBER.BR, NUMBER.BG, NUMBER.BB));
        tfNumber.setFont(new Font(NUMBER.FONT_FAMILY, NUMBER.FONT_WEIGHT, NUMBER.FONT_SIZE));
        tfNumber.setEnabled(false);
    }
    
    private void generateComplementComponent() {
        tfComplement = new JTextField();
        tfComplement.setBounds(COMPLEMENT.X, COMPLEMENT.Y, COMPLEMENT.W, COMPLEMENT.H);
        tfComplement.setForeground(new Color(COMPLEMENT.FR, COMPLEMENT.FG, COMPLEMENT.FB));
        tfComplement.setBackground(new Color(COMPLEMENT.BR, COMPLEMENT.BG, COMPLEMENT.BB));
        tfComplement.setFont(new Font(COMPLEMENT.FONT_FAMILY, COMPLEMENT.FONT_WEIGHT, COMPLEMENT.FONT_SIZE));
        tfComplement.setEnabled(false);
    }
    
    private void generateReferenceComponent() {
        tfReference = new JTextField();
        tfReference.setBounds(REFERENCE.X, REFERENCE.Y, REFERENCE.W, REFERENCE.H);
        tfReference.setForeground(new Color(REFERENCE.FR, REFERENCE.FG, REFERENCE.FB));
        tfReference.setBackground(new Color(REFERENCE.BR, REFERENCE.BG, REFERENCE.BB));
        tfReference.setFont(new Font(REFERENCE.FONT_FAMILY, REFERENCE.FONT_WEIGHT, REFERENCE.FONT_SIZE));
        tfReference.setEnabled(false);
    }
    
    private class NextButtonActions extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            pnForm.setBounds(PERSONAL.X, pnForm.getY(), PERSONAL.W, pnForm.getHeight());
            layout.last(pnForm);
        }
    }
    
    private void generateNextButton(){
        btnNext = new JLabel(getImage(NEXT_BUTTON.IMG_PATH + ".png"));
        btnNext.setBounds(NEXT_BUTTON.X, NEXT_BUTTON.Y, NEXT_BUTTON.W, NEXT_BUTTON.H);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNext.setToolTipText(NEXT_BUTTON.TOOLTIP);
        btnNext.setEnabled(false);
        btnNext.addMouseListener(new NextButtonActions());
    }
    
    private void generateCoutryLabel() {
        lbCountry = new JLabel(COUNTRY_LABEL.TEXT);
        lbCountry.setBounds(COUNTRY_LABEL.X, COUNTRY_LABEL.Y, COUNTRY_LABEL.W, COUNTRY_LABEL.H);
        lbCountry.setForeground(new Color(COUNTRY_LABEL.R, COUNTRY_LABEL.G, COUNTRY_LABEL.B));
        lbCountry.setFont(new Font(COUNTRY_LABEL.FONT_FAMILY, COUNTRY_LABEL.FONT_WEIGHT, COUNTRY_LABEL.FONT_SIZE));
        lbCountry.setDisplayedMnemonic('P');
        lbCountry.setLabelFor(cbCountry);
    }
    
    private void generateStateLabel() {
        lbState = new JLabel(STATE_LABEL.TEXT);
        lbState.setBounds(STATE_LABEL.X, STATE_LABEL.Y, STATE_LABEL.W, STATE_LABEL.H);
        lbState.setForeground(new Color(STATE_LABEL.R, STATE_LABEL.G, STATE_LABEL.B));
        lbState.setFont(new Font(STATE_LABEL.FONT_FAMILY, STATE_LABEL.FONT_WEIGHT, STATE_LABEL.FONT_SIZE));
        lbState.setDisplayedMnemonic('E');
        lbState.setLabelFor(cbState);
        lbState.setEnabled(false);
    }
    
    private void generateCityLabel() {
        lbCity = new JLabel(CITY_LABEL.TEXT);
        lbCity.setBounds(CITY_LABEL.X, CITY_LABEL.Y, CITY_LABEL.W, CITY_LABEL.H);
        lbCity.setForeground(new Color(CITY_LABEL.R, CITY_LABEL.G, CITY_LABEL.B));
        lbCity.setFont(new Font(CITY_LABEL.FONT_FAMILY, CITY_LABEL.FONT_WEIGHT, CITY_LABEL.FONT_SIZE));
        lbCity.setDisplayedMnemonic('C');
        lbCity.setLabelFor(cbCity);
        lbCity.setEnabled(false);
    }
    
    private void generateCEPLabel() {
        lbCEP = new JLabel(CEP_LABEL.TEXT);
        lbCEP.setBounds(CEP_LABEL.X, CEP_LABEL.Y, CEP_LABEL.W, CEP_LABEL.H);
        lbCEP.setForeground(new Color(CEP_LABEL.R, CEP_LABEL.G, CEP_LABEL.B));
        lbCEP.setFont(new Font(CEP_LABEL.FONT_FAMILY, CEP_LABEL.FONT_WEIGHT, CEP_LABEL.FONT_SIZE));
        lbCEP.setEnabled(false);
    }
    
    private void generateStreetTypeLabel() {
        lbStreetType = new JLabel(STREET_TYPE_LABEL.TEXT);
        lbStreetType.setBounds(STREET_TYPE_LABEL.X, STREET_TYPE_LABEL.Y,
                STREET_TYPE_LABEL.W, STREET_TYPE_LABEL.H);
        lbStreetType.setForeground(new Color(STREET_TYPE_LABEL.R, STREET_TYPE_LABEL.G,
                STREET_TYPE_LABEL.B));
        lbStreetType.setFont(new Font(STREET_TYPE_LABEL.FONT_FAMILY, STREET_TYPE_LABEL.FONT_WEIGHT,
                STREET_TYPE_LABEL.FONT_SIZE));
        lbStreetType.setEnabled(false);
    }
    
    private void generateStreetLabel() {
        lbStreet = new JLabel(STREET_LABEL.TEXT);
        lbStreet.setBounds(STREET_LABEL.X, STREET_LABEL.Y, STREET_LABEL.W, STREET_LABEL.H);
        lbStreet.setForeground(new Color(STREET_LABEL.R, STREET_LABEL.G, STREET_LABEL.B));
        lbStreet.setFont(new Font(STREET_LABEL.FONT_FAMILY, STREET_LABEL.FONT_WEIGHT,
                STREET_LABEL.FONT_SIZE));
        lbStreet.setEnabled(false);
    }
    
    private void generateNumberLabel() {
        lbNumber = new JLabel(NUMBER_LABEL.TEXT);
        lbNumber.setBounds(NUMBER_LABEL.X, NUMBER_LABEL.Y, NUMBER_LABEL.W, NUMBER_LABEL.H);
        lbNumber.setForeground(new Color(NUMBER_LABEL.R, NUMBER_LABEL.G, NUMBER_LABEL.B));
        lbNumber.setFont(new Font(NUMBER_LABEL.FONT_FAMILY, NUMBER_LABEL.FONT_WEIGHT,
                NUMBER_LABEL.FONT_SIZE));
        lbNumber.setEnabled(false);
    }
    
    private void generateComplementLabel() {
        lbComplement = new JLabel(COMPLEMENT_LABEL.TEXT);
        lbComplement.setBounds(COMPLEMENT_LABEL.X, COMPLEMENT_LABEL.Y, COMPLEMENT_LABEL.W,
                COMPLEMENT_LABEL.H);
        lbComplement.setForeground(new Color(COMPLEMENT_LABEL.R, COMPLEMENT_LABEL.G,
                COMPLEMENT_LABEL.B));
        lbComplement.setFont(new Font(COMPLEMENT_LABEL.FONT_FAMILY, COMPLEMENT_LABEL.FONT_WEIGHT,
                COMPLEMENT_LABEL.FONT_SIZE));
        lbComplement.setEnabled(false);
    }
    
    private void generateReferenceLabel() {
        lbReference = new JLabel(REFERENCE_LABEL.TEXT);
        lbReference.setBounds(REFERENCE_LABEL.X, REFERENCE_LABEL.Y, REFERENCE_LABEL.W,
                REFERENCE_LABEL.H);
        lbReference.setForeground(new Color(REFERENCE_LABEL.R, REFERENCE_LABEL.G,
                REFERENCE_LABEL.B));
        lbReference.setFont(new Font(REFERENCE_LABEL.FONT_FAMILY, REFERENCE_LABEL.FONT_WEIGHT,
                REFERENCE_LABEL.FONT_SIZE));
        lbReference.setEnabled(false);
    }
    
    private void generateAddressLabels() {
        generateCoutryLabel();
        generateStateLabel();
        generateCityLabel();
        generateCEPLabel();
        generateStreetTypeLabel();
        generateStreetLabel();
        generateNumberLabel();
        generateComplementLabel();
        generateReferenceLabel();
    }
    
    private void generateAddressComponents() {
        generateCoutryComponent();
        generateStateComponent();
        generateCityComponent();
        generateCEPComponent();
        generateStreetTypeComponent();
        generateStreetComponent();
        generateNumberComponent();
        generateComplementComponent();
        generateReferenceComponent();
        generateNextButton();
        
        generateAddressLabels();
    }
    
    private void generateFormAddress(JLabel background) {
        generateAddressComponents();
        background.setBounds(0, 0, ADDRESS.W, FORM_FIELD.H);
        
        pnFormAddress = new JPanel();
        pnFormAddress.setLayout(null);
        pnFormAddress.setBounds(0, 0, ADDRESS.W, FORM_FIELD.H);
        
        pnFormAddress.add(getTitle());
        pnFormAddress.add(getSubtitle(SUBTITLE.TEXT_ADDRESS));
        pnFormAddress.add(lbCountry);
        pnFormAddress.add(cbCountry);
        pnFormAddress.add(lbState);
        pnFormAddress.add(cbState);
        pnFormAddress.add(lbCity);
        pnFormAddress.add(cbCity);
        pnFormAddress.add(lbCEP);
        pnFormAddress.add(ftfCEP);
        pnFormAddress.add(cbStreetType);
        pnFormAddress.add(lbStreetType);
        pnFormAddress.add(tfStreet);
        pnFormAddress.add(lbStreet);
        pnFormAddress.add(tfNumber);
        pnFormAddress.add(lbNumber);
        pnFormAddress.add(tfComplement);
        pnFormAddress.add(lbComplement);
        pnFormAddress.add(tfReference);
        pnFormAddress.add(lbReference);
        pnFormAddress.add(btnNext);
        pnFormAddress.add(background);
    }
    
    private void generateNameComponent() {
        tfName = new JTextField();
        tfName.setBounds(NAME.X, NAME.Y, NAME.W, NAME.H);
        tfName.setForeground(new Color(NAME.FR, NAME.FG, NAME.FB));
        tfName.setBackground(new Color(NAME.BR, NAME.BG, NAME.BB));
        tfName.setFont(new Font(NAME.FONT_FAMILY, NAME.FONT_WEIGHT, NAME.FONT_SIZE));
    }
    
    private void generateDocumentTypeComponent() {
        String[] types = {
          "RG", "CPF"
        };
        
        cbDocumentType = new JComboBox<>(types);
        cbDocumentType.setBounds(DOCUMENT_TYPE.X, DOCUMENT_TYPE.Y, DOCUMENT_TYPE.W,
                DOCUMENT_TYPE.H);
        cbDocumentType.setForeground(new Color(DOCUMENT_TYPE.FR, DOCUMENT_TYPE.FG,
                DOCUMENT_TYPE.FB));
        cbDocumentType.setBackground(new Color(DOCUMENT_TYPE.BR, DOCUMENT_TYPE.BG,
                DOCUMENT_TYPE.BB));
        cbDocumentType.setFont(new Font(DOCUMENT_TYPE.FONT_FAMILY, DOCUMENT_TYPE.FONT_WEIGHT,
                DOCUMENT_TYPE.FONT_SIZE));
    }
    
    private void generateDocumentComponent() {
        MaskFormatter mask = new MaskFormatter();
        try {
            mask.setMask("###.###.###-#");
        } catch(ParseException pex) {
            // Obviamente vou montar uma mensagem de erro aqui
            JOptionPane.showMessageDialog(parent, "Ocorreu um erro inesperado",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        mask.setValidCharacters("0123456789");
        
        ftfDocument = new JFormattedTextField(mask);
        ftfDocument.setBounds(DOCUMENT.X, DOCUMENT.Y, DOCUMENT.W, DOCUMENT.H);
        ftfDocument.setForeground(new Color(DOCUMENT.FR, DOCUMENT.FG, DOCUMENT.FB));
        ftfDocument.setBackground(new Color(DOCUMENT.BR, DOCUMENT.BG, DOCUMENT.BB));
        ftfDocument.setFont(new Font(DOCUMENT.FONT_FAMILY, DOCUMENT.FONT_WEIGHT,
                DOCUMENT.FONT_SIZE));
    }
    
    private void generatePhoneComponent() {
        MaskFormatter mask = new MaskFormatter();
        try {
            mask.setMask("(##) #####-####");
        } catch(ParseException pex) {
            // Obviamente vou montar uma mensagem de erro aqui
            JOptionPane.showMessageDialog(parent, "Ocorreu um erro inesperado",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        mask.setValidCharacters("0123456789");
        
        ftfPhone = new JFormattedTextField(mask);
        ftfPhone.setBounds(PHONE.X, PHONE.Y, PHONE.W, PHONE.H);
        ftfPhone.setForeground(new Color(PHONE.FR, PHONE.FG, PHONE.FB));
        ftfPhone.setBackground(new Color(PHONE.BR, PHONE.BG, PHONE.BB));
        ftfPhone.setFont(new Font(PHONE.FONT_FAMILY, PHONE.FONT_WEIGHT,
                PHONE.FONT_SIZE));
    }
    
    private void generateRegisterButton() {
        btnRegister = new JLabel(getImage(REGISTER_BUTTON.IMG_PATH + ".png"));
        btnRegister.setBounds(REGISTER_BUTTON.X, REGISTER_BUTTON.Y, REGISTER_BUTTON.W,
                REGISTER_BUTTON.H);
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.setToolTipText(REGISTER_BUTTON.TOOLTIP);
    }
    
    private class GoBackActions extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            pnForm.setBounds(ADDRESS.X, pnForm.getY(), ADDRESS.W, pnForm.getHeight());
            layout.first(pnForm);
        }
    }
    
    private void generateGoBackButton() {
        btnBack = new JLabel(getImage(BACK_BUTTON.IMG_PATH + ".png"));
        btnBack.setBounds(BACK_BUTTON.X, BACK_BUTTON.Y, BACK_BUTTON.W,
                BACK_BUTTON.H);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.setToolTipText(BACK_BUTTON.TOOLTIP);
        btnBack.addMouseListener(new GoBackActions());
    }
    
    private void generateNameLabel() {
        lbName = new JLabel(NAME_LABEL.TEXT);
        lbName.setBounds(NAME_LABEL.X, NAME_LABEL.Y, NAME_LABEL.W, NAME_LABEL.H);
        lbName.setForeground(new Color(NAME_LABEL.R, NAME_LABEL.G, NAME_LABEL.B));
        lbName.setFont(new Font(NAME_LABEL.FONT_FAMILY, NAME_LABEL.FONT_WEIGHT, NAME_LABEL.FONT_SIZE));
    }
    
    private void generateDocumentTypeLabel() {
        lbDocumentType = new JLabel(DOCUMENT_TYPE_LABEL.TEXT);
        lbDocumentType.setBounds(DOCUMENT_TYPE_LABEL.X, DOCUMENT_TYPE_LABEL.Y,
                DOCUMENT_TYPE_LABEL.W, DOCUMENT_TYPE_LABEL.H);
        lbDocumentType.setForeground(new Color(DOCUMENT_TYPE_LABEL.R, DOCUMENT_TYPE_LABEL.G,
                DOCUMENT_TYPE_LABEL.B));
        lbDocumentType.setFont(new Font(DOCUMENT_TYPE_LABEL.FONT_FAMILY,
                DOCUMENT_TYPE_LABEL.FONT_WEIGHT, DOCUMENT_TYPE_LABEL.FONT_SIZE));
    }
    
    private void generateDocumentLabel() {
        lbDocument = new JLabel(DOCUMENT_LABEL.TEXT);
        lbDocument.setBounds(DOCUMENT_LABEL.X, DOCUMENT_LABEL.Y,
                DOCUMENT_LABEL.W, DOCUMENT_LABEL.H);
        lbDocument.setForeground(new Color(DOCUMENT_LABEL.R, DOCUMENT_LABEL.G,
                DOCUMENT_LABEL.B));
        lbDocument.setFont(new Font(DOCUMENT_LABEL.FONT_FAMILY,
                DOCUMENT_LABEL.FONT_WEIGHT, DOCUMENT_LABEL.FONT_SIZE));
    }
    
    private void generatePhoneLabel() {
        lbPhone = new JLabel(PHONE_LABEL.TEXT);
        lbPhone.setBounds(PHONE_LABEL.X, PHONE_LABEL.Y,
                PHONE_LABEL.W, PHONE_LABEL.H);
        lbPhone.setForeground(new Color(PHONE_LABEL.R, PHONE_LABEL.G,
                PHONE_LABEL.B));
        lbPhone.setFont(new Font(PHONE_LABEL.FONT_FAMILY,
                PHONE_LABEL.FONT_WEIGHT, PHONE_LABEL.FONT_SIZE));
    }
    
    private void generatePersonalLabels() {
        generateNameLabel();
        generateDocumentTypeLabel();
        generateDocumentLabel();
        generatePhoneLabel();
    }
    
    private void generatePersonalComponents() {
        generateNameComponent();
        generateDocumentTypeComponent();
        generateDocumentComponent();
        generatePhoneComponent();
        generateRegisterButton();
        generateGoBackButton();
        
        generatePersonalLabels();
    }
    
    private void generateFormPersonal(JLabel background) {
        generatePersonalComponents();
        background.setBounds(0, 0, PERSONAL.W, FORM_FIELD.H);
        pnFormPersonal = new JPanel();
        pnFormPersonal.setLayout(null);
        pnFormPersonal.setBounds(0, 0, PERSONAL.W, FORM_FIELD.H);
        pnFormPersonal.add(getTitle());
        pnFormPersonal.add(getSubtitle(SUBTITLE.TEXT_PERSONAL));
        pnFormPersonal.add(tfName);
        pnFormPersonal.add(lbName);
        pnFormPersonal.add(cbDocumentType);
        pnFormPersonal.add(lbDocumentType);
        pnFormPersonal.add(ftfDocument);
        pnFormPersonal.add(lbDocument);
        pnFormPersonal.add(ftfPhone);
        pnFormPersonal.add(lbPhone);
        pnFormPersonal.add(btnRegister);
        pnFormPersonal.add(btnBack);
        pnFormPersonal.add(background);
    }
    
    private JPanel getForm() {
        layout = new CardLayout();
        pnForm = new JPanel(layout);
        pnForm.setBounds(ADDRESS.X, FORM_FIELD.Y, ADDRESS.W, FORM_FIELD.H);
        
        generateFormAddress(new JLabel(getImage(FORM_FIELD.IMG_PATH + ".png")));
        generateFormPersonal(new JLabel(getImage(FORM_FIELD.IMG_PATH + ".png")));
        
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
