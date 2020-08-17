package constants;

import constants.MainConstants.MAIN;
/**
 *
 * @author Lucas Oliveira
 */
public abstract class LoginConstants {
    public abstract class LOGIN {
        public static final String NAME = "LOGIN";
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = MAIN.HEIGHT;
        public static final int W = MAIN.WIDTH;
    }
    
    public abstract class BACKGROUND {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MAIN.WIDTH;
        public static final int H = MAIN.HEIGHT;
        public static final String IMAGE_PATH = "/resources/Background-blue";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class APPNAME {
        public static final int X = 393;
        public static final int Y = 5;
        public static final int W = 500;
        public static final int H = 190;
        public static final String IMAGE_PATH = "/resources/Appname";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class CLOSE_BUTTON {
        public static final int X = 1230;
        public static final int Y = 30;
        public static final int W = 25;
        public static final int H = 25;
        public static final String TOOLTIP = "Fechar o Sistema";
        public static final String IMAGE_PATH = "/resources/Botão Fechar";
        public static final String IMAGE_EXTENSION = ".png";
        public static final String IMAGE_HOVER_PATH = " - hover.png";
    }
    
    public abstract class FORM {
        public static final int X = 300;
        public static final int Y = 250;
        public static final int W = 700;
        public static final int H = 450;
        public static final String BACKGROUND_IMAGE = "/resources/FormBackground";
        
        public static final String BTN_CADASTRO_IMAGE = "/Botão de Acesso";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class LOGIN_FIELD {
        public static final int X = 300;
        public static final int Y = 238;
        public static final int W = 350;
        public static final int H = 130;
        public static final String IMAGE = "/resources/Botão de Acesso";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class SIGNUP_FIELD {
        public static final int X = 650;
        public static final int Y = 238;
        public static final int W = 350;
        public static final int H = 130;
        public static final String IMAGE = "/resources/Botão de Cadastro";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class FORM_FIELD {
        public static final int X = 309;
        public static final int Y = 370;
        public static final int W = 691;
        public static final int H = 326;
    }
    
    public abstract class LOGIN_FORM {
        public static final int X = FORM_FIELD.X;
        public static final int Y = FORM_FIELD.Y;
        public static final int W = FORM_FIELD.W;
        public static final int H = FORM_FIELD.H;
    }
    
    public abstract class EMAIL_LABEL {
        public static final int X = 200;
        public static final int Y = 50;
        public static final int W = 100;
        public static final int H = 30;
        public static final String TEXT = "E-mail:";
        public static final char MNEMONIC = 'E';
    }
    
    public abstract class EMAIL_INPUT {
        public static final int X = 200;
        public static final int Y = 100;
        public static final int W = 300;
        public static final int H = 30;
    }
    
    public abstract class PASS_LABEL {
        public static final int X = 200;
        public static final int Y = 150;
        public static final int W = 100;
        public static final int H = 30;
        public static final String TEXT = "Senha:";
        public static final char MNEMONIC = 'S';
    }
    
    public abstract class PASS_INPUT {
        public static final int X = 200;
        public static final int Y = 200;
        public static final int W = 300;
        public static final int H = 30;
    }
    
    public abstract class LOGIN_BUTTON {
        public static final int X = 510;
        public static final int Y = 250;
        public static final int W = 160;
        public static final int H = 80;
        public static final String IMAGE_PATH = "/resources/Botão Login";
    }
    
    public abstract class REGISTER_BUTTON {
        public static final int X = 510;
        public static final int Y = 250;
        public static final int W = 160;
        public static final int H = 80;
        public static final String IMAGE_PATH = "/resources/Botão Cadastrar";
    }
}
