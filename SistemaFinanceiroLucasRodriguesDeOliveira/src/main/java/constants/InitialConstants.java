package constants;

import constants.MainConstants.MAIN;
/**
 *
 * @author Lucas Oliveira
 */
public abstract class InitialConstants {
    public abstract class CLOSE_BUTTON {
        public static final int X = 1050;
        public static final int Y = 150;
        public static final int W = 25;
        public static final int H = 25;
        public static final String TOOLTIP = "Fechar o Sistema";
        public static final String IMAGE_PATH = "/Botão Fechar";
        public static final String IMAGE_EXTENSION = ".png";
        public static final String IMAGE_HOVER_PATH = " - hover.png";
    }
    
    public abstract class INITIAL {
        public static final String IMAGE = "/Primeiro Acesso";
        public static final String NAME = "INTIAL";
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = MAIN.HEIGHT;
        public static final int W = MAIN.WIDTH;
    }
    
    public abstract class LETSGO_BUTTON {
        public static final int X = 520;
        public static final int Y = 480;
        public static final int W = 330;
        public static final int H = 100;
        public static final String TOOLTIP = "";
        public static final String IMAGE_PATH = "/Botão Próximo";
        public static final String IMAGE_EXTENSION = ".png";
        public static final String IMAGE_HOVER_PATH = " - hover.png";
    }
}
