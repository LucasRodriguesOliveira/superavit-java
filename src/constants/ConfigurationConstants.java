package constants;

import java.awt.Font;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class ConfigurationConstants {
    public abstract class CONFIGURATION {
        public static final String NAME = "CONFIGURATION";
        
        public abstract class BACKGROUND {
            public static final int X = 0;
            public static final int Y = 0;
            public static final int W = MainConstants.MAIN.WIDTH;
            public static final int H = MainConstants.MAIN.HEIGHT;
            public static final String IMAGE_PATH = "/resources/Background-blue";
        }
        
        public abstract class APPNAME {
            public static final int X = 0;
            public static final int Y = 5;
            public static final int W = 200;
            public static final int H = 75;
            public static final String IMAGE_PATH = "/resources/Appname - menu";
        }
        
        public abstract class SIDEMENU {
            public static final int X = 0;
            public static final int Y = 100;
            public static final int W = 450;
            public static final int H = 600;
            
            public abstract class BACKGROUND {
                public static final int X = 0;
                public static final int Y = 0;
                public static final int W = SIDEMENU.W;
                public static final int H = SIDEMENU.H;
                public static final String IMG_PATH = "/resources/Background - white";
            }
            
            public abstract class TITLE {
                public static final int X = 50;
                public static final int Y = 10;
                public static final int W = 350;
                public static final int H = 70;
                public static final int R = 43;
                public static final int G = 158;
                public static final int B = 179;
                public static final String FONT_FAMILY = "Segoe UI";
                public static final int FONT_WEIGHT = Font.BOLD;
                public static final int FONT_SIZE = 50;
                public static final String TEXT = "Configurações";
            }
            
            public abstract class DETAIL_LINE {
                public static final int X = 10;
                public static final int Y = 90;
                public static final int W = 420;
                public static final int H = 40;
                public static final String IMG_PATH = "/resources/Detalhe";
            }
            
            public abstract class MENU_ITEM_FLOW {
                public static final int X = 30;
                public static final int Y = 200;
                public static final int W = 200;
                public static final int H = 40;
                public static final String IMG_PATH = "/resources/Item submenu - caixas";
            }
            
            public abstract class ABOUT {
                public static final int X = 350;
                public static final int Y = 550;
                public static final int W = 100;
                public static final int H = 60;
                public static final int R = 48;
                public static final int G = 188;
                public static final int B = 237;
                public static final String FONT_FAMILY = "Segoe UI";
                public static final int FONT_WEIGHT = Font.BOLD;
                public static final int FONT_SIZE = 30;
                public static final String TEXT = "Sobre";
            }
        }
        
        public abstract class CONFIG_PANEL {
            public static final int X = 480;
            public static final int Y = 125;
            public static final int W = 790;
            public static final int H = 570;
            
            public abstract class BACKGROUND {
                public static final String IMG_PATH = "/resources/Background - white";
            }
            
            public abstract class FLOW {
                public static final int X = 0;
                public static final int Y = 0;
                public static final int W = CONFIG_PANEL.W;
                public static final int H = CONFIG_PANEL.H;
                public static final String NAME = "FLOW";
                
                public abstract class TITLE {
                    public static final int X = 5;
                    public static final int Y = 5;
                    public static final int W = 260;
                    public static final int H = 50;
                    public static final int R = 48;
                    public static final int G = 188;
                    public static final int B = 237;
                    public static final String FONT_FAMILY = "Segoe UI";
                    public static final int FONT_WEIGHT = Font.BOLD;
                    public static final int FONT_SIZE = 30;
                    public static final String TEXT = "Configurar caixas";
                }
                
                public abstract class FLOW_LIST {
                    public abstract class TITLE {
                        public static final int X = 45;
                        public static final int Y = 95;
                        public static final int W = 210;
                        public static final int H = 50;
                        public static final int R = 43;
                        public static final int G = 158;
                        public static final int B = 179;
                        public static final String FONT_FAMILY = "Segoe UI";
                        public static final int FONT_WEIGHT = Font.BOLD;
                        public static final int FONT_SIZE = 25;
                        public static final String TEXT = "Todos os Caixas";
                    }
                    
                    public abstract class CONTAINER {
                        public static final int X = 20;
                        public static final int Y = 160;
                        public static final int W = 280;
                        public static final int H = 400;
                        
                        public abstract class BACKGROUND {
                            public static final int X = 0;
                            public static final int Y = 0;
                            public static final int W = CONTAINER.W;
                            public static final int H = CONTAINER.H;
                            public static final String IMG_PATH = "/resources/Background - white";
                        }
                        
                        public abstract class NO_ITEM {
                            public static final int X = 0;
                            public static final int Y = 0;
                            public static final int W = CONTAINER.W;
                            public static final int H = CONTAINER.H;
                            
                            public abstract class TEXT {
                                public static final int X = 40;
                                public static final int Y = 10;
                                public static final int W = 200;
                                public static final int H = 50;
                                public static final int R = 112;
                                public static final int G = 112;
                                public static final int B = 112;
                                public static final String FONT_FAMILY = "Segoe UI";
                                public static final int FONT_WEIGHT = Font.PLAIN;
                                public static final int FONT_SIZE = 18;
                                public static final String TEXT = "Nenhum caixa registrado";
                            }
                        }
                    }
                }
                
                public abstract class DETAILS {
                    public abstract class TITLE {
                        public static final int X = 500;
                        public static final int Y = 95;
                        public static final int W = 210;
                        public static final int H = 50;
                        public static final int R = 43;
                        public static final int G = 158;
                        public static final int B = 179;
                        public static final String FONT_FAMILY = "Segoe UI";
                        public static final int FONT_WEIGHT = Font.BOLD;
                        public static final int FONT_SIZE = 25;
                        public static final String TEXT = "Detalhes";
                    }
                }
            }
        }
    }
}
