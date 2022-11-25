package rudok.app.gui.swing.controller.change;

import rudok.app.errorHandler.ErrorFactory;
import rudok.app.errorHandler.MyError;
import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.Dialog.change.ChangeAutorDialog;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.*;
import rudok.app.observer.ISubscriber;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChangeAutorAction extends AbstractRuDokAction implements ISubscriber {

    String iconString = "assets/icons8-author-64.png";
    private ChangeAutorDialog changeAutorDialog;
    /*
    Mnogo mi se svideo JDialog pa sam ga gurao svuda cak i ako nije bilo neophodno
     */

    public void actionPerformed(ActionEvent arg0) {
        /*
        Proveravamo da li je u Jtree selektovana komponenta preko ovog u if
        ukoliko jeste uzimamo i pravimo moj custom JDialog
        ukoliko nije obavestavamo korisnika sa error
         */
        if(MainFrame.getInstance().getWorkspaceTree().getSelectionPath() != null){
            changeAutorDialog = new ChangeAutorDialog(this);
            changeAutorDialog.setVisible(true);
        } else {
            ErrorFactory.getInstance().generateError(MyError.ErrorCode.PRESENTATION_NOT_SELECTED,2);
        }

    }
    public ChangeAutorAction(){
        /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
        ErrorFactory.getInstance().addSubscriber(this);
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Change autor");
        putValue(SHORT_DESCRIPTION, "Change autor of selected presentation");
    }

    /*
    metoda finished mi zatvara jdialog i poziva metodu koja radi promene pomocu stringa
     */
    public void finished(String name ){
        this.changeAutorDialog.dispose();
        this.doTheThing(name);

    }

    /*
    vracam boolean jer sam na pocetku koristio ispis da proverim da li je prosla metoda
     */
    public boolean doTheThing(String name){
        /*
        vraca path do selektovane komponente u stablu
         */
        TreePath selectedPath = MainFrame.getInstance().getWorkspaceTree().getSelectionPath();
        if(selectedPath != null){
            /*
            ukoliko postoji nesto selektovano mozemo slobodno da castujemo u RuNode
            ukoliko je selektovana prezentacija menjamo joj autora i obavestavamo main frame
            u suprotnom izbacujemo gresku da nije selektovana prezentacija
             */
            Object selectedRuNode = selectedPath.getLastPathComponent();
            RuNode node = ((MyTreeNode)selectedRuNode).getRunode();
             if( node instanceof Presentation){
                ((Presentation)node).setAutor(name);
                MainFrame.getInstance().getActionManager().getProjectViewControler().notifzSubscribers("Heathcliff");
                return true;
            } else {
                ErrorFactory.getInstance().generateError(MyError.ErrorCode.PRESENTATION_NOT_SELECTED,8);
            }

            System.out.println(selectedRuNode.toString());
        }
        return false;
    }

/*
implementacija ISubscribera samo preko JOptionPane saljemo error message
 */
    @Override
    public void update(Object notification) {
        if(((MyError)notification).getEnumCode() == MyError.ErrorCode.PRESENTATION_NOT_SELECTED)
        JOptionPane.showMessageDialog(MainFrame.getInstance(),((MyError)notification).getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}