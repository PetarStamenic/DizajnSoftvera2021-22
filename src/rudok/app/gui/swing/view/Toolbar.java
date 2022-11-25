package rudok.app.gui.swing.view;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getNewCreateAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteProjectAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getRenameAction());
        add(MainFrame.getInstance().getActionManager().getChangeAutorAction());
        add(MainFrame.getInstance().getActionManager().getChangeBackgroundAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getExitAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSaveProject());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getUndoCommand());
        add(MainFrame.getInstance().getActionManager().getRedoCommand());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSaveWorkspace());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getOpenProject());
    }
}
