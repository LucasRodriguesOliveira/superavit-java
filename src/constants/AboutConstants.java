package constants;

import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class AboutConstants {
    public abstract class ABOUT { // Por algum motivo, o background tem 9px de erro na imagem. de todos os lados, por isso 18px
        public static final int W = 400;
        public static final int H = 500;
        public static final String TITLE = "Sobre";
    }
    
    public abstract class BACKGROUND {
        public static final int X = -9;
        public static final int Y = -9;
        public static final int W = 418;
        public static final int H = 518;
        public static final String IMG_PATH = "/resources/Background about - blue";
    }
    
    public abstract class CLOSE_BTN {
        public static final int X = 368;
        public static final int Y = 10;
        public static final int W = 25;
        public static final int H = 25;
        public static final String TOOLTIP = "Fechar";
        public static final String IMG_PATH = "/resources/Botão Fechar";
    }
    
    public abstract class APPNAME {
        public static final int X = 100;
        public static final int Y = 10;
        public static final int W = 200;
        public static final int H = 80;
        public static final String IMG_PATH = "/resources/Appname - menu";
    }
    
    public abstract class VERSION {
        public static final int X = 295;
        public static final int Y = 60;
        public static final int W = 50;
        public static final int H = 20;
        public static final int R = 255;
        public static final int G = 250;
        public static final int B = 255;
        public static final String FONT_FAMILY = "Segoe UI";
        public static final int FONT_WEIGHT = Font.PLAIN;
        public static final int FONT_SIZE = 18;
        public static final String TEXT = "v0.1.0";
    }
    
    public abstract class DEVELOPED_BY {
        public static final int X = 115;
        public static final int Y = 150;
        public static final int W = 200;
        public static final int H = 60;
        public static final int R = 255;
        public static final int G = 250;
        public static final int B = 255;
        public static final String FONT_FAMILY = "Segoe UI";
        public static final int FONT_WEIGHT = Font.PLAIN;
        public static final int FONT_SIZE = 24;
        public static final String TEXT = "Desenvolvido por";
    }
    
    public abstract class DEVELOPER {
        public static final int X = 45;
        public static final int Y = 200;
        public static final int W = 350;
        public static final int H = 60;
        public static final int R = 255;
        public static final int G = 250;
        public static final int B = 255;
        public static final String FONT_FAMILY = "Segoe UI";
        public static final int FONT_WEIGHT = Font.BOLD;
        public static final int FONT_SIZE = 25;
        public static final String TEXT = "Lucas Rodrigues de Oliveira";
    }
    
    public abstract class ABOUT_TEXT {
        public static final int X = 0;
        public static final int Y = 300;
        public static final int W = ABOUT.W;
        public static final int H = 200;
        public static final String IMG_PATH = "/resources/Texto sobre";
    }
}
