package rudok.app.gui.swing.controller.comands;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoCommand extends AbstractRuDokAction {

    String iconString = "assets/icons8-redo-50.png";

        /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public RedoCommand(){
        putValue(ACCELERATOR_KEY , KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK ));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    /*
    poziva ComandManager da bi izvrsio redo
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getComandManager().redoCommand();
    }
}
