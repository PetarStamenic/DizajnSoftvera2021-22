package rudok.app.gui.swing.view.toolbars;

import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;

public class EditToolBar extends JToolBar {

    public EditToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getUndoCommand());
        add(MainFrame.getInstance().getActionManager().getRedoCommand());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getRenameAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getChangeAutorAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getChangeBackgroundAction());
    }
}
