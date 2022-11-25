package rudok.app.gui.swing.controller.draw;

import rudok.app.gui.swing.tree.view.elements.slide.SlideView;
import rudok.app.gui.swing.view.Dialog.SlotChangeDialog;
import rudok.app.model.grpahics.Slot;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditControler extends MouseAdapter {

    SlotChangeDialog slotChangeDialog;
    private SlideView slideView;
    private Slot selectedSlot;

    public EditControler(SlideView slideView){
        this.slideView = slideView;
    }

/*
Preko koordinata pronalazi selektovan slot  ukoliko je kliknum MouseButton3 otvara dialog za promenu teksta
 */
    @Override
    public void mousePressed(MouseEvent e) {
        for (Slot slot : slideView.getSlide().getSlotList()) {
            if (e.getButton() == MouseEvent.BUTTON3 && slot.getPainter().elementAt(slot, e.getPoint())) {
                slotChangeDialog = new SlotChangeDialog(this,0);
                slotChangeDialog.setVisible(true);
                selectedSlot = slot;
            }
        }



    }
/*
nakon potvrde u dialogu kupi informacije iz njega i menja teks / vrstu slota
 */
    public void finished(String stringTXT, int type){
        this.slotChangeDialog.dispose();
        if (selectedSlot != null && slideView.getSlide().getSlotList().contains(selectedSlot)) {
            slideView.getSlide().getSlotList().remove(selectedSlot);
        }
        selectedSlot.setName(stringTXT);
        selectedSlot.setType(type);
        selectedSlot.setParent(slideView.getSlide());
        slideView.getSlide().addSlot(selectedSlot);

    }
    /*
    isto kao gore samo sa fontovima
     */

    public void finished(String stringTXT, int type,boolean bold, boolean italic,String font, int size){
        this.slotChangeDialog.dispose();
        if (selectedSlot != null && slideView.getSlide().getSlotList().contains(selectedSlot)) {
            slideView.getSlide().getSlotList().remove(selectedSlot);
        }
        selectedSlot.setName(stringTXT);
        selectedSlot.setType(type);
        selectedSlot.setBold(bold);
        selectedSlot.setItalic(italic);
        selectedSlot.setFont(font);
        selectedSlot.setSize(size);
        selectedSlot.setParent(slideView.getSlide());
        slideView.getSlide().addSlot(selectedSlot);

    }


    public SlideView getSlideView() {
        return slideView;
    }

}
