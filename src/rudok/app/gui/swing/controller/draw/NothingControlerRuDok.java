package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.repository.Workspace1;

import java.awt.event.ActionEvent;

public class NothingControlerRuDok extends AbstractRuDokAction {

    String iconString = "assets/icons8-pointer-64.png";
    @Override
    public void actionPerformed(ActionEvent e) {
        Workspace1.getInstance().getActivePresentation().gotoFreeMouse();
    }

    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public NothingControlerRuDok() {
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Mouse");
        putValue(SHORT_DESCRIPTION, "Regular Old Mouse");
    }

}