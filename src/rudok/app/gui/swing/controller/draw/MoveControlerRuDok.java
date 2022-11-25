package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.repository.Workspace1;

import java.awt.event.ActionEvent;

public class MoveControlerRuDok extends AbstractRuDokAction {

    public String iconString = "assets/icons8-move-50.png";
    /*
            Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
            dodeljuje ikonicu
            dodeljuje ime
            i dodeljuje description kada predjemo preko dugmeta
             */
    public MoveControlerRuDok(){
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move the slot");
    }

    /*
    preko state sablona prelazi u move state
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Workspace1.getInstance().getActivePresentation().gotoMoveSlot();
    }
}
