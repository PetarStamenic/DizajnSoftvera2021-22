package rudok.app.gui.swing.controller.state.slideshow;

import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;

public class SlideStateToolbar extends JToolBar {
    public SlideStateToolbar(){
        init();
    }

    /*
    Dodavanje slide state toolbar radi preglednosti
     */
    private void init(){
        this.add(MainFrame.getInstance().getActionManager().getEditStateAction());
        addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getSlideShowAction());
    }
}
