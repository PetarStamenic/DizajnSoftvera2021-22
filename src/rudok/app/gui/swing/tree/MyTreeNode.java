package rudok.app.gui.swing.tree;

import rudok.app.model.woorkspace.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class MyTreeNode extends DefaultMutableTreeNode {


    public MyTreeNode(RuNode runode) {
        super(runode);
        setRunode(runode);

    }


    private RuNode runode;


    public RuNode getRunode() {
        return runode;
    }

    public void setRunode(RuNode runode) {
        this.runode = runode;
    }

    public void addProject(Project project){
        ((Workspace)runode).addChild(project);
    }

    @Override
    public void insert(MutableTreeNode child, int index) {
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(MutableTreeNode node) {

    }

    @Override
    public void setUserObject(Object object) {

    }

    @Override
    public void removeFromParent() {
        RuNode parent = runode.getParent();
        ((RuNodeComp)parent).getChildren().remove(runode);

    }


    @Override
    public void setParent(MutableTreeNode newParent) {
        this.parent = new MyTreeNode(runode.getParent());
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if(runode instanceof RuNodeComp){
            return new MyTreeNode(((RuNodeComp) runode).getChildren().get(childIndex));
        } else {
            return null;
        }
    }

    @Override
    public int getChildCount() {
        if(runode instanceof RuNodeComp){
            return ((RuNodeComp) runode).getChildren().size();
        } else {
            return 0;
        }
    }

    @Override
    public TreeNode getParent() {
        return new MyTreeNode(runode.getParent());
    }

    @Override
    public int getIndex(TreeNode node) {
        int i = 0;
        for (RuNode child : ((RuNodeComp)((MyTreeNode)node).getRunode().getParent()).getChildren()) {
            if (child == ((MyTreeNode) node).getRunode()){
                return i;
            }
            i++;
        }
        return i;
    }

    @Override
    public boolean getAllowsChildren() {
        return runode instanceof RuNodeComp;
    }

    @Override
    public boolean isLeaf() {
        return !(runode instanceof RuNodeComp);
    }





}
