package rudok.app.gui.swing.view.paint_Ni_ja_nisam_siguran_kako_ovo_radi;

import rudok.app.model.grpahics.DiagramDevice;
import rudok.app.model.grpahics.DiagramElement;
import rudok.app.model.grpahics.Slot;

import javax.swing.*;
import java.awt.*;

public class DevicePainter extends Painter{

    protected Shape shape;

    public DevicePainter(DiagramElement diagramElement) {
        super(diagramElement);
    }

    @Override
    public void paint(Graphics2D graphics2D, DiagramElement diagramElement) {

        if(diagramElement instanceof DiagramDevice) {
            graphics2D.setPaint(new Color(255, 255, 255, 0));
            graphics2D.setStroke(diagramElement.getStroke());
            graphics2D.draw(getShape(diagramElement));
            graphics2D.setPaint(diagramElement.getPaint());
            graphics2D.fill(getShape(diagramElement));
            graphics2D.setPaint(Color.BLACK);
            DiagramDevice device = (DiagramDevice) diagramElement;
            if (((Slot) device).getType() == 0) {

                Font font = new Font("Arial",Font.PLAIN,12);
                if(!((Slot) device).isBold() && !((Slot) device).isItalic())
                    font = new Font(((Slot) device).getFont(),Font.PLAIN,((Slot) device).getSize());
                if(((Slot) device).isBold() && !((Slot) device).isItalic())
                    font = new Font(((Slot) device).getFont(),Font.BOLD,((Slot) device).getSize());
                if(!((Slot) device).isBold() && ((Slot) device).isItalic())
                    font = new Font(((Slot) device).getFont(),Font.ITALIC,((Slot) device).getSize());
                if(((Slot) device).isBold() && ((Slot) device).isItalic())
                    font = new Font(((Slot) device).getFont(),Font.BOLD|Font.ITALIC,((Slot) device).getSize());

                double y = device.getPoint().getY();
                for(String line: diagramElement.getName().split("\n")) {
                    y += 2+ ((Slot) device).getSize();
                    graphics2D.setFont(font);
                    graphics2D.drawString(line, (int) device.getPoint().getX() + 10, (int)y);
                }
            } else {
                ImageIcon iicon = new ImageIcon(device.getName());
                Image image = iicon.getImage();
                graphics2D.drawImage(image,(int) device.getPoint().getX(),
                        (int) device.getPoint().getY(),null);
            }
        }
    }

    @Override
    public boolean elementAt(DiagramElement diagramElement, Point position) {
        return getShape(diagramElement).contains(position);
    }

    public Shape getShape(DiagramElement diagramElement) {
        return new PaintTheSlot(diagramElement).getShape();
    }
}
