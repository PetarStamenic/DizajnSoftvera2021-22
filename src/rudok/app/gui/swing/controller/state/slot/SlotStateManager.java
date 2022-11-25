package rudok.app.gui.swing.controller.state.slot;

public class SlotStateManager{

    private SlotSelected currSelected = new FreeHandTool();
    private CreateNewSlot createNewSlot;
    private DeleteSlot deleteSlot;
    private MoveSlot moveSlot;
    private FreeHandTool freeHandTool;

    public SlotStateManager(){
        init();
    }

    public void init(){
        createNewSlot = new CreateNewSlot();
        deleteSlot = new DeleteSlot();
        moveSlot = new MoveSlot();
    }

    /*
    Klasa koja u savisnosti od selektovanog state za rad sa slotovima postavlja current state u selektovani
     */

    public SlotSelected getCurrSelected() {
        return currSelected;
    }

    public void setCreateNewSlot() {
        this.currSelected = createNewSlot;
    }

    public void setDeleteSlot() {
        this.currSelected = deleteSlot;
    }

    public void setMoveSlot() {
        this.currSelected = moveSlot;
    }

    public void setFreeHandTool() {
        this.currSelected = freeHandTool;
    }
}
