package constants;

import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class BillPaymentConstants {
    public abstract class BILL {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MainConstants.MAIN.WIDTH;
        public static final int H = MainConstants.MAIN.HEIGHT;
        public static final String NAME = "BILL_PAYMENT";
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
            public static final String TEXT = "Pagamento de Conta";
        }
        
        public abstract class ADD_BILL {
            public static final int X = 1000;
            public static final int Y = 500;
            public static final int W = 280;
            public static final int H = 100;
            public static final String IMAGE_PATH = "/resources/Botão Nova Conta";
            public static final String TOOLTIP = "Cadastrar uma nova conta";
        }
        
        public abstract class CANCEL {
            public static final int X = 1000;
            public static final int Y = 600;
            public static final int W = 280;
            public static final int H = 100;
            public static final String IMAGE_PATH = "/resources/Botão Cancelar";
            public static final String TOOLTIP = "Cancelar pagamento";
        }
    }
}
