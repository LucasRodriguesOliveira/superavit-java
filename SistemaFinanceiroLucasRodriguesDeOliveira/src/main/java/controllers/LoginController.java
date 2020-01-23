package controllers;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import lro.superavit.view.BaseView;

/**
 *
 * @author Lucas Oliveira
 */
public class LoginController {
    private ArrayList<BaseView> form_fields;
    private CardLayout LayoutManager;
    public static LoginController Controller;
    private Container form;
    
    public LoginController() {
        form_fields = new ArrayList<>();
    }

    public CardLayout getLayoutManager() {
        return LayoutManager;
    }

    public void setLayoutManager(CardLayout LayoutManager) {
        this.LayoutManager = LayoutManager;
    }

    public Container getForm() {
        return form;
    }

    public void setForm(Container form) {
        this.form = form;
    }
            
    public void initFields() {
        System.out.println("");
    }
    
    public ArrayList<BaseView> getFields() {
        return this.form_fields;
    }
    
    public void generateComponents() {
        this.LayoutManager = new CardLayout();
    }
    
    public void firstField() {
        ((CardLayout) form.getLayout()).first(form);
    }
    
    public void lastField() {
        ((CardLayout) form.getLayout()).last(form);
    }
    
    public void previusField() {
        ((CardLayout) form.getLayout()).previous(form);
    }
    
    public void nextField() {
        ((CardLayout) form.getLayout()).next(form);
    }
    
    public void changeField(String name) {
        ((CardLayout) form.getLayout()).show(form, name);
    }
}
