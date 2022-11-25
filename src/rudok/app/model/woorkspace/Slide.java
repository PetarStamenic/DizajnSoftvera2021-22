package rudok.app.model.woorkspace;

import rudok.app.gui.swing.view.MainFrame;
import rudok.app.model.grpahics.Slot;
import rudok.app.repository.Workspace1;

import java.util.ArrayList;
import java.util.List;

public class Slide extends RuNode{

    private int redniBroj;
    private List<Slot> slotList = new ArrayList<>();
    private Slot selectedSlot;

    public Slide(RuNode parent){
        super("Slide");
        this.redniBroj = ((Presentation) parent).getChildren().size()+1;
        this.setParent(parent);
        this.setTYPE("SLIDE");
    }
    @Override
    public String toString() {
        return super.getName()+": "+redniBroj;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public void addSlot(Slot slot){
        this.slotList.add(slot);
        Workspace1.getInstance().getActiveProject().setChanged(true);
        notifzSubscribers("Heathcliff");
    }

    public void removeSlot(Slot slot){
        if(this.slotList.contains(slot)){
            Workspace1.getInstance().getActiveProject().setChanged(true);
            this.slotList.remove(slot);
            notifzSubscribers("Heathcliff");
        }
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public Slot getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(Slot selectedSlot) {
        this.selectedSlot = selectedSlot;
    }
}
