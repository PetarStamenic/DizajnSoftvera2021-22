package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.tree.view.elements.slide.SlideView;
import rudok.app.model.grpahics.Slot;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectedSlotControler extends MouseAdapter {

    private SlideView slideView;
    private Slot selectedSlot;

    public SelectedSlotControler(SlideView slideView){
        this.slideView = slideView;
    }

/*
Obican mis nista ne radi na klik
 */
    @Override
    public void mousePressed(MouseEvent e) {
        for(Slot slot : slideView.getSlide().getSlotList()){
            if(e.getButton() == MouseEvent.BUTTON1 && slot.getPainter().elementAt(slot,e.getPoint())){
                selectedSlot = slot;
            }
        }
    }

}
