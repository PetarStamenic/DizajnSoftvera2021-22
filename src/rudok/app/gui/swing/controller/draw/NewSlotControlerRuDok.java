package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.controller.AbstractRuDokAction;
import rudok.app.gui.swing.view.Dialog.ColorPickerDialog;
import rudok.app.repository.Workspace1;

import java.awt.*;
import java.awt.event.ActionEvent;

public class NewSlotControlerRuDok extends AbstractRuDokAction {

    String iconString = "assets/icons8-new-view-50.png";
    private ColorPickerDialog colorPickerDialog;
    private Color color;
    private Stroke stroke;

    /*
            Ovaj deo koda slobodno kopiraj ako koristite AbstractRudokAction ili kako vec da ga nazovete
            dodeljuje ikonicu
            dodeljuje ime
            i dodeljuje description kada predjemo preko dugmeta
             */
    public NewSlotControlerRuDok(){
        putValue(SMALL_ICON, loadIcon(iconString));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "Create new Slot");
    }

    /*
    poziva dialog za kreiranje novog slota
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        colorPickerDialog = new ColorPickerDialog(this);
        colorPickerDialog.setVisible(true);

    }
    /*
    prilikom zatvaranja JDialoga proverava vrstu slota koji je odabran kao i outline / color
     */

    public void finished(Color color ,
                         int lineType ){
        this.colorPickerDialog.dispose();
        this.color = color;
        switch (lineType) {
            case 0 -> this.stroke = new BasicStroke(2f);
            case 1 -> this.stroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        }
        Workspace1.getInstance().getActivePresentation().gotoNewSlot(color,stroke);
    }
}
