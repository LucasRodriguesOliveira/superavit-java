package view;

import components.AppName;
import constants.AboutConstants.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lucas Oliveira
 */
public class AboutView extends JDialog {
    public AboutView(JFrame topParent, boolean modal) {
        super(topParent, modal);
        initProps();
        initComponents();
    }
    
    private ImageIcon getImage(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
    
    private void initProps() {
        setSize(ABOUT.W, ABOUT.H);
        setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private class CloseButtonActions extends MouseAdapter {
        private final ImageIcon defaultImage;
        private final ImageIcon hoverImage;
        private final JLabel btn;
        private final JDialog parent;
        
        public CloseButtonActions(ImageIcon d, ImageIcon h, JLabel b, JDialog p) {
            this.defaultImage = d;
            this.hoverImage = h;
            this.btn = b;
            this.parent = p;
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            btn.setIcon(hoverImage);
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            btn.setIcon(defaultImage);
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            parent.dispose();
        }
    }
    
    private JLabel getCloseButton() {
        ImageIcon defaultImage = getImage(CLOSE_BTN.IMG_PATH + ".png");
        ImageIcon hoverImage = getImage(CLOSE_BTN.IMG_PATH  + " - hover.png");
        
        JLabel closebtn = new JLabel(defaultImage);
        closebtn.setBounds(CLOSE_BTN.X, CLOSE_BTN.Y, CLOSE_BTN.W, CLOSE_BTN.H);
        closebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closebtn.setToolTipText(CLOSE_BTN.TOOLTIP);
        closebtn.addMouseListener(new CloseButtonActions(defaultImage, hoverImage,
                closebtn, this));
        
        return closebtn;
    }
    
    private JLabel getBackgroundAbout() {
        JLabel background = new JLabel(getImage(BACKGROUND.IMG_PATH + ".png"));
        background.setBounds(BACKGROUND.X, BACKGROUND.Y, BACKGROUND.W, BACKGROUND.H);
        
        return background;
    }
    
    private AppName getAppName() {
        return new AppName(APPNAME.X, APPNAME.Y, APPNAME.W, APPNAME.H, APPNAME.IMG_PATH);
    }
    
    private JLabel getVersion() {
        JLabel version = new JLabel(VERSION.TEXT);
        version.setBounds(VERSION.X, VERSION.Y, VERSION.W, VERSION.H);
        version.setForeground(new Color(VERSION.R, VERSION.G, VERSION.B));
        version.setFont(new Font(VERSION.FONT_FAMILY, VERSION.FONT_WEIGHT, VERSION.FONT_SIZE));
        
        return version;
    }
    
    private JLabel getDevelopedBy() {
        JLabel developedBy = new JLabel(DEVELOPED_BY.TEXT);
        developedBy.setBounds(DEVELOPED_BY.X, DEVELOPED_BY.Y, DEVELOPED_BY.W, DEVELOPED_BY.H);
        developedBy.setForeground(new Color(DEVELOPED_BY.R, DEVELOPED_BY.G, DEVELOPED_BY.B));
        developedBy.setFont(new Font(DEVELOPED_BY.FONT_FAMILY, DEVELOPED_BY.FONT_WEIGHT,
                 DEVELOPED_BY.FONT_SIZE));
        
        return developedBy;
    }
    
    private JLabel getAuthor() {
        JLabel author = new JLabel(DEVELOPER.TEXT);
        author.setBounds(DEVELOPER.X, DEVELOPER.Y, DEVELOPER.W, DEVELOPER.H);
        author.setForeground(new Color(DEVELOPER.R, DEVELOPER.G, DEVELOPER.B));
        author.setFont(new Font(DEVELOPER.FONT_FAMILY, DEVELOPER.FONT_WEIGHT,
                 DEVELOPER.FONT_SIZE));
        
        return author;
    }
    
    private JLabel getTextAbout() {
        JLabel aboutText = new JLabel(getImage(ABOUT_TEXT.IMG_PATH + ".png"));
        aboutText.setBounds(ABOUT_TEXT.X, ABOUT_TEXT.Y, ABOUT_TEXT.W, ABOUT_TEXT.H);
        
        return aboutText;
    }
    
    private void initComponents() {
        add(getCloseButton());
        add(getAppName());
        add(getVersion());
        add(getDevelopedBy());
        add(getAuthor());
        add(getTextAbout());
        add(getBackgroundAbout());
    }
}
