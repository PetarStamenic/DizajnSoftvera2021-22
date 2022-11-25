package rudok.app.model.woorkspace;

import rudok.app.gui.swing.controller.state.slideshow.SlideStateManager;
import rudok.app.gui.swing.controller.state.slot.SlotStateManager;

import javax.swing.*;
import java.awt.*;

public class Presentation extends RuNodeComp{

    private String state = "EDIT";
    private transient SlideStateManager slideStateManager = new SlideStateManager();
    private transient SlotStateManager slotStateManager = new SlotStateManager();
    private transient Color color;
    private transient Stroke stroke;


public Presentation(RuNode parent,String name,String autor,String imageURL){
    super(name);
    this.setAutor(autor);
    this.setImageURL(imageURL);
    this.setParent(parent);
    this.setTYPE("PRESENTATION");
    slotStateManager.setFreeHandTool();
}

    private String autor;
    private String imageURL = "assets/Ja.jpg";

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifzSubscribers("Heathcliff");
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
        notifzSubscribers("Heathcliff");
    }

    @Override
    public void addChild(RuNode child) {
        super.addChild(child);
        notifzSubscribers("Heathcliff");
    }

    public String getState() {
        return state;
    }

    public void setState() {
        this.state = slideStateManager.getCurrState().setState();
    }

    public void gotoEditState(){
        if(this.slideStateManager == null)
            this.slideStateManager = new SlideStateManager();
        this.slideStateManager.setEditSlideState();
        this.setState();
        notifzSubscribers("Heathcliff");
    }

    public void gotoSlideShowState(){
        if(this.slideStateManager == null)
            this.slideStateManager = new SlideStateManager();
        this.slideStateManager.setSlideShowState();
        this.slotStateManager.setFreeHandTool();
        this.setState();
        notifzSubscribers("Heathcliff");
    }

    public void gotoFreeMouse(){
        if(this.slotStateManager == null)
            this.slotStateManager = new SlotStateManager();
        this.slotStateManager.setFreeHandTool();
        notifzSubscribers("Heathcliff");
    }

    public void gotoNewSlot(Color color, Stroke stroke){
        if(this.slotStateManager == null)
            this.slotStateManager = new SlotStateManager();
        this.slotStateManager.setCreateNewSlot();
        notifzSubscribers("Heathcliff");
        this.color = color;
        this.stroke = stroke;
    }

    public void gotoMoveSlot(){
        if(this.slotStateManager == null)
            this.slotStateManager = new SlotStateManager();
        this.slotStateManager.setMoveSlot();
        notifzSubscribers("Heathcliff");
    }

    public void gotoDeleteSlot(){
        if(this.slotStateManager == null)
            this.slotStateManager = new SlotStateManager();
        this.slotStateManager.setDeleteSlot();
        notifzSubscribers("Heathcliff");
    }

    public SlotStateManager getSlotStateManager() {
        return slotStateManager;
    }

    public void setSlotStateManager(){
        this.slotStateManager = new SlotStateManager();
    }

    public Color getColor() {
        return color;
    }

    public Stroke getStroke() {
        return stroke;
    }
}
