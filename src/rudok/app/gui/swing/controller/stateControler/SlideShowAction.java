package rudok.app.gui.swing.controller.stateControler;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.repository.Workspace1;

import java.awt.event.ActionEvent;

public class SlideShowAction extends AbstractRuDokAction {

    String iconString = "assets/visible--v1.png";

    /*
        Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
        dodeljuje ikonicu
        dodeljuje ime
        i dodeljuje description kada predjemo preko dugmeta
         */
    public SlideShowAction(){
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "Edit State");
        putValue(SHORT_DESCRIPTION, "Changes view into Edit mode");
    }
/*
State manager postavlja curr state u slide show state
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        Workspace1.getInstance().getActivePresentation().gotoSlideShowState();
    }
}
