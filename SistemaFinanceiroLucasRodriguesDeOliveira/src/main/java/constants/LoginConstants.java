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
        public static final String IMAGE_PATH = "/Background-blue";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class APPNAME {
        public static final int X = 393;
        public static final int Y = 5;
        public static final int W = 500;
        public static final int H = 190;
        public static final String IMAGE_PATH = "/Appname";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class CLOSE_BUTTON {
        public static final int X = 1230;
        public static final int Y = 30;
        public static final int W = 25;
        public static final int H = 25;
        public static final String TOOLTIP = "Fechar o Sistema";
        public static final String IMAGE_PATH = "/Botão Fechar";
        public static final String IMAGE_EXTENSION = ".png";
        public static final String IMAGE_HOVER_PATH = " - hover.png";
    }
    
    public abstract class FORM {
        public static final int X = 300;
        public static final int Y = 250;
        public static final int W = 700;
        public static final int H = 450;
        public static final String BACKGROUND_IMAGE = "/FormBackground";
        
        public static final String BTN_CADASTRO_IMAGE = "/Botão de Acesso";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class LOGIN_FIELD {
        public static final int X = 300;
        public static final int Y = 230;
        public static final int W = 368;
        public static final int H = 138;
        public static final String IMAGE = "/Botão de Acesso";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class SIGNUP_FIELD {
        public static final int X = 650;
        public static final int Y = 230;
        public static final int W = 350;
        public static final int H = 138;
        public static final String IMAGE = "/Botão de Cadastro";
        public static final String IMAGE_EXTENSION = ".png";
    }
}
