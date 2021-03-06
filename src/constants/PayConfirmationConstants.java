package constants;

import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class PayConfirmationConstants {
    public abstract class CONFIRMATION {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MainConstants.MAIN.WIDTH;
        public static final int H = MainConstants.MAIN.HEIGHT;
        public static final String NAME = "PAY_CONFIRM";
        
        public abstract class BACKGROUND {
            public static final int X = 0;
            public static final int Y = 0;
            public static final int W = MainConstants.MAIN.WIDTH;
            public static final int H = MainConstants.MAIN.HEIGHT;
            public static final String IMAGE_PATH = "/resources/Background - white";
        }
        
        public abstract class APPNAME {
            public static final int X = 0;
            public static final int Y = 5;
            public static final int W = 200;
            public static final int H = 75;
            public static final String IMAGE_PATH = "/resources/Appname - menu";
        }
        
        public abstract class PAY_LABEL {
            public static final int X = 50;
            public static final int Y = 100;
            public static final int W = 500;
            public static final int H = 80;
            public static final int R = 43;
            public static final int G = 158;
            public static final int B = 179;
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 50;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "Pagar";
        }
        
        public abstract class SUBTITLE {
            public static final int X = 575;
            public static final int Y = 200;
            public static final int W = 100;
            public static final int H = 80;
            public static final int R = 43;
            public static final int G = 158;
            public static final int B = 179;
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 30;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "Valor";
        }
        
        public abstract class CANCEL {
            public static final int X = 1000;
            public static final int Y = 600;
            public static final int W = 280;
            public static final int H = 100;
            public static final String IMAGE_PATH = "/resources/Botão Cancelar";
            public static final String TOOLTIP = "Cancelar pagamento";
        }
        
        public abstract class PAY_BTN {
            public static final int X = 650;
            public static final int Y = 600;
            public static final int W = 340;
            public static final int H = 100;
            public static final String IMAGE_PATH = "/resources/Botão Pagar Título";
            public static final String TOOLTIP = "Pagar título";
        }
        
        public abstract class VALUE {
            public static final int X = 500;
            public static final int Y = 250;
            public static final int W = 250;
            public static final int H = 100;
            public static final int R = 68;
            public static final int G = 175;
            public static final int B = 105;
            public static final int FONT_WEIGHT = Font.PLAIN;
            public static final int FONT_SIZE = 60;
            public static final String FONT_FAMILY = "Segoe UI";
        }
        
        public abstract class PAY_METHODS {
            public static final int X = 900;
            public static final int Y = 150;
            public static final int W = 325;
            public static final int H = 80;
            public static final int R = 48;
            public static final int G = 188;
            public static final int B = 237;
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 30;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "Formas de pagamento";
        }
    }
}
