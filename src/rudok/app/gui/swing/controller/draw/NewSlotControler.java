package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.controller.comands.AddDeviceCommand;
import rudok.app.gui.swing.tree.view.elements.slide.SlideView;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.grpahics.Slot;
import rudok.app.model.woorkspace.Presentation;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class NewSlotControler extends MouseAdapter {

    private SlideView slideView;
    Point startPoint;

    /*
    prilikom pritiska na dugme kreira novi slot na datoj lokaciji dodeljuje mu roditelja boju outline
    i stavlje def natpis Slot koji se menja kasnije
     */
    public NewSlotControler(SlideView slideView){
        this.slideView = slideView;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        if(e.getButton() == MouseEvent.BUTTON1){
            startPoint = e.getPoint();
            Stroke stroke = ((Presentation)slideView.getSlide().getParent()).getStroke();
             Color color = ((Presentation)slideView.getSlide().getParent()).getColor();
            Point position = e.getPoint();
            System.out.println("Painted");
            Slot slot = new Slot(stroke,color , position , new Dimension(75,50));

            slot.setName("Slot");
            slot.setParent(slideView.getSlide());
            slideView.getSlide().addSlot(slot);
            MainFrame.getInstance().getComandManager().addCommand(new AddDeviceCommand(slot,slideView,0));

        }
    }

    public SlideView getSlideView() {
        return slideView;
    }

    public void setSlideView(SlideView slideView) {
        this.slideView = slideView;
    }


}
