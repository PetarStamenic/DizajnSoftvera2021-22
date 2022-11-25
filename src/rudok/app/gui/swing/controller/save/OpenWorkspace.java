package rudok.app.gui.swing.controller.save;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.Workspace;
import rudok.app.model.woorkspace.WorkspaceContext;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OpenWorkspace extends AbstractRuDokAction {

    private OpenProject openProject = new OpenProject();
    private SaveWorkspace saveWorkspace = new SaveWorkspace();

    private JFileChooser openChoser;
    private String iconString = "assets/icons8-window-other-50.png";

    /*
            Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
            dodeljuje keybind
            dodeljuje ikonicu
            dodeljuje ime
            i dodeljuje description kada predjemo preko dugmeta
             */
    public OpenWorkspace() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Open Ws");
        putValue(SHORT_DESCRIPTION, "Open Workspace");
    }
/*
Otvara JDialog koji nam daje da selektujemo workspace ili foldere
ukoliko smo selektovali wokrspace nudmi zatvaranje trenutnog workspace (uz cuvanje)
otvaramo novi wokrsapce
otvaramo projekte iz novog workspace
prosledjujemo na controler za otvaranje projekata
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        Workspace1.getInstance().setBusy(true);
        if(!Workspace1.getInstance().getWorkspace().getChildren().isEmpty() && Workspace1.getInstance().getWorkspace().getWorkspaceSaveFile() == null) {
            saveWorkspace.doTheThing();
        }

        openChoser = new JFileChooser();
        openChoser.setCurrentDirectory(new File("C:\\Users\\Petar\\Documents\\RuDok\\Workspace"));
        openChoser.setFileFilter(new MySaveFilter());

        if (openChoser.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            Workspace1.getInstance().getWorkspace().removeallChildren();
            try {
                FileInputStream fileInputStream = new FileInputStream(openChoser.getSelectedFile());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Project project = null;
                WorkspaceContext workspaceContext = new WorkspaceContext();
                Workspace workspace = null;
                try {
                    workspaceContext.name = (String) objectInputStream.readObject();
                    workspaceContext.childrenURL = (ArrayList<String>) objectInputStream.readObject();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                Workspace1.getInstance().getWorkspace().setWorkspaceSaveFile(openChoser.getSelectedFile());
                Workspace1.getInstance().getWorkspace().setName(workspaceContext.name);
                for (String str:workspaceContext.childrenURL) {
                    Workspace1.getInstance().getWorkspace().addChildrenURL(str);
                    openProject.doTheThing(new File(str));
                }
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException i) {
                i.printStackTrace();
            }

        }
        Workspace1.getInstance().setBusy(false);
    }

    public void doTheThing(File file){
            Workspace1.getInstance().setBusy(true);
            Workspace1.getInstance().getWorkspace().removeallChildren();
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Project project = null;
                WorkspaceContext workspaceContext = new WorkspaceContext();
                Workspace workspace = null;
                try {
                    workspaceContext.name = (String) objectInputStream.readObject();
                    workspaceContext.childrenURL = (ArrayList<String>) objectInputStream.readObject();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                Workspace1.getInstance().getWorkspace().setWorkspaceSaveFile(file);
                Workspace1.getInstance().getWorkspace().setName(workspaceContext.name);
                for (String str:workspaceContext.childrenURL) {
                    Workspace1.getInstance().getWorkspace().addChildrenURL(str);
                    openProject.doTheThing(new File(str));
                }
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        Workspace1.getInstance().setBusy(false);

        }
    }


