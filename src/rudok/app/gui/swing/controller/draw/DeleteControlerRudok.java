package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.repository.Workspace1;

import java.awt.event.ActionEvent;

public class DeleteControlerRudok extends AbstractRuDokAction {

    String iconString = "assets/icons8-delete-file-50.png";
    /*
            Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
            dodeljuje ikonicu
            dodeljuje ime
            i dodeljuje description kada predjemo preko dugmeta
             */
    public DeleteControlerRudok(){
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete the slot");
    }

    /*
    Implementacija u state sablonu pokrece brisanje slota na klik misa
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Workspace1.getInstance().getActivePresentation().gotoDeleteSlot();
    }
}
