package rudok.app.gui.swing.controller.save;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.Workspace;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveWorkspace extends AbstractRuDokAction {

    private JFileChooser saveChooser;
    private String iconString = "assets/icons8-window-cloud-50.png";

    /*
            Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
            dodeljuje keybind
            dodeljuje ikonicu
            dodeljuje ime
            i dodeljuje description kada predjemo preko dugmeta
             */
    public SaveWorkspace(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Save Workspace");
        putValue(SHORT_DESCRIPTION, "Save Workspace");
    }


    /*
    JfileChooser otvaramo i biramo lokoaciju gde se cuvba i pod kojim imenom
    dodeljen je nas custom filter
    proveravamo da li se ime vec zavrsava datom ekstenzijom i ukoliko se ne zavrsava dodajemo je
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        doTheThing();
    }

    public void doTheThing(){
        saveChooser = new JFileChooser();
        saveChooser.setCurrentDirectory(new File("C:\\Users\\Petar\\Documents\\RuDok\\Workspace"));
        saveChooser.setFileFilter(new MySaveFilter());


        Workspace workspace = Workspace1.getInstance().getWorkspace();
        File workspaceFile = workspace.getWorkspaceSaveFile();

        if(workspace.getWorkspaceSaveFile() == null){
            if(saveChooser.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                workspace.setWorkspaceSaveFile(saveChooser.getSelectedFile());
                workspaceFile = workspace.getWorkspaceSaveFile();
            } else {
                return;
            }
        }

        try {
            if(!workspaceFile.toString().endsWith(MainFrame.getInstance().getExtension())){
            workspaceFile = new File(workspaceFile + MainFrame.getInstance().getExtension());
            }
            FileOutputStream fileOutputStream = new FileOutputStream(workspaceFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workspace.getName());
            objectOutputStream.writeObject(workspace.getChildrenURL());
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException i){
            i.printStackTrace();
        }

    }
}
