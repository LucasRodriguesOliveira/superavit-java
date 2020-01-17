package lro.superavit.view;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lucas Oliveira
 */
public abstract class BaseView extends JPanel {
    protected final ArrayList<JLabel> itens = new ArrayList<>();
    protected String name;
    protected Container parent;
    
    public BaseView(String name, Container parent) {
        this.name = name;
        this.parent = parent;
    }
    
    public ArrayList<JLabel> getItens() {
        return itens;
    }
    
    protected void initProps() {
        this.setLayout(null);
        itens.forEach((i) -> {
            this.add(i);
        });
    }
    
    public String getViewName() {
        return this.name;
    }
}
