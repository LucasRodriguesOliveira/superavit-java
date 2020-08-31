package view;

import components.AppName;
import components.Background;
import components.Menu;
import constants.ConfigurationConstants.CONFIGURATION;
import constants.ConfigurationConstants.CONFIGURATION.*;
import constants.ConfigurationConstants.CONFIGURATION.CONFIG_PANEL.FLOW.DETAILS;
import constants.ConfigurationConstants.CONFIGURATION.CONFIG_PANEL.FLOW.DETAILS.CONTAINER.INFO.THUMBNAIL_CONTAINER;
import constants.ConfigurationConstants.CONFIGURATION.CONFIG_PANEL.FLOW.DETAILS.CONTAINER.INFO.FLOW_NAME;
import constants.ConfigurationConstants.CONFIGURATION.CONFIG_PANEL.FLOW.FLOW_LIST;
import constants.ConfigurationConstants.CONFIGURATION.CONFIG_PANEL.FLOW.FLOW_LIST.CONTAINER.LIST;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lucas Oliveira
 */
public class ConfigurationView extends BaseView {
    private JPanel pnConfigs;
    private CardLayout layout;
    
    private JPanel flowContainer;
    private JPanel flowListContainer;
    private JPanel flowDetailContainer;
    
    private JLabel lbflowIcon;
    private JTextField tfflowName;
    private JComboBox cbflowTypes;
    
    private HashMap<String, Color> colors;
    private String[][] flowItems;
    private FlowItem selectedFlow;
    private FlowType[] flowtypes;
    
    public ConfigurationView(Container parent) {
        super(CONFIGURATION.NAME, parent);
        
        initColors();
        generateComponents();
        initComponents();
    }
    
    private class FlowType {
       private int id;
       private String description;
       
       public FlowType(int id, String description) {
           this.id = id;
           this.description = description;
       }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
    
    private class FlowItem {
        private int id;
        private String name;
        private String color;
        private String icon;
        private int priority;
        private double balance;
        private FlowType type;
        
        public FlowItem(int id, String name, String color, String icon, int priority, double balance, FlowType type) {
            this.id = id;
            this.name = name;
            this.color = color;
            this.icon = icon;
            this.priority = priority;
            this.balance = balance;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
        
        public FlowType getType() {
            return type;
        }

        public void setType(FlowType type) {
            this.type = type;
        }
    }
    
    private void initColors() {
        colors = new HashMap<>();
        colors.put(LIST.BG_NAME, new Color(
                LIST.BACKGROUND_R, LIST.BACKGROUND_G, LIST.BACKGROUND_B));
        colors.put(LIST.FG_NAME, new Color(
                LIST.FOREGROUND_R, LIST.FOREGROUND_G, LIST.FOREGROUND_B));
        colors.put(LIST.HOVER_BG_NAME, new Color(
                LIST.HOVER_BACKGROUND_R, LIST.HOVER_BACKGROUND_G, LIST.HOVER_BACKGROUND_B));
        colors.put(LIST.HOVER_FG_NAME, new Color(
                LIST.HOVER_FOREGROUND_R, LIST.HOVER_FOREGROUND_G, LIST.HOVER_FOREGROUND_B));
        colors.put(LIST.SELECTED_BG_NAME, new Color(
                LIST.SELECTED_BACKGROUND_R, LIST.SELECTED_BACKGROUND_G, LIST.SELECTED_BACKGROUND_B));
        colors.put(LIST.SELECTED_FG_NAME, new Color(
                LIST.SELECTED_FOREGROUND_R, LIST.SELECTED_FOREGROUND_G, LIST.SELECTED_FOREGROUND_B));
    }
    
    private class Model extends AbstractTableModel {
        protected String[] columns;
        protected Object[][] rows;
        
        private final List<Color> BackgroundRowColors;
        private final List<Color> textRowColors;

        public Model (String[] columns, Object[][] rows) {
          this.columns = columns;
          this.rows = rows;
          this.BackgroundRowColors = new ArrayList<>();
          this.textRowColors = new ArrayList<>();
          for (Object[] row : rows) {
              BackgroundRowColors.add(colors.get(LIST.BG_NAME));
              textRowColors.add(colors.get(LIST.FG_NAME));
          }
        }
        
        public void setBackgroundRowColor(int row, Color c) {
            BackgroundRowColors.set(row, c);
            fireTableRowsUpdated(row, row);
        }
        
        public Color getBackgroundRowColor(int row) {
            return BackgroundRowColors.get(row);
        }
        
        public void setTextRowColor(int row, Color c) {
            textRowColors.set(row, c);
            fireTableRowsUpdated(row, row);
        }
        
        public Color getTextRowColor(int row) {
            return textRowColors.get(row);
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
    
    private static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Model m = (Model) table.getModel();
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(m.getBackgroundRowColor(row));
            c.setForeground(m.getTextRowColor(row));
            
            return c;
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
    
    /*
      Permite controlar um efeito parecido com o Hover do CSS
    */
    private class MouseMotionTableActions extends MouseMotionAdapter {
        private int lastRow;
        
        public MouseMotionTableActions() {
            this.lastRow = -1;
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            JTable tb = (JTable) e.getSource();
            int pos = tb.rowAtPoint(e.getPoint());
            Model m = (Model)tb.getModel();
            if(pos != lastRow && pos >= 0) {
                if(lastRow >= 0 && tb.getSelectedRow() != lastRow) {
                    m.setBackgroundRowColor(lastRow, colors.get(LIST.BG_NAME));
                    m.setTextRowColor(lastRow, colors.get(LIST.FG_NAME));
                }
                lastRow = pos;
                
                if(tb.getSelectedRow() != lastRow) {
                  m.setBackgroundRowColor(pos, colors.get(LIST.HOVER_BG_NAME));
                  m.setTextRowColor(pos, colors.get(LIST.HOVER_FG_NAME));
                }
            }
        }
    }
    
    private void setSelected(int pos) {
        this.selectedFlow = fakeData()[pos];
        String imgPath = "/resources/" + selectedFlow.icon + " " + selectedFlow.color + ".png";
        lbflowIcon.setIcon(getImage(imgPath));
        tfflowName.setText(selectedFlow.getName());
        
        CardLayout l = (CardLayout) flowDetailContainer.getLayout();
        l.last(flowDetailContainer);
    }
    
    private class MouseClickActions extends MouseAdapter {
        private int lastSelected;
        
        public MouseClickActions() {
            lastSelected = -1;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            JTable tb = (JTable) e.getSource();
            Model m = (Model) tb.getModel();
            if(lastSelected != tb.getSelectedRow() && lastSelected >= 0) {
                m.setBackgroundRowColor(lastSelected, colors.get(LIST.BG_NAME));
                m.setTextRowColor(lastSelected, colors.get(LIST.FG_NAME));
            }
            
            m.setBackgroundRowColor(tb.getSelectedRow(), colors.get(LIST.SELECTED_BG_NAME));
            m.setTextRowColor(tb.getSelectedRow(), colors.get(LIST.SELECTED_FG_NAME));
            lastSelected = tb.getSelectedRow();
            setSelected(lastSelected);
        }
    }
    
    private JPanel generateFlowListPanel() {
        JTable tbDados = new JTable(new Model(new String[]{LIST.TABLE_COLUMN_NAME}, flowItems));
        tbDados.setDefaultRenderer(String.class, new CustomTableCellRenderer());
        ((CustomTableCellRenderer) tbDados.getDefaultRenderer(String.class))
                .setHorizontalAlignment(LIST.ALIGNMENT);
        tbDados.setSelectionMode(LIST.SELECTION_MODEL);
        tbDados.setCursor(new Cursor(LIST.CURSOR));
        tbDados.setFocusable(LIST.FOCUSABLE);
        tbDados.setFont(new Font(LIST.FONT_FAMILY, LIST.FONT_WEIGHT, LIST.FONT_SIZE));
        tbDados.setRowHeight(LIST.H);
        tbDados.setTableHeader(null);
        tbDados.setShowVerticalLines(LIST.SHOW_VERTICAL_LINES);
        tbDados.setBorder(new LineBorder(new Color(
                LIST.LINEBORDER_R, LIST.LINEBORDER_G, LIST.LINEBORDER_B), LIST.LINEBORDER_SIZE));
        
        tbDados.addMouseMotionListener(new MouseMotionTableActions());
        tbDados.addMouseListener(new MouseClickActions());
        
        tbDados.setToolTipText(LIST.TOOLTIP);
        
        JPanel pnContainer = new JPanel(new BorderLayout());
        pnContainer.add(new JScrollPane(tbDados), LIST.BORDER_LAYOUT_POSITION);
        
        return pnContainer;
    }
    
    private void generateFlowListContainer() {
        CardLayout c = new CardLayout();
        flowListContainer = new JPanel(c);
        flowListContainer.setBounds(FLOW_LIST.CONTAINER.X, FLOW_LIST.CONTAINER.Y,
                FLOW_LIST.CONTAINER.W, FLOW_LIST.CONTAINER.H);
        
        flowListContainer.add(generateNoItemPanel());
        flowListContainer.add(generateFlowListPanel());
        
        if(flowItems.length > 0) {
            c.last(flowListContainer);
        }
    }
    
    private JLabel generateNoItemSelectedText() {
        JLabel lbNoItem = new JLabel(DETAILS.CONTAINER.NO_ITEM.TEXT.TEXT);
        lbNoItem.setBounds(DETAILS.CONTAINER.NO_ITEM.TEXT.X, DETAILS.CONTAINER.NO_ITEM.TEXT.Y,
                DETAILS.CONTAINER.NO_ITEM.TEXT.W, DETAILS.CONTAINER.NO_ITEM.TEXT.H);
        lbNoItem.setForeground(new Color(DETAILS.CONTAINER.NO_ITEM.TEXT.R,
                DETAILS.CONTAINER.NO_ITEM.TEXT.G, DETAILS.CONTAINER.NO_ITEM.TEXT.B));
        lbNoItem.setFont(new Font(DETAILS.CONTAINER.NO_ITEM.TEXT.FONT_FAMILY,
                DETAILS.CONTAINER.NO_ITEM.TEXT.FONT_WEIGHT, DETAILS.CONTAINER.NO_ITEM.TEXT.FONT_SIZE));
        
        return lbNoItem;
    }
    
    private JPanel generateNoItemSelectedPanel() {
        JPanel pnNoItem = new JPanel();
        pnNoItem.setLayout(null);
        pnNoItem.setBounds(DETAILS.CONTAINER.NO_ITEM.X, DETAILS.CONTAINER.NO_ITEM.Y,
                DETAILS.CONTAINER.NO_ITEM.W, DETAILS.CONTAINER.NO_ITEM.H);
        pnNoItem.add(generateNoItemSelectedText());
        pnNoItem.add(generateFlowBackground(pnNoItem.getBounds(), DETAILS.CONTAINER.BACKGROUND.IMG_PATH));
        
        return pnNoItem;
    }
    
    private void generateFlowIcon() {
        lbflowIcon = new JLabel();
        lbflowIcon.setBounds(THUMBNAIL_CONTAINER.THUMBNAIL.IX, THUMBNAIL_CONTAINER.THUMBNAIL.IY,
                THUMBNAIL_CONTAINER.THUMBNAIL.IW, THUMBNAIL_CONTAINER.THUMBNAIL.IH);
        String img_path = "/resources/wallet black.png";
        lbflowIcon.setIcon(getImage(img_path));
    }
    
    private JPanel generateFlowDetailsImageThumbnail() {
        generateFlowIcon();
        
        JPanel thumbnail = new JPanel();
        thumbnail.setLayout(null);
        thumbnail.setBounds(THUMBNAIL_CONTAINER.THUMBNAIL.TX, THUMBNAIL_CONTAINER.THUMBNAIL.TY,
                THUMBNAIL_CONTAINER.THUMBNAIL.TW, THUMBNAIL_CONTAINER.THUMBNAIL.TH);
        thumbnail.add(lbflowIcon);
        Rectangle bounds = new Rectangle(0, 0, THUMBNAIL_CONTAINER.THUMBNAIL.TW,
                THUMBNAIL_CONTAINER.THUMBNAIL.TH);
        thumbnail.add(generateFlowBackground(bounds,
                THUMBNAIL_CONTAINER.THUMBNAIL.IMG_PATH));
        thumbnail.add(generateFlowBackground(bounds, DETAILS.CONTAINER.BACKGROUND.IMG_PATH));
        thumbnail.setToolTipText(THUMBNAIL_CONTAINER.TOOLTIP);
        thumbnail.setCursor(new Cursor(THUMBNAIL_CONTAINER.CURSOR));
        
        return thumbnail;
    }
    
    private JPanel generateFlowDetailThumbnail() {
        JPanel thumbnail = new JPanel();
        thumbnail.setLayout(null);
        thumbnail.setBounds(THUMBNAIL_CONTAINER.X, THUMBNAIL_CONTAINER.Y, 
                THUMBNAIL_CONTAINER.W, THUMBNAIL_CONTAINER.H);
        Rectangle bounds = new Rectangle(0, 0, THUMBNAIL_CONTAINER.W,
                THUMBNAIL_CONTAINER.H);
        thumbnail.add(generateFlowDetailsImageThumbnail());
        thumbnail.add(generateFlowBackground(bounds, DETAILS.CONTAINER.BACKGROUND.IMG_PATH));
        
        return thumbnail;
    }
    
    private class FlowNameMouseActions extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            ((JTextField) e.getSource()).setEditable(true);
        }
    }
    
    private void generateFlowNameTextField() {
        tfflowName = new JTextField();
        tfflowName.setColumns(FLOW_NAME.LENGTH);
        tfflowName.setBounds(FLOW_NAME.X, FLOW_NAME.Y, FLOW_NAME.W, FLOW_NAME.H);
        tfflowName.setForeground(new Color(FLOW_NAME.FR, FLOW_NAME.FG, FLOW_NAME.FB));
        tfflowName.setBackground(new Color(FLOW_NAME.BR, FLOW_NAME.BG, FLOW_NAME.BB));
        tfflowName.setFont(new Font(FLOW_NAME.FONT_FAMILY, FLOW_NAME.FONT_WEIGHT, FLOW_NAME.FONT_SIZE));
        tfflowName.setEditable(FLOW_NAME.IS_EDITABLE);
        tfflowName.addMouseListener(new FlowNameMouseActions());
        tfflowName.setCursor(new Cursor(FLOW_NAME.CURSOR));
        tfflowName.setToolTipText(FLOW_NAME.TOOLTIP);
    }
    
    private void generateComboBoxFlowTypes() {
        cbflowTypes = new JComboBox(flowtypes);
    }
    
    private JPanel generateFlowDetail() {
        generateFlowNameTextField();
        
        JPanel pnDetail = new JPanel();
        pnDetail.setLayout(null);
        pnDetail.setBounds(DETAILS.CONTAINER.INFO.X, DETAILS.CONTAINER.INFO.Y,
                DETAILS.CONTAINER.INFO.W, DETAILS.CONTAINER.INFO.H);
        pnDetail.add(generateFlowDetailThumbnail());
        pnDetail.add(tfflowName);
        pnDetail.add(generateFlowBackground(pnDetail.getBounds(), 
                DETAILS.CONTAINER.BACKGROUND.IMG_PATH));
        
        return pnDetail;
    }
    
    private void generateFlowDetailContainer() {
        CardLayout c = new CardLayout();
        flowDetailContainer = new JPanel(c);
        flowDetailContainer.setBounds(DETAILS.CONTAINER.X, DETAILS.CONTAINER.Y,
                DETAILS.CONTAINER.W, DETAILS.CONTAINER.H);
        
        flowDetailContainer.add(generateNoItemSelectedPanel());
        flowDetailContainer.add(generateFlowDetail());
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
    
    private FlowItem[] fakeData() {
        flowtypes = new FlowType[] {
            new FlowType(1, "Carteira"),
            new FlowType(2, "Banco"),
            new FlowType(3, "Poupança"),
        };
        
        FlowItem[] items = {
            new FlowItem(1, "Nubank", "purple", "bank", 1, 100, flowtypes[1]),
            new FlowItem(2, "Carteira", "red", "wallet", 1, 45.75, flowtypes[0]),
            new FlowItem(3, "Next", "green", "bank", 1, 2300, flowtypes[1]),
            new FlowItem(4, "Poupança", "light blue", "savings", 1, 150, flowtypes[2])
        };
        
        return items;
    }
    
    private void getFlowData() {
        FlowItem[] items = fakeData();
        int size = items.length;
        flowItems = new String[size][1];
        
        for(int i = 0; i < size; i++) {
            flowItems[i][0] = items[i].getName();
        }
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
        
        getFlowData();
        generateFlowListContainer();
        generateFlowDetailContainer();
        
        flowContainer.add(title);
        flowContainer.add(flowListTitle);
        flowContainer.add(flowDetailsTitle);
        flowContainer.add(flowListContainer);
        flowContainer.add(flowDetailContainer);
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
