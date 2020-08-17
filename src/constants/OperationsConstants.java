package constants;

import constants.MainConstants.MAIN;
import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class OperationsConstants {
    public abstract class OPERATIONS {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MAIN.WIDTH;
        public static final int H = MAIN.HEIGHT;
        public static final String NAME = "OPERATIONS";
        public abstract class OPR_LABEL {
            public static final int X = 200;
            public static final int Y = 125;
            public static final int W = 300;
            public static final int H = 80;
            public static final int R = 255;
            public static final int G = 250;
            public static final int B = 255;
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 50;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "Operações";
        }
        
        public abstract class SUMMARIES_LABEL {
            public static final int X = 950;
            public static final int Y = 125;
            public static final int W = 300;
            public static final int H = 80;
            public static final int R = 255;
            public static final int G = 250;
            public static final int B = 255;
            public static final int FONT_WEIGHT = Font.BOLD;
            public static final int FONT_SIZE = 50;
            public static final String FONT_FAMILY = "Segoe UI";
            public static final String TEXT = "Resumos";
        }
    }
    
    public abstract class BACKGROUND {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MAIN.WIDTH;
        public static final int H = MAIN.HEIGHT;
        public static final String IMAGE_PATH = "/resources/Background-blue";
    }
    
    public abstract class APPNAME {
        public static final int X = 0;
        public static final int Y = 5;
        public static final int W = 200;
        public static final int H = 75;
        public static final String IMAGE_PATH = "/resources/Appname - menu";
    }
    
    public abstract class PAY_BUTTON {
        public static final int X = 50;
        public static final int Y = 225;
        public static final int W = 325;
        public static final int H = 200;
        public static final String TOOLTIP = "Pagar uma conta";
        public static final String IMAGE_PATH = "/resources/Botão pagar";
    }
    
    public abstract class GENEREAL_REPORT_BTN {
        public static final int X = 900;
        public static final int Y = 225;
        public static final int W = 325;
        public static final int H = 130;
        public static final String TOOLTIP = "Relatório geral das ações";
        public static final String IMAGE_PATH = "/resources/Botão geral";
    }
    
    public abstract class PARCEL_REPORT_BTN {
        public static final int X = 900;
        public static final int Y = 375;
        public static final int W = 325;
        public static final int H = 130;
        public static final String TOOLTIP = "Relatório das parcelas das contas";
        public static final String IMAGE_PATH = "/resources/Botão parcelas";
    }
}
