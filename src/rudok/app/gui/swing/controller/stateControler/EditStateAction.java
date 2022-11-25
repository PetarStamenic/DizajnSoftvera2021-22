package rudok.app.gui.swing.controller.stateControler;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.repository.Workspace1;

import java.awt.event.ActionEvent;

public class EditStateAction extends AbstractRuDokAction {

    String iconString = "assets/icons8-edit-property-50.png";

    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public EditStateAction(){
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Edit State");
        putValue(SHORT_DESCRIPTION, "Changes view into Edit mode");
    }

    /*
    State manager postavlja curr state u edit state
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Workspace1.getInstance().getActivePresentation().gotoEditState();
    }
}
