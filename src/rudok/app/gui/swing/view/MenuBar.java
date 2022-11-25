package rudok.app.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    public MenuBar(){


        JMenu rename = new JMenu("Rename");
        rename.add(MainFrame.getInstance().getActionManager().getChangeAutorAction());
        rename.add(MainFrame.getInstance().getActionManager().getRenameAction());
        rename.add(MainFrame.getInstance().getActionManager().getChangeBackgroundAction());

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.add(MainFrame.getInstance().getActionManager().getNewCreateAction());
        file.addSeparator();
        file.add(MainFrame.getInstance().getActionManager().getSaveProject());
        file.add(MainFrame.getInstance().getActionManager().getOpenProject());
        file.addSeparator();
        file.add(MainFrame.getInstance().getActionManager().getSaveProject());
        file.add(MainFrame.getInstance().getActionManager().getOpenWorkspace());
        file.addSeparator();
        file.add(MainFrame.getInstance().getActionManager().getDeleteProjectAction());
        file.addSeparator();
        file.add(MainFrame.getInstance().getActionManager().getExitAction());

        JMenu edit = new JMenu("Edit");
        edit.setMnemonic(KeyEvent.VK_E);
        edit.add(MainFrame.getInstance().getActionManager().getUndoCommand());
        edit.add(MainFrame.getInstance().getActionManager().getRedoCommand());
        edit.addSeparator();
        edit.add(MainFrame.getInstance().getActionManager().getRenameAction());
        edit.addSeparator();
        edit.add(MainFrame.getInstance().getActionManager().getChangeAutorAction());
        edit.addSeparator();
        edit.add(MainFrame.getInstance().getActionManager().getChangeBackgroundAction());


        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_HELP);
        help.add(MainFrame.getInstance().getActionManager().getInfoAction());
        edit.add(help);

        this.add(file);
        this.add(edit);
        this.add(help);
    }
}
