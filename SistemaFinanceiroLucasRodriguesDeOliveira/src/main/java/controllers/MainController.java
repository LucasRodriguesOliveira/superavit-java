package controllers;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import lro.superavit.view.BaseView;
import lro.superavit.view.InitialView;
import lro.superavit.view.LoginView;

/**
 *
 * @author Lucas Oliveira
 */
public class MainController {
    private ArrayList<BaseView> views;
    private CardLayout LayoutManager;
    public static MainController Controller;

    public void initViews(Container parent) {
        views = new ArrayList<>();
        views.add(new InitialView(parent));
        views.add(new LoginView(parent));
    }
    
    public ArrayList<BaseView> getViews() {
        return this.views;
    }
    
    public CardLayout getLayout() {
        return this.LayoutManager;
    }
    
    public void generateComponents() {
        this.LayoutManager = new CardLayout();
    }
    
    public void firstView(Container parent) {
        ((CardLayout) parent.getLayout()).first(parent);
    }
    
    public void lastView(Container parent) {
        ((CardLayout) parent.getLayout()).last(parent);
    }
    
    public void previusView(Container parent) {
        ((CardLayout) parent.getLayout()).previous(parent);
    }
    
    public void nextView(Container parent) {
        ((CardLayout) parent.getLayout()).next(parent);
    }
    
    public void changeView(Container parent, String name) {
        ((CardLayout) parent.getLayout()).show(parent, name);
    }
}
