package rudok.app.gui.swing.view.toolbars;

import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;

public class FileToolbar extends JToolBar {

    public FileToolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getNewCreateAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSaveProject());
        add(MainFrame.getInstance().getActionManager().getOpenProject());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSaveWorkspace());
        add(MainFrame.getInstance().getActionManager().getOpenWorkspace());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteProjectAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getExitAction());
    }
}
