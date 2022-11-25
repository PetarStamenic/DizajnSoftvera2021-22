package rudok.app.gui.swing.controller.factories.newActionFactory_NIJE_NAJBOLJI_FACTORY;

import rudok.app.gui.swing.view.Dialog.FacrotyDialogs.NewFacrotyProjectDialog;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.Slide;
import rudok.app.repository.Workspace1;

import javax.swing.*;

public class NewProjectFactory implements TreeNodeCreator{

    private NewFacrotyProjectDialog newProjectDialog;

    public NewProjectFactory() {
    }

    @Override
    public void createTreeNode() {
        newProjectDialog = new NewFacrotyProjectDialog(this);
        newProjectDialog.setVisible(true);
    }

    public void doTheThing(String projectName , String presentationName , String presentatonAuthor , String imageURL){
        Project project = new Project(Workspace1.getInstance().getWorkspace(), projectName);
        Workspace1.getInstance().setActiveProject(project);
        Presentation presentation = new Presentation(project,presentationName,presentatonAuthor,imageURL);
        Workspace1.getInstance().setActivePresentation(presentation);
        project.addChild(presentation);
        Slide slide = new Slide(presentation);
        presentation.addChild(slide);
        MainFrame.getInstance().getWorkspaceTree().addProject(project);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());

        MainFrame.getInstance().getActionManager().getProjectViewControler().renderProject(projectName);

    }


    public void finished(String projectName ,
                         String presentationName ,
                         String presentatonAuthor ,
                         String imageURL){
        this.newProjectDialog.dispose();
        this.doTheThing(projectName,presentationName,presentatonAuthor,imageURL);

    }
}
