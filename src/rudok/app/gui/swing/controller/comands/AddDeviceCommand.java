package rudok.app.gui.swing.controller.comands;

import rudok.app.gui.swing.tree.view.elements.slide.SlideView;
import rudok.app.model.grpahics.DiagramElement;
import rudok.app.model.grpahics.Slot;
import rudok.app.model.woorkspace.Slide;

import java.awt.*;
import java.awt.geom.Point2D;

public class AddDeviceCommand extends AbstractCommant{

    int type;
    public AddDeviceCommand(Slot slot, SlideView slide, int inti){
        this.slide = slide;
        this.type = inti;
        this.diagramElement = slot;
        this.savedSlot = slot;
    }

    public AddDeviceCommand(Slot savedSlot,Point point, SlideView slide, int inti){
        this.slide = slide;
        this.type = inti;
        this.diagramElement = savedSlot;
        this.savedSlot = savedSlot;
        this.savepoint = point;
        this.newpoint = savedSlot.getPoint();
    }
    SlideView slide;
    DiagramElement diagramElement = null;
    Slot savedSlot;
    private Point newpoint;
    private Point savepoint;


    /*
    Undo za slotove
    case 0 - kreiranje slota
    case 1 - brisanje slota
    case 2 - pomeranje slotova
     */
    @Override
    public void redoCommand() {
            switch (type) {
                case 0: {
                    /*
                    redo radi postavljanje slota koji je prethodno undovan
                     */
                    if (diagramElement == null) {
                        slide.getSlide().addSlot(savedSlot);
                        diagramElement = savedSlot;
                    }
                    break;
                }
                case 1: {
                    /*
                    redo brise slot koji je izbrisan pa uradjen undo
                     */
                    savedSlot = (Slot) diagramElement;
                    slide.getSlide().removeSlot((Slot) diagramElement);
                    diagramElement = null;
                    break;
                }
                case 2:{
                    /*
                    redo pamti poobe pozicije slota i menja ih
                     */
                    slide.getSlide().removeSlot(savedSlot);
                    savedSlot.setPoint(newpoint);
                    slide.getSlide().addSlot(savedSlot);
                    break;
                }

            }
        }
    

/*
Undo za slotove
case 0 - kreiranje slota
case 1 - brisanje slota
case 2 - pomeranje slotova
 */
    @Override
    public void undoCommand() {
        switch (type){
            case 0:{
                /*
                undo bise slot
                 */
                savedSlot = (Slot) diagramElement;
                slide.getSlide().removeSlot((Slot) diagramElement);
                diagramElement = null;
                break;
            }
            case 1:{
                /*
                undo vraca slot
                 */
                slide.getSlide().addSlot(savedSlot);
                diagramElement = savedSlot;
                break;
            }
            case 2:{
                /*
                undo vraca na staru poziciju
                 */
                slide.getSlide().removeSlot(savedSlot);
                savedSlot.setPoint(savepoint);
                slide.getSlide().addSlot(savedSlot);
                break;
            }
        }
    }
}
