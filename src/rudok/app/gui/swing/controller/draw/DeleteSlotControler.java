package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.controller.comands.AddDeviceCommand;
import rudok.app.gui.swing.tree.view.elements.slide.SlideView;
import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.grpahics.Slot;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteSlotControler extends MouseAdapter{

    private SlideView slideView;
    private Slot selectedSlot;

    public DeleteSlotControler(SlideView slideView) {
        this.slideView = slideView;
    }
/*
na pritisak misa prolazi kroz slotove i uporedjuje koordinate i brise slot koji obuhvata koordinate misa prilikom klika
 */
    @Override
    public void mousePressed(MouseEvent e) {
        for(Slot slot : slideView.getSlide().getSlotList()){
            if(e.getButton() == MouseEvent.BUTTON1 && slot.getPainter().elementAt(slot,e.getPoint())){
                selectedSlot = slot;
            }
        }
        if(selectedSlot != null && slideView.getSlide().getSlotList().contains(selectedSlot)){
            MainFrame.getInstance().getComandManager().addCommand(new AddDeviceCommand(selectedSlot ,slideView,1));
            slideView.getSlide().removeSlot(selectedSlot);
        }
    }

    public SlideView getSlideView() {
        return slideView;
    }

}
