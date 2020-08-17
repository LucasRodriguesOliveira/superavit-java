package constants;

import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class PaymentOptionsConstants {
    public abstract class PAYMENT {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MainConstants.MAIN.WIDTH;
        public static final int H = MainConstants.MAIN.HEIGHT;
        public static final String NAME = "PAYMENT_OPTIONS";
        public abstract class PAY_LABEL {
            public static final int X = 125;
            public static final int Y = 100;
            public static final int W = 200;
            public static final int H = 80;
            public static final int R = 255;
            public static final int G = 250;
            public static final int B = 255;
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 40;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "Pagar";
        }
    }
    
    public abstract class BACKGROUND {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MainConstants.MAIN.WIDTH;
        public static final int H = MainConstants.MAIN.HEIGHT;
        public static final String IMAGE_PATH = "/resources/Background-blue";
    }
    
    public abstract class ARROW_BACK {
        public static final int X = 50;
        public static final int Y = 125;
        public static final int W = 50;
        public static final int H = 50;
        public static final String IMAGE_PATH = "/resources/Botão seta voltar";
        public static final String TOOLTIP = "Voltar";
    }
    
    public abstract class BILL_BUTTON {
        public static final int X = 50;
        public static final int Y = 200;
        public static final int W = 333;
        public static final int H = 195;
        public static final String IMAGE_PATH = "/resources/Botão Pagar Conta";
        public static final String TOOLTIP = "Pagar Conta";
    }
}
