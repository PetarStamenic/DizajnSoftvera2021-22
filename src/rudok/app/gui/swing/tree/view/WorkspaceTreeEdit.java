package rudok.app.gui.swing.tree.view;

import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.model.woorkspace.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class WorkspaceTreeEdit extends DefaultTreeCellEditor implements ActionListener{

    private JTextField editField = null;
    private RuNode node = null;

    public WorkspaceTreeEdit(JTree jTree,
                             DefaultTreeCellRenderer defaultTreeCellRenderer){
        super(jTree,defaultTreeCellRenderer);

    }
/*
Omogucava editovanje JTree
 */
    public Component getTreeCellEditorComponent(JTree jtree,
                                                Object object,
                                                boolean one,
                                                boolean two,
                                                boolean tree,
                                                int num){
        node = ((MyTreeNode) object).getRunode();
        editField = new JTextField(object.toString());
        editField.addActionListener(this);

        return editField;

    }

    public boolean isEditable(EventObject eventObject){
        if(eventObject instanceof MouseEvent)
            if (((MouseEvent)eventObject).getClickCount()==3){
                return true;
            }
        return false;
    }

    public void actionPerformed(ActionEvent actionEvent){
        if(node instanceof Slide){
            ((Slide)node).setName(actionEvent.getActionCommand());
        } else if( node instanceof Presentation){
            ((Presentation)node).setName(actionEvent.getActionCommand());
        } else if(node instanceof Project){
            ((Project)node).setName(actionEvent.getActionCommand());
        } else if(node instanceof Workspace){
            ((Workspace)node).setName(actionEvent.getActionCommand());
        }
    }


}
