package rudok.app.gui.swing.controller.factories.newActionFactory_NIJE_NAJBOLJI_FACTORY;

import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.*;

import javax.swing.*;

public class NewSlideFactory implements TreeNodeCreator{

    private MyTreeNode parent;
    public NewSlideFactory(MyTreeNode myTreeNode) {
        this.parent = myTreeNode;
    }

    @Override
    public void createTreeNode() {
        addSlide(new Slide(parent.getRunode()));
    }

    public void addSlide(Slide slide) {
        ((Presentation)parent.getRunode()).addChild(slide);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
        }
    }

