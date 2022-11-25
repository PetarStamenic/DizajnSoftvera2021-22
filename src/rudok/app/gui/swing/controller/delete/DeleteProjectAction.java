package rudok.app.gui.swing.controller.delete;

import rudok.app.errorHandler.ErrorFactory;
import rudok.app.errorHandler.MyError;
import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.view.Dialog.delete.DeleteProjectDialog;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.RuNode;
import rudok.app.observer.ISubscriber;
import rudok.app.repository.Workspace1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteProjectAction extends AbstractRuDokAction implements ISubscriber {


    int i = 0;
    private DeleteProjectDialog deleteProjectDialog;
    String iconString ="assets/icons8-trash-64.png";

    /*
    zatvara dijalog proverava da li je cekirana potvrda za brisanje i pokrece brisanje
     */
    public void finished(String projectName ,
                         boolean areYouSure){
        this.deleteProjectDialog.dispose();
        this.doTheThing(projectName,areYouSure);

    }

    /*
    otvara JDialog u kom nudi odabir projekata koje mozemo odbisati
    ukoliko ne postoji projekat salje gresku
     */
    public void actionPerformed(ActionEvent arg0) {
        try {
            deleteProjectDialog = new DeleteProjectDialog(this);
            deleteProjectDialog.setVisible(true);
        } catch (Exception e) {
            ErrorFactory.getInstance().generateError(MyError.ErrorCode.NO_PROJECT,949);
        }
    }

    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public DeleteProjectAction() {
        putValue(ACCELERATOR_KEY , KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Delete Project");
        putValue(SHORT_DESCRIPTION, "Select Project to delete");
    }

    /*
    ukoliko je selektovan projekat i potvrdjeno brisanje sa Repository ce skloniti projekat tako sto prolazi
    kroz svu decu od workspace i uklanja dete sa istim imenom
    zatim update JTree
     */
    public void doTheThing(String projectName ,
                           boolean areYouSure) {
        if (areYouSure) {
            for (RuNode project : Workspace1.getInstance().getWorkspace().getChildren()) {
                if (project.getName().equals(projectName)) {
                    Workspace1.getInstance().getWorkspace().removeChild(project);
                    break;
                }
                this.i++;
            }
            MainFrame.getInstance().getActionManager().getProjectViewControler().renderProject();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
        }

    }
/*
Implementacja Isubscribera i slanje error poruke
 */
    @Override
    public void update(Object notification) {
        if(((MyError)notification).getEnumCode() == MyError.ErrorCode.NO_PROJECT)
        JOptionPane.showMessageDialog(MainFrame.getInstance(),((MyError)notification).getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }

}