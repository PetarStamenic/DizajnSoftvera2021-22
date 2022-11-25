package rudok.app.model.grpahics;

import java.awt.*;

public class DiagramDevice extends DiagramElement{

    private Point point;
    private Dimension dimension;

    public DiagramDevice(Stroke stroke, Paint paint, Point point, Dimension size) {
        super(stroke, paint);
        this.point = point;
        this.dimension = size;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
