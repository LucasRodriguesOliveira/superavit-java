package constants;

import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class PaymentCompletionConstants {
    public abstract class COMPLETION {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MainConstants.MAIN.WIDTH;
        public static final int H = MainConstants.MAIN.HEIGHT;
        public static final String NAME = "PAY_COMPLETION";
        
        public abstract class BACKGROUND {
            public static final int X = 0;
            public static final int Y = 0;
            public static final int W = MainConstants.MAIN.WIDTH;
            public static final int H = MainConstants.MAIN.HEIGHT;
            public static final String IMAGE_PATH = "/resources/Background pagamento";
        }
        
        public abstract class APPNAME {
            public static final int X = 550;
            public static final int Y = 500;
            public static final int W = 200;
            public static final int H = 75;
            public static final String IMAGE_PATH = "/resources/Appname - blue";
        }
        
        public abstract class PAY_LABEL {
            public static final int X = 600;
            public static final int Y = 20;
            public static final int W = 150;
            public static final int H = 80;
            public static final int R = 43;
            public static final int G = 158;
            public static final int B = 179;
            public static final int FONT_WEIGHT = Font.PLAIN;
            public static final int FONT_SIZE = 50;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "Pago!";
        }
        
        public abstract class SUBTITLE_1 {
            public static final int X = 540;
            public static final int Y = 365;
            public static final int W = 250;
            public static final int H = 60;
            public static final int R = 43;
            public static final int G = 158;
            public static final int B = 179;
            public static final int FONT_WEIGHT = Font.PLAIN;
            public static final int FONT_SIZE = 30;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "O pagamento foi";
        }
        
        public abstract class SUBTITLE_2 {
            public static final int X = 480;
            public static final int Y = 385;
            public static final int W = 350;
            public static final int H = 150;
            public static final int R = 43;
            public static final int G = 158;
            public static final int B = 179;
            public static final int FONT_WEIGHT = Font.PLAIN;
            public static final int FONT_SIZE = 30;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "registrado com sucesso!";
        }
        
        public abstract class CONFIRMATION_SIGN {
            public static final int X = 550;
            public static final int Y = 120;
            public static final int W = 250;
            public static final int H = 250;
            public static final String IMAGE_PATH = "/resources/Confirmation sign";
        }
        
        public abstract class PROCEED_BUTTON {
            public static final int X = 550;
            public static final int Y = 600;
            public static final int W = 200;
            public static final int H = 80;
            public static final String IMAGE_PATH = "/resources/proceed";
            public static final String TOOLTIP = "Finalizar!";
        }
    }
}
