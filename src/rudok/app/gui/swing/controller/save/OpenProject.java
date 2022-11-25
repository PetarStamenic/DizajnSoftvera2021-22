package rudok.app.gui.swing.controller.save;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.Presentation;
import rudok.app.model.woorkspace.Project;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.model.woorkspace.Workspace;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class OpenProject extends AbstractRuDokAction {

    private JFileChooser openChoser;
    private String iconString = "assets/icons8-opened-folder-50.png";

    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public OpenProject() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Open");
        putValue(SHORT_DESCRIPTION, "Open project");
    }


    /*
    Otvaranje JFileChoosera koji nam omogucava odabir fajla
    po default postavljeno da bude u Documents
    dodeljen custom filter
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        openChoser = new JFileChooser();
        openChoser.setCurrentDirectory(new File("C:\\Users\\Petar\\Documents\\RuDok"));
        openChoser.setFileFilter(new MySaveFilter());
        if (openChoser.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION)
            try {
                /*
                ukoliko se selektuje da se otvori projekat otvara pomocu fileinputStream i ObjectInputStream
                 */
                FileInputStream fileInputStream = new FileInputStream(openChoser.getSelectedFile());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Project project = null;
                try {
                    /*
                    Ukoliko je selektovani fajl projekat ucitavamo ga
                    i ubacujemo na repository
                    postavljamo ga kao aktivni projekat
                    ucitavamo sve prezentacije iz njega
                    mis postavljamo na obican kursor
                    zatvaramo stream
                     */
                    project = (Project) objectInputStream.readObject();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                Workspace1.getInstance().getWorkspace().addChild(project);
                Workspace1.getInstance().setActiveProject(project);
                File file = openChoser.getSelectedFile();
                String PathString = file.getAbsolutePath();
                Workspace1.getInstance().getWorkspace().addChildrenURL(PathString);
                for(RuNode pres : project.getChildren()){
                    ((Presentation)pres).gotoFreeMouse();
                }
                Workspace1.getInstance().setActivePresentation((Presentation) project.getChildren().get(0));
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
    }

/*
Ucitavanje projekta kada je selektovani fajl workspace
 */
    public void doTheThing(File file){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Project project = null;
                try {
                    project = (Project) objectInputStream.readObject();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                Workspace1.getInstance().getWorkspace().addChild(project);
                Workspace1.getInstance().setActiveProject(project);
                for(RuNode pres : project.getChildren()){
                    ((Presentation)pres).gotoFreeMouse();
                }
                Workspace1.getInstance().setActivePresentation((Presentation) project.getChildren().get(0));
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException i) {
                Workspace workspace = Workspace1.getInstance().getWorkspace();
                Workspace1.getInstance().getWorkspace().removeChildURL(file.getPath());
                i.printStackTrace();
            }
        }


}


