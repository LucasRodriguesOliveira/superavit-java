package constants;

import constants.MainConstants.MAIN;
import java.awt.Font;
/**
 *
 * @author Lucas Oliveira
 */
public abstract class HomeConstants {
    public abstract class HOME {
        public static final String NAME = "HOME";
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = MAIN.HEIGHT;
        public static final int W = MAIN.WIDTH;
        public static final String PRELOAD_NAME = "Boas vindas";
    }
    
    public abstract class BACKGROUND {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = MAIN.HEIGHT;
        public static final int W = MAIN.WIDTH;
        public static final String IMAGE_PATH = "/resources/Background - white";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class MENU {
        public static final int X = 0; // Não entendo o motivo, mas faz-se necessário
        public static final int Y = 0;
        public static final int H = 200;
        public static final int W = 1400;
        public static final String IMAGE_PATH = "/resources/Barra Menu";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class APPNAME {
        public static final int X = 0;
        public static final int Y = 5;
        public static final int W = 200;
        public static final int H = 75;
        public static final String IMAGE_PATH = "/resources/Appname - menu";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class NEW_BILL_BTN {
        public static final int X = 950;
        public static final int Y = 300;
        public static final int W = 346;
        public static final int H = 120;
        public static final String IMAGE_PATH = "/resources/Novo titulo botão";
        public static final String TOOLTIP = "Cadastrar novo título";
    }
    
    public abstract class CONTAINER {
        public static final int X = 10;
        public static final int Y = 150;
        public static final int W = 400;
        public static final int H = 500;
        public static final String IMAGE_PATH = "/resources/Background - white";
    }
    
    public abstract class NOTIFICATION_MANAGER {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = 310;
        public static final int H = 450;
        public static final String IMAGE_PATH = "/resources/Background - notificações";
    }
    
    public abstract class BELL_ICON {
        public static final int X = 130;
        public static final int Y = 20;
        public static final int W = 60;
        public static final int H = 60;
        public static final String IMAGE_PATH = "/resources/bell-solid";
    }
    
    public abstract class NOTIFICATIONS_LABEL {
        public static final int X = 70;
        public static final int Y = 70;
        public static final int W = 170;
        public static final int H = 60;
        public static final String IMAGE_PATH = "/resources/Notificações";
    }
    
    public abstract class NO_NOTIFICATIONS_TEXT_1 {
        public static final int X = 17;
        public static final int Y = 150;
        public static final int W = 280;
        public static final int H = 60;
        public static final int R = 219;
        public static final int G = 213;
        public static final int B = 181;
        public static final int FONT_SIZE = 19;
        public static final int FONT_WEIGHT = Font.BOLD;
        public static final String FONT_FAMILY = "Segoe UI";
        public static final String IMAGE_PATH = "/resources/Notificações";
        public static final String TEXT = "No momento não há nenhuma";
    }
    
    public abstract class NO_NOTIFICATIONS_TEXT_2 {
        public static final int X = 105;
        public static final int Y = 180;
        public static final int W = 170;
        public static final int H = 60;
        public static final int R = 219;
        public static final int G = 213;
        public static final int B = 181;
        public static final int FONT_SIZE = 19;
        public static final int FONT_WEIGHT = Font.BOLD;
        public static final String FONT_FAMILY = "Segoe UI";
        public static final String IMAGE_PATH = "/resources/Notificações";
        public static final String TEXT = "notificação!";
    }
    
    public abstract class MARK_ALL_AS_READ_BTN {
        public static final int X = 200;
        public static final int Y = 10;
        public static final int W = 95;
        public static final int H = 50;
        public static final String TOOLTIP = "Remove todas as notificações da lista";
        public static final String IMAGE_PATH = "/resources/Botão marcar como lido";
    }
    
    public abstract class SEE_ALL_BTN {
        public static final int X = 15;
        public static final int Y = 10;
        public static final int W = 95;
        public static final int H = 50;
        public static final String TOOLTIP = "Apresenta todas as notificações";
        public static final String IMAGE_PATH = "/resources/Botão ver tudo";
    }
    
    public abstract class NOTIFICATION_BALLOON_TEXT {
        public static final int X = 170;
        public static final int Y = 30;
        public static final int W = 20;
        public static final int H = 20;
        public static final int R = 255;
        public static final int G = 250;
        public static final int B = 255;
        public static final int FONT_SIZE = 15;
        public static final int FONT_WEIGHT = Font.BOLD;
        public static final String FONT_FAMILY = "Segoe UI";
    }
    
    public abstract class NOTIFICATION_BALLOON_BACK {
        public static final int X = 150;
        public static final int Y = 20;
        public static final int W = 50;
        public static final int H = 50;
        public static final String IMAGE_PATH = "/resources/Background Quantidade Notificações";
    }
}
