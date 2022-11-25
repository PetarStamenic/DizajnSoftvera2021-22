package rudok.app.model.grpahics;

import rudok.app.gui.swing.view.paint_Ni_ja_nisam_siguran_kako_ovo_radi.Painter;

import java.awt.*;
import java.io.Serializable;

public class DiagramElement implements Serializable {
    private Stroke stroke;
    private Paint paint;
    private String name;

    protected Painter painter;

    public DiagramElement(Stroke stroke , Paint paint){
        this.stroke = new SerializeStroke(stroke);
        this.paint = paint;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Painter getPainter() {
        return painter;
    }
}
