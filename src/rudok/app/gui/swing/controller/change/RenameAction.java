package rudok.app.gui.swing.controller.change;

import rudok.app.errorHandler.ErrorFactory;
import rudok.app.errorHandler.MyError;
import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.Dialog.change.RenameDialog;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.woorkspace.*;
import rudok.app.observer.ISubscriber;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RenameAction extends AbstractRuDokAction implements ISubscriber {

    String iconString = "assets/icons8-rename-50.png";
    private RenameDialog renameDialog;

    /*
    Ukoliko je nesto selektovano pokrece JDialog ukoliko nije javlja gresku
     */
    public void actionPerformed(ActionEvent arg0) {
        if(MainFrame.getInstance().getWorkspaceTree().getSelectionPath() != null){
            renameDialog = new RenameDialog(this);
            renameDialog.setVisible(true);
        } else {
            ErrorFactory.getInstance().generateError(MyError.ErrorCode.NOTHING_SELECTED,7);
        }


    }
    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public RenameAction(){
        ErrorFactory.getInstance().addSubscriber(this);
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename node");
    }
/*
zatvara jdialog i izvrsava promenu
 */
    public void finished(String name ){
        this.renameDialog.dispose();
        this.doTheThing(name);

    }
/*
Ukoliko proverava koja je vrsta RuNode i menja ime
 */
    public boolean doTheThing(String name){
        TreePath selectedPath = MainFrame.getInstance().getWorkspaceTree().getSelectionPath();
        if(selectedPath != null){
            Object selectedRuNode = selectedPath.getLastPathComponent();
            RuNode node = ((MyTreeNode)selectedRuNode).getRunode();
            if(node instanceof Slide){
                ((Slide)node).setName(name);
                MainFrame.getInstance().getActionManager().getProjectViewControler().notifzSubscribers("Heathcliff");
                return true;
            } else if( node instanceof Presentation){
                ((Presentation)node).setName(name);
                MainFrame.getInstance().getActionManager().getProjectViewControler().notifzSubscribers("Heathcliff");
                return true;
            } else if(node instanceof Project){
                ((Project)node).setName(name);
                MainFrame.getInstance().getActionManager().getProjectViewControler().notifzSubscribers("Heathcliff");
                return true;
            } else if(node instanceof Workspace){
                ((Workspace)node).setName(name);
                MainFrame.getInstance().getActionManager().getProjectViewControler().notifzSubscribers("Heathcliff");
                return true;
            }

            System.out.println(selectedRuNode.toString());
        }
    return false;
    }

/*
Implementacija ISubscriber i javljanje greske preko JoptionPane
 */
    @Override
    public void update(Object notification) {
        if(((MyError)notification).getEnumCode() == MyError.ErrorCode.NOTHING_SELECTED)
        JOptionPane.showMessageDialog(MainFrame.getInstance(),((MyError)notification).getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}
