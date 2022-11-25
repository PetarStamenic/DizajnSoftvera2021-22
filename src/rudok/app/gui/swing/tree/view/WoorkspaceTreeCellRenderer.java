package rudok.app.gui.swing.tree.view;


import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.model.woorkspace.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class WoorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {

    public WoorkspaceTreeCellRenderer(){

    }

    /*
    U zavisnosti od toga sta nam je selektovani RuNode dodeljujemo ikonice
     */

    public Component getTreeCellRendererComponent(JTree tree,
                                                  Object valueObject,
                                                  boolean selected,
                                                  boolean expanded,
                                                  boolean leaf,
                                                  int row,
                                                  boolean focus) {
        super.getTreeCellRendererComponent(tree, valueObject, selected, expanded, leaf, row, focus);
        RuNode value = ((MyTreeNode)valueObject).getRunode();
            if (value instanceof Slide) {
                ImageIcon imageIcon = new ImageIcon("assets/icons8-paper-50.png");
                Icon icon = null;
                if (imageIcon != null) {
                    icon = new ImageIcon(imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
                }
                setIcon(icon);
            } else if (value instanceof Presentation) {
                ImageIcon imageIcon = new ImageIcon("assets/icons8-presentation-48.png");
                Icon icon = null;
                if (imageIcon != null) {
                    icon = new ImageIcon(imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
                }
                setIcon(icon);
            } else if (value instanceof Project) {
                ImageIcon imageIcon = new ImageIcon("assets/icons8-microsoft-project-50.png");
                Icon icon = null;
                if (imageIcon != null) {
                    icon = new ImageIcon(imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
                }
                setIcon(icon);
            } else if (value instanceof Workspace) {
                ImageIcon imageIcon = new ImageIcon("assets/icons8-workspace-50.png");
                Icon icon = null;
                if (imageIcon != null) {
                    icon = new ImageIcon(imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));
                }
                setIcon(icon);
            }
        return this;
    }
    }

