package rudok.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractRuDokAction {
    String iconString = "assets/icons8-exit-60.png";

    public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }

    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public ExitAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }

}
