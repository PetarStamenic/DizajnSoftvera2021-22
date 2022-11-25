package rudok.app.gui.swing.controller;

import rudok.app.gui.swing.view.Dialog.InfoDialog;
import rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractRuDokAction{

    String iconString = "assets/icons8-info-50.png";

    public void actionPerformed(ActionEvent arg0) {
        InfoDialog info = new InfoDialog(MainFrame.getInstance(),"Info");
        info.setVisible(true);

    }
    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje keybind
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public InfoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }
}
