package constants;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class MenuConstants {    
    public abstract class MENU {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = 200;
        public static final int W = 1500;
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class BACKGROUND {
        public static final int X = -10; // Não entendo o motivo, mas faz-se necessário
        public static final int Y = -48;
        public static final int H = 200;
        public static final int W = 1500;
        public static final String IMAGE_PATH = "/resources/Barra Menu";
    }
    
    public abstract class MENU_ITEMS {
        public static final int X = 800;
        public static final int Y = 0;
        public static final int H = 95;
        public static final int W = 500;
        public static final String IMAGE_PATH = "/resources/Barra Menu";
        public abstract class BACK {
            public static final int X = -9;
            public static final int Y = 0;
            public static final int W = 509;
            public static final int H = 105;
        }
    }
    
    public abstract class MENU_ITEM {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = 200;
        public static final int W = 200;
        public static final String IMAGE_PATH = "/resources/Background - Menu Item";
    }
    
    public abstract class HOME_BUTTON {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = 100;
        public static final int W = 100;
        public static final String TOOLTIP = "Home";
        public static final String IMAGE_PATH = "/resources/Botão Home";
    }
    
    public abstract class OPR_BUTTON {
        public static final int X = 90;
        public static final int Y = 0;
        public static final int H = 100;
        public static final int W = 100;
        public static final String TOOLTIP = "Operações";
        public static final String IMAGE_PATH = "/resources/Botão Operações";
    }
    
    public abstract class PROFILE_BUTTON {
        public static final int X = 180;
        public static final int Y = 0;
        public static final int H = 100;
        public static final int W = 100;
        public static final String TOOLTIP = "Perfil";
        public static final String IMAGE_PATH = "/resources/Botão Usuário";
    }
    
    public abstract class CONFIG_BUTTON {
        public static final int X = 270;
        public static final int Y = 0;
        public static final int H = 100;
        public static final int W = 100;
        public static final String TOOLTIP = "Configurações";
        public static final String IMAGE_PATH = "/resources/Botão Configurações";
    }
    
    public abstract class EXIT_BUTTON {
        public static final int X = 360;
        public static final int Y = 0;
        public static final int H = 100;
        public static final int W = 100;
        public static final String TOOLTIP = "Sair";
        public static final String IMAGE_PATH = "/resources/Botão Sair";
    }
}
