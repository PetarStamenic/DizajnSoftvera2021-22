package rudok.app.gui.swing.controller.change;

import rudok.app.errorHandler.ErrorFactory;
import rudok.app.errorHandler.MyError;
import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.Dialog.change.ChangeBackgroundDialog;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.*;
import rudok.app.observer.ISubscriber;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChangeBackgroundAction extends AbstractRuDokAction implements ISubscriber {

    String iconString = "assets/icons8-wallpaper-50.png";
    private ChangeBackgroundDialog changeBackgroundDialog;
/*
proveravamo da li je nesto selektovano u Jtree ukoliok jeste otvaramo Jdialog za promenu pozadine
ukoliko nije errorfactory pravi poruku
 */
    public void actionPerformed(ActionEvent arg0) {
        if(MainFrame.getInstance().getWorkspaceTree().getSelectionPath() != null){
            changeBackgroundDialog = new ChangeBackgroundDialog(this);
            changeBackgroundDialog.setVisible(true);
        } else {
            ErrorFactory.getInstance().generateError(MyError.ErrorCode.PRESENTATION_NOT_SELECTED,3);
        }

    }
    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public ChangeBackgroundAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Change background");
        putValue(SHORT_DESCRIPTION, "Change background for slides of selected presentation");
    }

    /*
    gasi JDialog i izvrsava promenu pozadine
     */
    public void finished(String name ){
        this.changeBackgroundDialog.dispose();
        this.doTheThing(name);

    }
/*
ukoliko je selektovano nesto ulazimo u petlju gde kreiramo lokalnu promenljivu za nas RuNode
ukoliko je selektovana prezentaija menjamo URL slike na zadati i saljemo obavestenje da se MainFrame refresh
u suprotnom errorFactory obavestava gresku
 */
    public boolean doTheThing(String name){
        TreePath selectedPath = MainFrame.getInstance().getWorkspaceTree().getSelectionPath();
        if(selectedPath != null){
            Object selectedRuNode = selectedPath.getLastPathComponent();
            RuNode node = ((MyTreeNode)selectedRuNode).getRunode();
            if( node instanceof Presentation){
                ((Presentation)node).setImageURL(name);
                MainFrame.getInstance().getActionManager().getProjectViewControler().notifzSubscribers("Heathcliff");
                return true;
            } else {
                ErrorFactory.getInstance().generateError(MyError.ErrorCode.PRESENTATION_NOT_SELECTED,9);
            }

            System.out.println(selectedRuNode.toString());
        }
        return false;
    }

/*
Implementacija ISubscribera i prikayivanje greske
 */
    @Override
    public void update(Object notification) {
        if(((MyError)notification).getEnumCode() == MyError.ErrorCode.PRESENTATION_NOT_SELECTED)
            JOptionPane.showMessageDialog(MainFrame.getInstance(),((MyError)notification).getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}