package rudok.app.gui.swing.controller.save;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveProject extends AbstractRuDokAction {

    private JFileChooser saveChooser;
    private String iconString = "assets/icons8-save-50.png";
    Project activeProject;
    File activeProjectFile;

    /*
            Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
            dodeljuje keybind
            dodeljuje ikonicu
            dodeljuje ime
            i dodeljuje description kada predjemo preko dugmeta
             */
    public SaveProject(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Save Project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        doTheThing();
    }

    /*
    Otvaramo JFileChooser za cuvanje dokumenta sa nasim custom filterom
    selektujemo gde se nalazi i kako ce se zvati
    preko java serijalizacije cuvamo
     */
    public void doTheThing(){

        saveChooser = new JFileChooser();
        saveChooser.setCurrentDirectory(new File("C:\\Users\\Petar\\Documents\\RuDok"));
        saveChooser.setFileFilter(new MySaveFilter());


        activeProject = Workspace1.getInstance().getActiveProject();
        activeProjectFile = activeProject.getFile();

        if(!activeProject.getChanged()){
            return;
        }

        if(activeProject.getFile() == null){
            if(saveChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                activeProject.setFile(saveChooser.getSelectedFile());
                activeProjectFile = activeProject.getFile();
                Workspace1.getInstance().getWorkspace().addChildrenURL(activeProjectFile+MainFrame.getInstance().getExtension());
            } else {
                return;
            }
        }


        try {
            if(!activeProjectFile.toString().endsWith(MainFrame.getInstance().getExtension())){
                activeProjectFile = new File(activeProjectFile + MainFrame.getInstance().getExtension());
            }

            FileOutputStream fileOutputStream = new FileOutputStream(activeProjectFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(activeProject);
            objectOutputStream.close();
            fileOutputStream.close();
            Workspace1.getInstance().getActiveProject().setChanged(false);
            MainFrame.getInstance().getWorkspaceTree().revalidate();
        } catch (IOException i){
            i.printStackTrace();
        }

    }

    /*
    prolazimo kkroz sve projekte i cuvamo ih
     */
    public void saveAll(){
        for (RuNode project : Workspace1.getInstance().getWorkspace().getChildren()) {
            project.setChanged(true);
            Workspace1.getInstance().setActiveProject((Project) project);
            doTheThing();
        }
    }

}
