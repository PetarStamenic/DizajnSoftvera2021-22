package rudok.app.gui.swing.controller.viewControler;

import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.tree.view.elements.ProjectView;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.Slide;
import rudok.app.model.woorkspace.Workspace;
import rudok.app.repository.Workspace1;

import java.awt.*;

public class PainControler {

    public void paint(MyTreeNode myTreeNode){
        paintThings(repaintStuff(myTreeNode));
    }

    public ProjectView repaintStuff(MyTreeNode myTreeNode) {
        if(myTreeNode == null){
            myTreeNode = (MyTreeNode) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot();
        }
        myTreeNode.setParent(new MyTreeNode(myTreeNode.getRunode().getParent()));
        if (myTreeNode.getRunode() instanceof Project) {
            Workspace1.getInstance().setActiveProject((Project) myTreeNode.getRunode());
            return new ProjectView((Project) myTreeNode.getRunode(), 0);
        } else if (myTreeNode.getRunode() instanceof Presentation) {
            Workspace1.getInstance().setActiveProject((Project) myTreeNode.getRunode().getParent());
            Workspace1.getInstance().setActivePresentation((Presentation) myTreeNode.getRunode());
            return new ProjectView((Project) myTreeNode.getRunode().getParent(), myTreeNode.getParent().getIndex(myTreeNode));
        } else if (myTreeNode.getRunode() instanceof Slide) {
            return new ProjectView((Project) myTreeNode.getRunode().getParent().getParent(), myTreeNode.getParent().getParent().getIndex(myTreeNode.getParent()));
        } else {
            return null;
            }
        }


    public void paintThings(ProjectView projectView){
        if(projectView != null) {
            MainFrame.getInstance().getjPaneRight().removeAll();
            MainFrame.getInstance().getjPaneRight().add(projectView, BorderLayout.CENTER);
            MainFrame.getInstance().getjPaneRight().revalidate();
            MainFrame.getInstance().getjPaneRight().repaint();
        }
    }
}