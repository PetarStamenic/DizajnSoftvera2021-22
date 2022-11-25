package rudok.app.gui.swing.controller.factories.newActionFactory_NIJE_NAJBOLJI_FACTORY;

import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.Dialog.FacrotyDialogs.NewFactoryPresentationDialog;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.Slide;

import javax.swing.*;

public class NewPresentationFactory implements TreeNodeCreator{

    private NewFactoryPresentationDialog newFactoryPresentationDialog;
    private MyTreeNode parent;

    public NewPresentationFactory(MyTreeNode myTreeNode) {
        this.parent = myTreeNode;
    }

    @Override
    public void createTreeNode() {
        newFactoryPresentationDialog = new NewFactoryPresentationDialog(this);
        newFactoryPresentationDialog.setVisible(true);
    }

    public void doTheThing(String presentationName , String presentationAuthor , String imageURL){
        Presentation presentation = new Presentation(parent.getRunode(),presentationName,presentationAuthor,imageURL);
        Slide slide = new Slide(presentation);
        presentation.addChild(slide);
        ((Project)parent.getRunode()).addChild(presentation);
        MainFrame.getInstance().getActionManager().getProjectViewControler().renderProject();
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());

    }

    public void finished(String presentationName ,
                         String presentatonAuthor ,
                         String imageURL){
        this.newFactoryPresentationDialog.dispose();
        this.doTheThing(presentationName,presentatonAuthor,imageURL);


    }


}
