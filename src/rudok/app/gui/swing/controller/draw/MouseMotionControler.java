package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.controller.comands.AddDeviceCommand;
import rudok.app.gui.swing.tree.view.elements.slide.SlideView;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.grpahics.Slot;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseMotionControler extends MouseAdapter{

    private SlideView slideView;
    private Slot selectedSlot;
    private Slot oldslot;
    Point point;

    public MouseMotionControler(SlideView slideView){
        this.slideView = slideView;
    }

/*
pronalazi slot
selektuje ga
i pomera
 */
    @Override
    public void mousePressed(MouseEvent e) {
        for(Slot slot : slideView.getSlide().getSlotList()){
            if(e.getButton() == MouseEvent.BUTTON1 && slot.getPainter().elementAt(slot,e.getPoint())){
                selectedSlot = slot;
                oldslot = slot;
                point= slot.getPoint();
            }
        }
        if(selectedSlot != null && slideView.getSlide().getSlotList().contains(selectedSlot)) {
            slideView.getSlide().getSlotList().remove(selectedSlot);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(selectedSlot != null){
            selectedSlot.setPoint(e.getPoint().x,e.getPoint().y);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(selectedSlot != null){
            selectedSlot.setPoint(e.getPoint().x,e.getPoint().y);
            slideView.getSlide().getSlotList().add(selectedSlot);
            MainFrame.getInstance().getComandManager().addCommand(new AddDeviceCommand(selectedSlot,point,slideView,2));
        }
    }



    public SlideView getSlideView() {
        return slideView;
    }


}
