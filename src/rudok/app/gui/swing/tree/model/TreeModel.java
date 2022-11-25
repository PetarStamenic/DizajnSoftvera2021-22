package rudok.app.gui.swing.tree.model;

import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.model.woorkspace.*;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class TreeModel extends DefaultTreeModel{


    public TreeModel(TreeNode treeNode){
        super(treeNode);
    }

    public void addProject(Project project){
        ((MyTreeNode)getRoot()).addProject(project);
    }

}
