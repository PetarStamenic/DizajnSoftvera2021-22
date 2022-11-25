package rudok.app.gui.swing.view;

import rudok.app.gui.swing.tree.controler.WorkspaceTreeControler;
import rudok.app.gui.swing.tree.model.TreeModel;
import rudok.app.gui.swing.tree.view.WoorkspaceTreeCellRenderer;
import rudok.app.gui.swing.tree.view.WorkspaceTreeEdit;
import rudok.app.model.woorkspace.Project;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class WorskpaceTree extends JTree {

    public WorskpaceTree(){
        addTreeSelectionListener(new WorkspaceTreeControler());
        setCellEditor(new WorkspaceTreeEdit(this, new DefaultTreeCellRenderer()));
        setCellRenderer(new WoorkspaceTreeCellRenderer());
        setEditable(true);
    }

    public void addProject(Project project){
        ((TreeModel)getModel()).addProject(project);
        SwingUtilities.updateComponentTreeUI(this);
    }

}
