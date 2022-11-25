package rudok.app.gui.swing.view.toolbars;

import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;

public class DrawStateToolbar extends JToolBar {
    public DrawStateToolbar() {
        init();
    }

    private void init() {
        this.add(MainFrame.getInstance().getActionManager().getNothingControlerRuDok());
        addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getNewSlotControlerRuDok());
        addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getMoveControlerRuDok());
        addSeparator();
        this.add(MainFrame.getInstance().getActionManager().getDeleteControlerRudok());
    }
}
