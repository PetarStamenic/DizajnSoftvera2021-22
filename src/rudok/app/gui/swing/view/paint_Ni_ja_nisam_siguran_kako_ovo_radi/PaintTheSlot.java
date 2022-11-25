package rudok.app.gui.swing.view.paint_Ni_ja_nisam_siguran_kako_ovo_radi;

import rudok.app.model.grpahics.DiagramElement;
import rudok.app.model.grpahics.Slot;

import java.awt.*;

public class PaintTheSlot extends DevicePainter{


    public PaintTheSlot(DiagramElement diagramElement) {
        super(diagramElement);


        Slot slot = (Slot) diagramElement;

        shape = new Rectangle(slot.getPoint().x,slot.getPoint().y,slot.getDimension().width,slot.getDimension().height);
    }

    public Shape getShape() {
        return shape;
    }
}
