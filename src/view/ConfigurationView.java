package view;

import components.AppName;
import components.Background;
import components.Menu;
import constants.ConfigurationConstants.CONFIGURATION;
import constants.ConfigurationConstants.CONFIGURATION.*;
import constants.ConfigurationConstants.CONFIGURATION.CONFIG_PANEL.FLOW.FLOW_LIST;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas Oliveira
 */
public class ConfigurationView extends BaseView {
    private JPanel pnConfigs;
    private CardLayout layout;
    
    private JPanel flowContainer;
    
    private JPanel flowListContainer;
    
    public ConfigurationView(Container parent) {
        super(CONFIGURATION.NAME, parent);
        
        generateComponents();
        initComponents();
    }
    
    private class Model extends AbstractTableModel {
        protected String[] columns;
        protected Object[][] rows;

        public Model (String[] columns, Object[][] rows) {
          this.columns = columns;
          this.rows = rows;
        }

        @Override
        public int getRowCount() {
          return rows.length;
        }

        @Override
        public int getColumnCount() {
          return columns.length;
        }

        @Override
        public String getColumnName(int column) {
          return columns[column];
        }

        @Override
        public Object getValueAt(int row, int column) {
          return rows[row][column];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }

        @Override
        public Class getColumnClass(int column) {
          return getValueAt(0,column).getClass();
        }
    }
    
    private JLabel generateNoItemText() {
        JLabel text = new JLabel(FLOW_LIST.CONTAINER.NO_ITEM.TEXT.TEXT);
        text.setBounds(FLOW_LIST.CONTAINER.NO_ITEM.TEXT.X, FLOW_LIST.CONTAINER.NO_ITEM.TEXT.Y,
                FLOW_LIST.CONTAINER.NO_ITEM.TEXT.W, FLOW_LIST.CONTAINER.NO_ITEM.TEXT.H);
        text.setForeground(new Color(FLOW_LIST.CONTAINER.NO_ITEM.TEXT.R,
                FLOW_LIST.CONTAINER.NO_ITEM.TEXT.G, FLOW_LIST.CONTAINER.NO_ITEM.TEXT.B));
        text.setFont(new Font(FLOW_LIST.CONTAINER.NO_ITEM.TEXT.FONT_FAMILY,
                FLOW_LIST.CONTAINER.NO_ITEM.TEXT.FONT_WEIGHT, FLOW_LIST.CONTAINER.NO_ITEM.TEXT.FONT_SIZE));
        
        return text;
    }
    
    private JPanel generateNoItemPanel() {
        JPanel pnNoItem = new JPanel();
        pnNoItem.setLayout(null);
        pnNoItem.setBounds(FLOW_LIST.CONTAINER.NO_ITEM.X, FLOW_LIST.CONTAINER.NO_ITEM.Y,
                FLOW_LIST.CONTAINER.NO_ITEM.W, FLOW_LIST.CONTAINER.NO_ITEM.H);
        pnNoItem.add(generateNoItemText());
        pnNoItem.add(generateFlowBackground(pnNoItem.getBounds(), FLOW_LIST.CONTAINER.BACKGROUND.IMG_PATH));
        
        return pnNoItem;
    }
    
    private JScrollPane generateFlowListPanel() {
        JScrollPane pnFlowList = new JScrollPane();
        pnFlowList.setLayout(null);
        pnFlowList.setBounds(0, 0,
                FLOW_LIST.CONTAINER.W, FLOW_LIST.CONTAINER.H);
        pnFlowList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pnFlowList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        String[] colunas = {"Codigo", "Nome"};
        Object[][] dados = {{1, "Teste"}, {2, "Ok"}, {3, "Teste de tabela"}};
        JTable tbDados = new JTable(dados, colunas);
        tbDados.setBounds(pnFlowList.getBounds());
        tbDados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbDados.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tbDados.setFocusable(false);
        tbDados.setToolTipText("Clique (Botão esquerdo) para detalhes. Clique (Botão direito) para mudar prioridade");
        
        pnFlowList.add(tbDados);
        
        return pnFlowList;
    }
    
    private void generateFlowListContainer() {
        CardLayout c = new CardLayout();
        flowListContainer = new JPanel(c);
        flowListContainer.setBounds(FLOW_LIST.CONTAINER.X, FLOW_LIST.CONTAINER.Y,
                FLOW_LIST.CONTAINER.W, FLOW_LIST.CONTAINER.H);
        
       // flowListContainer.add(generateNoItemPanel(););
        flowListContainer.add(generateFlowListPanel());
    }
    
    private JLabel generateFlowBackground(Rectangle r, String imgPath) {
        JLabel background = new JLabel(getImage(imgPath + ".png"));
        background.setBounds(r);
        
        return background;
    }
    
    private JLabel generateFlowTitle() {
        JLabel title = new JLabel(CONFIG_PANEL.FLOW.TITLE.TEXT);
        title.setBounds(CONFIG_PANEL.FLOW.TITLE.X, CONFIG_PANEL.FLOW.TITLE.Y,
                CONFIG_PANEL.FLOW.TITLE.W, CONFIG_PANEL.FLOW.TITLE.H);
        title.setForeground(new Color(CONFIG_PANEL.FLOW.TITLE.R,
                CONFIG_PANEL.FLOW.TITLE.G, CONFIG_PANEL.FLOW.TITLE.B));
        title.setFont(new Font(CONFIG_PANEL.FLOW.TITLE.FONT_FAMILY,
                CONFIG_PANEL.FLOW.TITLE.FONT_WEIGHT, CONFIG_PANEL.FLOW.TITLE.FONT_SIZE));
        
        return title;
    }
    
    private JLabel generateFlowListTitle() {
        JLabel title = new JLabel(CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.TEXT);
        title.setBounds(CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.X, CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.Y,
                CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.W, CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.H);
        title.setForeground(new Color(CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.R,
                CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.G, CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.B));
        title.setFont(new Font(CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.FONT_FAMILY,
                CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.FONT_WEIGHT, CONFIG_PANEL.FLOW.FLOW_LIST.TITLE.FONT_SIZE));
        
        return title;
    }
    
    private JLabel generateFlowDetailsTitle() {
        JLabel title = new JLabel(CONFIG_PANEL.FLOW.DETAILS.TITLE.TEXT);
        title.setBounds(CONFIG_PANEL.FLOW.DETAILS.TITLE.X, CONFIG_PANEL.FLOW.DETAILS.TITLE.Y,
                CONFIG_PANEL.FLOW.DETAILS.TITLE.W, CONFIG_PANEL.FLOW.DETAILS.TITLE.H);
        title.setForeground(new Color(CONFIG_PANEL.FLOW.DETAILS.TITLE.R,
                CONFIG_PANEL.FLOW.DETAILS.TITLE.G, CONFIG_PANEL.FLOW.DETAILS.TITLE.B));
        title.setFont(new Font(CONFIG_PANEL.FLOW.DETAILS.TITLE.FONT_FAMILY,
                CONFIG_PANEL.FLOW.DETAILS.TITLE.FONT_WEIGHT, CONFIG_PANEL.FLOW.DETAILS.TITLE.FONT_SIZE));
        
        return title;
    }
    
    private void generateFlowComponents() {
        flowContainer = new JPanel();
        flowContainer.setLayout(null);
        flowContainer.setBounds(CONFIG_PANEL.FLOW.X, CONFIG_PANEL.FLOW.Y,
                CONFIG_PANEL.FLOW.W, CONFIG_PANEL.FLOW.H);
        
        JLabel background = generateFlowBackground(flowContainer.getBounds(), CONFIG_PANEL.BACKGROUND.IMG_PATH);
        JLabel title = generateFlowTitle();
        JLabel flowListTitle = generateFlowListTitle();
        JLabel flowDetailsTitle = generateFlowDetailsTitle();
        
        generateFlowListContainer();
        
        flowContainer.add(title);
        flowContainer.add(flowListTitle);
        flowContainer.add(flowDetailsTitle);
        flowContainer.add(flowListContainer);
        flowContainer.add(background);
    }
    
    private void generateComponents() {
        layout = new CardLayout();
        pnConfigs = new JPanel(layout);
        pnConfigs.setBounds(CONFIG_PANEL.X, CONFIG_PANEL.Y, CONFIG_PANEL.W,
                CONFIG_PANEL.H);
        
        generateFlowComponents();
        
        pnConfigs.add(flowContainer, CONFIG_PANEL.FLOW.NAME);
    }
    
    private ImageIcon getImage(String path) {
        return new ImageIcon(getClass().getResource(path));
    }
    
    private Background getBackgroundConfiguration() {
        return new Background(BACKGROUND.X, BACKGROUND.Y,
                BACKGROUND.W, BACKGROUND.H, BACKGROUND.IMAGE_PATH);
    }
    
    private Menu getMenu() {
        return new Menu(CONFIGURATION.NAME);
    }
    
    private AppName getAppName() {
        return new AppName(APPNAME.X, APPNAME.Y, APPNAME.W, APPNAME.H,
                APPNAME.IMAGE_PATH);
    }
    
    private class AboutButtonActions extends MouseAdapter {
        private final JLabel btn;
        
        public AboutButtonActions(JLabel btn) {
            this.btn = btn;
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            this.btn.setEnabled(true);
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            this.btn.setEnabled(false);
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            new AboutView(superavit.Init.frame, true).setVisible(true);
        }
    }
    
    private JPanel getSideMenu() {
        JPanel pnSideMenu = new JPanel();
        pnSideMenu.setBounds(SIDEMENU.X, SIDEMENU.Y, SIDEMENU.W, SIDEMENU.H);
        
        JLabel lbBackgroundWhite = new JLabel(getImage(SIDEMENU.BACKGROUND.IMG_PATH + ".png"));
        lbBackgroundWhite.setBounds(SIDEMENU.BACKGROUND.X, SIDEMENU.BACKGROUND.Y,
                SIDEMENU.BACKGROUND.W, SIDEMENU.BACKGROUND.H);
        
        JLabel lbTitle = new JLabel(SIDEMENU.TITLE.TEXT);
        lbTitle.setBounds(SIDEMENU.TITLE.X, SIDEMENU.TITLE.Y, SIDEMENU.TITLE.W,
                SIDEMENU.TITLE.H);
        lbTitle.setForeground(new Color(SIDEMENU.TITLE.R, SIDEMENU.TITLE.G, SIDEMENU.TITLE.B));
        lbTitle.setFont(new Font(SIDEMENU.TITLE.FONT_FAMILY, SIDEMENU.TITLE.FONT_WEIGHT,
                SIDEMENU.TITLE.FONT_SIZE));
        
        JLabel lbDetailLine = new JLabel(getImage(SIDEMENU.DETAIL_LINE.IMG_PATH + ".png"));
        lbDetailLine.setBounds(SIDEMENU.DETAIL_LINE.X, SIDEMENU.DETAIL_LINE.Y,
                SIDEMENU.DETAIL_LINE.W, SIDEMENU.DETAIL_LINE.H);
        
        JLabel lbMenuItemFlow = new JLabel(getImage(SIDEMENU.MENU_ITEM_FLOW.IMG_PATH + ".png"));
        lbMenuItemFlow.setBounds(SIDEMENU.MENU_ITEM_FLOW.X, SIDEMENU.MENU_ITEM_FLOW.Y,
                SIDEMENU.MENU_ITEM_FLOW.W, SIDEMENU.MENU_ITEM_FLOW.H);
        lbMenuItemFlow.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel lbAbout = new JLabel(SIDEMENU.ABOUT.TEXT);
        lbAbout.setBounds(SIDEMENU.ABOUT.X, SIDEMENU.ABOUT.Y, SIDEMENU.ABOUT.W,
                SIDEMENU.ABOUT.H);
        lbAbout.setForeground(new Color(SIDEMENU.ABOUT.R, SIDEMENU.ABOUT.G, SIDEMENU.ABOUT.B));
        lbAbout.setFont(new Font(SIDEMENU.ABOUT.FONT_FAMILY, SIDEMENU.ABOUT.FONT_WEIGHT,
                SIDEMENU.ABOUT.FONT_SIZE));
        lbAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbAbout.setEnabled(false);
        lbAbout.addMouseListener(new AboutButtonActions(lbAbout));
        
        pnSideMenu.setLayout(null);
        pnSideMenu.add(lbTitle);
        pnSideMenu.add(lbDetailLine);
        pnSideMenu.add(lbMenuItemFlow);
        pnSideMenu.add(lbAbout);
        pnSideMenu.add(lbBackgroundWhite);
        
        return pnSideMenu;
    }
    
    private void initComponents() {
        setLayout(null);
        this.add(getAppName());
        this.add(getMenu());
        this.add(getSideMenu());
        this.add(pnConfigs);
        this.add(getBackgroundConfiguration());
    }
}
