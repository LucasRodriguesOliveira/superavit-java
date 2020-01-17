package controllers;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import lro.superavit.view.BaseView;
import lro.superavit.view.Initial;

/**
 *
 * @author Lucas Oliveira
 */
public class MainController {
    private ArrayList<BaseView> views;
    private CardLayout LayoutManager;
    public static MainController Controller;
    
    public MainController(Container parent) {
        initViews(parent);
        generateComponents();
    }

    private void initViews(Container parent) {
        views = new ArrayList<>();
        views.add(new Initial(parent));
    }
    
    public ArrayList<BaseView> getViews() {
        return this.views;
    }
    
    public void letsGoButton_click() {
        
    }
    
    public CardLayout getLayout() {
        return this.LayoutManager;
    }
    
    private void generateComponents() {
        this.LayoutManager = new CardLayout();
    }
    
    public void firstView(Container parent) {
        this.LayoutManager.first(parent);
    }
    
    public void lastView(Container parent) {
        this.LayoutManager.last(parent);
    }
    
    public void previusView(Container parent) {
        this.LayoutManager.previous(parent);
    }
    
    public void nextView(Container parent) {
        this.LayoutManager.next(parent);
    }
    
    public void changeView(Container parent, String name) {
        this.LayoutManager.show(parent, name);
    }
}
