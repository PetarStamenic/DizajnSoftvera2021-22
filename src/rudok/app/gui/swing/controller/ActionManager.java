package rudok.app.gui.swing.controller;


import rudok.app.gui.swing.controller.change.ChangeAutorAction;
import rudok.app.gui.swing.controller.change.ChangeBackgroundAction;
import rudok.app.gui.swing.controller.change.RenameAction;
import rudok.app.gui.swing.controller.comands.RedoCommand;
import rudok.app.gui.swing.controller.comands.UndoCommand;
import rudok.app.gui.swing.controller.create.NewCreateAction;
import rudok.app.gui.swing.controller.delete.DeleteProjectAction;
import rudok.app.gui.swing.controller.draw.DeleteControlerRudok;
import rudok.app.gui.swing.controller.draw.MoveControlerRuDok;
import rudok.app.gui.swing.controller.draw.NewSlotControlerRuDok;
import rudok.app.gui.swing.controller.draw.NothingControlerRuDok;
import rudok.app.gui.swing.controller.save.OpenProject;
import rudok.app.gui.swing.controller.save.OpenWorkspace;
import rudok.app.gui.swing.controller.save.SaveProject;
import rudok.app.gui.swing.controller.save.SaveWorkspace;
import rudok.app.gui.swing.controller.stateControler.EditStateAction;
import rudok.app.gui.swing.controller.stateControler.SlideShowAction;
import rudok.app.gui.swing.controller.viewControler.PainControler;
import rudok.app.gui.swing.controller.viewControler.ProjectViewControler;

public class ActionManager {
    /*
    Action manager klasa preko koje mozemo pristupiti svim akcijama iz mainFrame
     */

    private ExitAction exitAction;
    private InfoAction infoAction;
    private ProjectViewControler projectViewControler;
    private DeleteProjectAction deleteProjectAction;
    private RenameAction renameAction;
    private ChangeAutorAction changeAutorAction;
    private ChangeBackgroundAction changeBackgroundAction;
    private NewCreateAction newCreateAction;
    private PainControler painControler;
    private EditStateAction editStateAction;
    private SlideShowAction slideShowAction;
    private DeleteControlerRudok deleteControlerRudok;
    private NewSlotControlerRuDok newSlotControlerRuDok;
    private NothingControlerRuDok nothingControlerRuDok;
    private MoveControlerRuDok moveControlerRuDok;
    private SaveProject saveProject;
    private UndoCommand undoCommand;
    private RedoCommand redoCommand;
    private SaveWorkspace saveWorkspace;
    private OpenProject openProject;
    private OpenWorkspace openWorkspace;

    public ActionManager() {
        initialiseActions();
    }

    public void initialiseActions() {
        exitAction = new ExitAction();
        infoAction = new InfoAction();
        projectViewControler = new ProjectViewControler();
        deleteProjectAction = new DeleteProjectAction();
        renameAction = new RenameAction();
        changeAutorAction = new ChangeAutorAction();
        changeBackgroundAction = new ChangeBackgroundAction();
        newCreateAction = new NewCreateAction();
        painControler = new PainControler();
        editStateAction = new EditStateAction();
        slideShowAction = new SlideShowAction();
        deleteControlerRudok = new DeleteControlerRudok();
        newSlotControlerRuDok = new NewSlotControlerRuDok();
        nothingControlerRuDok = new NothingControlerRuDok();
        moveControlerRuDok = new MoveControlerRuDok();
        saveProject = new SaveProject();
        undoCommand = new UndoCommand();
        redoCommand = new RedoCommand();
        saveWorkspace = new SaveWorkspace();
        openProject = new OpenProject();
        openWorkspace = new OpenWorkspace();
    }

    public SaveProject getSaveProject() {
        return saveProject;
    }

    public ProjectViewControler getProjectViewControler() {
        return projectViewControler;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public DeleteProjectAction getDeleteProjectAction() {
        return deleteProjectAction;
    }

    public RenameAction getRenameAction() {
        return renameAction;
    }

    public ChangeAutorAction getChangeAutorAction() {
        return changeAutorAction;
    }

    public ChangeBackgroundAction getChangeBackgroundAction() {
        return changeBackgroundAction;
    }

    public NewCreateAction getNewCreateAction() {
        return newCreateAction;
    }

    public PainControler getPainControler() {
        return painControler;
    }

    public EditStateAction getEditStateAction() {
        return editStateAction;
    }

    public SlideShowAction getSlideShowAction() {
        return slideShowAction;
    }

    public DeleteControlerRudok getDeleteControlerRudok() {
        return deleteControlerRudok;
    }

    public NewSlotControlerRuDok getNewSlotControlerRuDok() {
        return newSlotControlerRuDok;
    }

    public NothingControlerRuDok getNothingControlerRuDok() {
        return nothingControlerRuDok;
    }

    public MoveControlerRuDok getMoveControlerRuDok() {
        return moveControlerRuDok;
    }

    public UndoCommand getUndoCommand() {
        return undoCommand;
    }

    public RedoCommand getRedoCommand() {
        return redoCommand;
    }

    public SaveWorkspace getSaveWorkspace() {
        return saveWorkspace;
    }

    public OpenProject getOpenProject() {
        return openProject;
    }

    public OpenWorkspace getOpenWorkspace() {
        return openWorkspace;
    }
}
