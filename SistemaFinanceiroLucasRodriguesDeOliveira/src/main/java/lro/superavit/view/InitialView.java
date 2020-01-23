package lro.superavit.view;

import components.Background;
import components.CloseButton;
import components.LetsGoButton;
import constants.InitialConstants.CLOSE_BUTTON;
import constants.InitialConstants.LETSGO_BUTTON;
import constants.InitialConstants.INITIAL;
import java.awt.Container;
/**
 *
 * @author Lucas Oliveira
 */
public final class InitialView extends BaseView {  
    public InitialView(Container parent){
      super(INITIAL.NAME, parent);
      this.initComponents();
    }

    private CloseButton getCloseButton() {
        return new CloseButton(CLOSE_BUTTON.X, CLOSE_BUTTON.Y,
                  CLOSE_BUTTON.W, CLOSE_BUTTON.H, CLOSE_BUTTON.TOOLTIP, this.parent);
    }
    
    public LetsGoButton getLetsGoButton() {
        return new LetsGoButton(LETSGO_BUTTON.X, LETSGO_BUTTON.Y,
                  LETSGO_BUTTON.W, LETSGO_BUTTON.H, LETSGO_BUTTON.TOOLTIP, this.parent);
    }
    
    private Background getBackgroundInitial() {
        return new Background(INITIAL.X, INITIAL.Y, INITIAL.W, INITIAL.H, INITIAL.IMAGE);
    }

    protected void initComponents() {
      this.itens.add(getLetsGoButton());
      this.itens.add(getCloseButton());
      this.itens.add(getBackgroundInitial());
      this.initProps();
    }
}
