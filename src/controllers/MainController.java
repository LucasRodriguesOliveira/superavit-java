package controllers;

import models.User;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import view.BaseView;
import view.FormSignupUserInfoView;
import view.HomeView;
import view.InitialView;
import view.LoginView;

/**
 *
 * @author Lucas Oliveira
 */
public class MainController {
    private ArrayList<BaseView> views;
    private CardLayout LayoutManager;
    public static MainController Controller;
    public static User usuario;
    private HomeView home;

    public void initViews(Container parent) {
        home = new HomeView(parent);
        
        views = new ArrayList<>();
        //views.add(new InitialView(parent));
        //views.add(new LoginView(parent));
        //views.add(home);
        //views.add(new OperationsView(parent));
        //views.add(new PaymentOptionsView(parent));
        //views.add(new BillPaymentView(parent));
        //views.add(new PayBillView(parent));
        //views.add(new PayConfirmationView(parent));
        //views.add(new PaymentCompletionView(parent));
        views.add(new FormSignupUserInfoView(parent));
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
        if(name.equals("HOME"))
            home.loadUserInfo();
        ((CardLayout) parent.getLayout()).show(parent, name);
    }
}
