package constants;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

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
                        public static final int W = 350;
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
                        
                        public abstract class LIST {
                            public static final int ALIGNMENT = JLabel.CENTER;
                            public static final int SELECTION_MODEL = ListSelectionModel.SINGLE_SELECTION;
                            public static final int CURSOR = Cursor.HAND_CURSOR;
                            public static final String FONT_FAMILY = "Segoe UI";
                            public static final int FONT_WEIGHT = Font.PLAIN;
                            public static final int FONT_SIZE = 18;
                            public static final boolean FOCUSABLE = false;
                            public static final int H = 50;
                            public static final boolean SHOW_VERTICAL_LINES = false;
                            public static final int LINEBORDER_R = 150;
                            public static final int LINEBORDER_G = 150;
                            public static final int LINEBORDER_B = 150;
                            public static final int LINEBORDER_SIZE = 1;
                            public static final String TOOLTIP = "Clique (Botão esquerdo) para detalhes. Clique (Botão direito) para mudar prioridade";
                            public static final String BORDER_LAYOUT_POSITION = "Center";
                            public static final int BACKGROUND_R = 255;
                            public static final int BACKGROUND_G = 250;
                            public static final int BACKGROUND_B = 255;
                            public static final int FOREGROUND_R = 50;
                            public static final int FOREGROUND_G = 50;
                            public static final int FOREGROUND_B = 50;
                            public static final int HOVER_BACKGROUND_R = 48;
                            public static final int HOVER_BACKGROUND_G = 188;
                            public static final int HOVER_BACKGROUND_B = 237;
                            public static final int HOVER_FOREGROUND_R = 255;
                            public static final int HOVER_FOREGROUND_G = 255;
                            public static final int HOVER_FOREGROUND_B = 255;
                            public static final int SELECTED_BACKGROUND_R = 43;
                            public static final int SELECTED_BACKGROUND_G = 158;
                            public static final int SELECTED_BACKGROUND_B = 179;
                            public static final int SELECTED_FOREGROUND_R = 255;
                            public static final int SELECTED_FOREGROUND_G = 255;
                            public static final int SELECTED_FOREGROUND_B = 255;
                            public static final String BG_NAME = "dbc"; // Default Background Color
                            public static final String FG_NAME = "dfc"; // Default Foreground Color
                            public static final String HOVER_BG_NAME = "hbc"; // Hover BackGround Color
                            public static final String HOVER_FG_NAME  = "hfc"; // Hover ForeGround Color
                            public static final String SELECTED_BG_NAME = "sbc"; // Selected Background Color
                            public static final String SELECTED_FG_NAME = "sfc"; // Selected Foreground Color
                            public static final String TABLE_COLUMN_NAME = "Nome";
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
                    
                    public abstract class CONTAINER {
                        public static final int X = 385 ;
                        public static final int Y = 160;
                        public static final int W = 385;
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
                                public static final int X = 70;
                                public static final int Y = 10;
                                public static final int W = 250;
                                public static final int H = 50;
                                public static final int R = 112;
                                public static final int G = 112;
                                public static final int B = 112;
                                public static final String FONT_FAMILY = "Segoe UI";
                                public static final int FONT_WEIGHT = Font.PLAIN;
                                public static final int FONT_SIZE = 18;
                                public static final String TEXT = "Selecione um Caixa ao lado";
                            }
                        }
                        
                        public abstract class INFO {
                            public static final int X = 0;
                            public static final int Y = 0;
                            public static final int W = CONTAINER.W;
                            public static final int H = CONTAINER.H;
                            
                            public abstract class THUMBNAIL_CONTAINER {
                                public static final int X = 0;
                                public static final int Y = 0;
                                public static final int W = 150;
                                public static final int H = 150;
                                public static final String TOOLTIP = "Clique para editar";
                                public static final int CURSOR = Cursor.HAND_CURSOR;
                                
                                public abstract class THUMBNAIL {
                                    public static final int TX = 25;
                                    public static final int TY = 25;
                                    public static final int TW = 100;
                                    public static final int TH = 100;
                                    public static final int IX = 25;
                                    public static final int IY = 25;
                                    public static final int IW = 50;
                                    public static final int IH = 50;
                                    public static final String IMG_PATH = "/resources/Background - thumbnail";
                                }
                            }
                            
                            public abstract class FLOW_NAME {
                                public static final int X = 150;
                                public static final int Y = 50;
                                public static final int W = 200;
                                public static final int H = 50;
                                public static final int FR = 48;
                                public static final int FG = 188;
                                public static final int FB = 237;
                                public static final int BR = 255;
                                public static final int BG = 255;
                                public static final int BB = 255;
                                public static final int FONT_SIZE = 20;
                                public static final int FONT_WEIGHT = Font.BOLD;
                                public static final String FONT_FAMILY = "Segoe UI";
                                public static final boolean IS_EDITABLE = false;
                                public static final int LENGTH = 15;
                                public static final int CURSOR = Cursor.HAND_CURSOR;
                                public static final String TOOLTIP = "Clique para editar";
                            }
                        }
                    }
                }
            }
        }
    }
}
