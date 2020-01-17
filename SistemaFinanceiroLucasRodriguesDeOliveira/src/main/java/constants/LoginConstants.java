package constants;

import constants.MainConstants.MAIN;
/**
 *
 * @author Lucas Oliveira
 */
public abstract class LoginConstants {
    public abstract class LOGIN {
        public static final String NAME = "LOGIN";
        public static final int X = 0;
        public static final int Y = 0;
        public static final int H = MAIN.HEIGHT;
        public static final int W = MAIN.WIDTH;
    }
    
    public abstract class BACKGROUND {
        public static final int X = 0;
        public static final int Y = 0;
        public static final int W = MAIN.WIDTH;
        public static final int H = MAIN.HEIGHT;
        public static final String IMAGE_PATH = "/Background-blue";
        public static final String IMAGE_EXTENSION = ".png";
    }
    
    public abstract class APPNAME {
        public static final int X = 300;
        public static final int Y = 50;
        public static final int W = 500;
        public static final int H = 190;
        public static final String IMAGE_PATH = "/Appname";
        public static final String IMAGE_EXTENSION = ".png";
    }
}
