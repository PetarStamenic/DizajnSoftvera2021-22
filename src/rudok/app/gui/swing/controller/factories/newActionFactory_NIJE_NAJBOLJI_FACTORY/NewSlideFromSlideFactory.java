package rudok.app.gui.swing.controller.factories.newActionFactory_NIJE_NAJBOLJI_FACTORY;

import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Slide;

import javax.swing.*;

public class NewSlideFromSlideFactory implements TreeNodeCreator{

    private MyTreeNode parent;
    public NewSlideFromSlideFactory(MyTreeNode myTreeNode) {
        this.parent = myTreeNode;
    }

    @Override
    public void createTreeNode() {
        addSlide(new Slide(parent.getRunode().getParent()));
    }

    public void addSlide(Slide slide) {
        ((Presentation)((Slide)parent.getRunode()).getParent()).addChild(slide);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
    }
}

