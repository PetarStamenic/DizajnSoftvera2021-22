package rudok.app.gui.swing.controller.create;

import rudok.app.errorHandler.ErrorFactory;
import rudok.app.errorHandler.MyError;
import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.controller.factories.newActionFactory_NIJE_NAJBOLJI_FACTORY.NewActionFactory;
import rudok.app.gui.swing.tree.MyTreeNode;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewCreateAction extends AbstractRuDokAction {

    String iconString = "assets/icons8-new-file-50.png";

    /*
    Proverava da li je selektovano nesto u ukoliko nije vraca gresku
    ukoliko jeste pokrece Factory za novi TreeNode u zavisnosti od toga sta je selektovano
     */
    public void actionPerformed(ActionEvent arg0) {
        MyTreeNode selected = (MyTreeNode)MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
        try {
            NewActionFactory.createNewTreeNode(selected).createTreeNode();
        } catch (NullPointerException e){
            ErrorFactory.getInstance().generateError(MyError.ErrorCode.NOTHING_SELECTED,1);
        }
    }

        /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public NewCreateAction(){
        putValue(ACCELERATOR_KEY , KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "Create New ");
    }
}
