package constants;

import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class FormSignupUserInfoConstants {
    public abstract class USER_INFO {
        public static final String NAME = "USER_INFO";
    }
    
    public abstract class BACKGROUND {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MainConstants.MAIN.WIDTH;
        public static final int H = MainConstants.MAIN.HEIGHT;
        public static final String IMAGE_PATH = "/resources/Background-blue";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class APPNAME {
        public static final int X = 15;
        public static final int Y = 5;
        public static final int W = 200;
        public static final int H = 85;
        public static final String IMAGE_PATH = "/resources/Appname - menu";
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
        
    public abstract class ARROW_BACK {
        public static final int X = 35;
        public static final int Y = 125;
        public static final int W = 50;
        public static final int H = 50;
        public static final String IMAGE_PATH = "/resources/Botão seta voltar";
        public static final String TOOLTIP = "Voltar";
    }
    
    public abstract class SIGNUP_FIELD {
        public static final int X = 100;
        public static final int Y = 85;
        public static final int W = 350;
        public static final int H = 130;
        public static final String IMAGE = "/resources/Botão de Cadastro - ativo";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class FORM_FIELD {
        public static final int Y = 225;
        public static final int H = 450;
        public static final String IMG_PATH = "/resources/Background - white";
        
        public abstract class ADDRESS {
            public static final int X = 110;
            public static final int W = 1100;
            
            public abstract class COUNTRY {
                public static final int X = 200;
                public static final int Y = 150;
                public static final int W = 190;
                public static final int H = 40;
                public static final int BR = 255;
                public static final int BG = 255;
                public static final int BB = 255;
                public static final int FR = 48;
                public static final int FG = 48;
                public static final int FB = 54;
                public static final String FONT_FAMILY = "Segoe UI";
                public static final int FONT_WEIGHT = Font.PLAIN;
                public static final int FONT_SIZE = 20; 
            }
        }
        
        public abstract class PERSONAL {
            public static final int X = 250;
            public static final int W = 700;
        }
        
        public abstract class TITLE {
            public static final int X = 15;
            public static final int Y = 15;
            public static final int W = 150;
            public static final int H = 50;
            public static final int R = 43;
            public static final int G = 158;
            public static final int B = 179;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 50;
            public static final String TEXT = "Dados";
        }
        
        public abstract class SUBTITLE {
            public static final int X = 50;
            public static final int Y = 75;
            public static final int W = 130;
            public static final int H = 40;
            public static final int R = 48;
            public static final int G = 188;
            public static final int B = 237;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 30;
            public static final String TEXT_ADDRESS = "Endereço";
            public static final String TEXT_PERSONAL = "Pessoais";
        }
    }
}
