package rudok.app.gui.swing.view.paint_Ni_ja_nisam_siguran_kako_ovo_radi;

import rudok.app.model.grpahics.DiagramElement;

import java.awt.*;
import java.io.Serializable;

public abstract class Painter implements Serializable {

    private DiagramElement diagramElement;

    public Painter(DiagramElement diagramElement){
    }

    public abstract void paint(Graphics2D graphics2D, DiagramElement diagramElement);

    public abstract boolean elementAt(DiagramElement diagramElement, Point position);

}
